package com.zxy.bil.service.impl;

import com.zxy.bil.dao.IQuestionDao;
import com.zxy.bil.pojo.Question;
import com.zxy.bil.service.IQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: Question操作服务类实现
 * </p>
 * @date 2018/10/29 21:44
 */
@Service("questionService")
@Transactional(rollbackFor = Exception.class)
public class QuestionServiceImpl implements IQuestionService {
    @Resource
    private IQuestionDao questionDao;

    @Override
    public Question getQuestion() {
        return questionDao.getQuestion();
    }

    @Override
    public int insertQuestion(Question question) throws Exception {
        return questionDao.insertQuestion(question);
    }
}