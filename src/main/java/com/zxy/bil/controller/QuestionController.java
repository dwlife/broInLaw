package com.zxy.bil.controller;

import com.zxy.bil.model.ResultListModel;
import com.zxy.bil.model.ResultModel;
import com.zxy.bil.model.QuestionModel;
import com.zxy.bil.pojo.Question;
import com.zxy.bil.service.IQuestionService;
import com.zxy.bil.util.DateUtil;
import com.zxy.bil.util.DefaultArgument;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @discription question留言处理
 * </p>
 * @author: hiYuzu
 * @date: 2018/10/29 21:26
 */

@Controller
@RequestMapping("/QuestionController")
public class QuestionController {
    /**
     * 日志输出标记
     */
    private static final String LOG = "QuestionController";

    /**
     * 声明日志对象
     */
    private static Logger logger = Logger.getLogger(QuestionController.class);

    /**
     * 声明服务
     */
    @Resource
    private IQuestionService questionService;

    /**
     * <p>
     *
     * @return
     * @Description: 查询question信息
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:26
     */
    @RequestMapping(value = "/getQuestion")

    public @ResponseBody
    ResultListModel<QuestionModel> getQuestion() {
        ResultListModel<QuestionModel> resultListModel = new ResultListModel<QuestionModel>();
        List<QuestionModel> listQuestionModel = new ArrayList<QuestionModel>();
        Question question;
        question = questionService.getQuestion();
        QuestionModel questionModel = convertQuestionModel(question);
        if (questionModel != null) {
            listQuestionModel.add(questionModel);
        }
        resultListModel.setRows(listQuestionModel);
        resultListModel.setResult(true);
        return resultListModel;
    }

    /**
     * <p>
     *
     * @return
     * @Description: 插入question信息
     * </p>
     * @author hiYuzu
     * @date
     */
    @RequestMapping(value = "/insertQuestion", method = {RequestMethod.POST})
    public @ResponseBody
    ResultModel insertQuestion(HttpSession session, QuestionModel questionModel) {
        if (session.getAttribute(DefaultArgument.LOGIN_USER) == null) {
            return null;
        }
        ResultModel resultModel = new ResultModel();
        if (questionModel != null) {
            try {
                Question question;
                question = convertQuestion(questionModel);
                int result = questionService.insertQuestion(question);
                if (result > 0) {
                    resultModel.setResult(true);
                    resultModel.setDetail("更新成功!");
                } else {
                    resultModel.setResult(false);
                    resultModel.setDetail("更新失败");
                }
            } catch (Exception e) {
                resultModel.setResult(false);
                resultModel.setDetail("更新失败，失败信息" + e.getMessage());
                logger.error(LOG + "更新失败,失败信息：" + e.getMessage());
            }
        }
        return resultModel;
    }


    /**
     * <p>
     *
     * @param questionModel
     * @return
     * @Description: 将QuestionModel转为Question
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:47
     */
    private Question convertQuestion(QuestionModel questionModel) {
        Question question = new Question();
        if (questionModel != null) {
            question.setQuestionText(questionModel.getQuestionText());
            question.setAnswerText(questionModel.getAnswerText());
            question.setTailNote(questionModel.getTailNote());
        }
        return question;
    }

    /**
     * <p>
     *
     * @param question
     * @return
     * @Description: 将Question转为QuestionModel
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:47
     */
    private QuestionModel convertQuestionModel(Question question) {
        QuestionModel questionModel = new QuestionModel();
        if (question != null) {
            questionModel.setQuestionId(String.valueOf(question.getQuestionId()));
            questionModel.setQuestionText(question.getQuestionText());
            questionModel.setAnswerText(question.getAnswerText());
            if (question.getTailNote() != null) {
                questionModel.setTailNote(question.getTailNote());
            }
            questionModel.setOptTime(DateUtil.timestampToString(question.getOptTime()));
        }
        return questionModel;
    }
}
