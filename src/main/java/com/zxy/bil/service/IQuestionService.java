package com.zxy.bil.service;

import com.zxy.bil.pojo.Question;

import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: Question操作服务类接口
 * </p>
 * @date 2018/10/29 21:42
 */

public interface IQuestionService {

    /**
     * <p>
     *
     * @return
     * @Description: 查询question数据
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:42
     */
    Question getQuestion();

    /**
     * <p>
     *
     * @param question
     * @return
     * @throws Exception
     * @Description 插入question数据
     * </p>
     * @author hiYuzu
     * @data 2018/11/5 8:39
     */
    int insertQuestion(Question question) throws Exception;
}