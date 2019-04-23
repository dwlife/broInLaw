package com.zxy.bil.service;

import com.zxy.bil.pojo.Answer;

/**
 * @author hiYuzu
 * @version V1.0
 * @description
 * @date 2019/4/22 11:55
 */
public interface IAnswerService {
    /**
     * 记录回答
     * @param answer
     * @return
     */
    int insertAnswer(Answer answer);
}
