package com.zxy.bil.service.impl;

import com.zxy.bil.dao.IAnswerDao;
import com.zxy.bil.pojo.Answer;
import com.zxy.bil.service.IAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hiYuzu
 * @version V1.0
 * @description
 * @date 2019/4/22 13:35
 */
@Service("answerService")
public class AnswerServiceImpl implements IAnswerService {
    @Resource
    private IAnswerDao answerDao;

    @Override
    public int insertAnswer(Answer answer) {
        return answerDao.insertAnswer(answer);
    }
}
