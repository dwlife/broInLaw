package com.zxy.bil.controller;

import com.zxy.bil.model.ResultModel;
import com.zxy.bil.pojo.Answer;
import com.zxy.bil.service.IAnswerService;
import com.zxy.bil.service.IQuestionService;
import com.zxy.bil.util.IpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author hiYuzu
 * @version V1.0
 * @description 游客回答采集
 * @date 2019/4/22 11:33
 */
@Controller
@RequestMapping("/AnswerController")
public class AnswerController {
    /**
     * 日志输出标记
     */
    private static final String LOG = "AnswerController";

    /**
     * 声明日志对象
     */
    private static Logger logger = Logger.getLogger(AnswerController.class);
    /**
     * 声明服务
     */
    @Resource
    private IAnswerService answerService;

    @Resource
    private IQuestionService questionService;

    @RequestMapping(value = "/insertAnswer")
    public @ResponseBody
    ResultModel insertAnswer(@RequestParam(value = "answerText") String answerText, HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        try {
            Answer answer = new Answer();
            answer.setAnswer(answerText);
            answer.setRemoteAddr(request.getRemoteAddr());
            answer.setRealIp(IpUtil.getClientIp(request));
            answer.setQuestionId(questionService.getQuestion().getQuestionId());
            int result = answerService.insertAnswer(answer);
            if (result > 0) {
                resultModel.setResult(true);
                resultModel.setDetail("操作成功!");
            } else {
                resultModel.setResult(false);
                resultModel.setDetail("操作成功");
            }
        } catch (Exception e) {
            resultModel.setResult(false);
            resultModel.setDetail("操作成功，失败信息" + e.getMessage());
            logger.error(LOG + "操作成功,失败信息：" + e.getMessage());
        }
        return resultModel;
    }

}
