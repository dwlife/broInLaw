package com.zxy.bil.dao;

import com.zxy.bil.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: Question数据库操作接口
 * </p>
 * @date 2018/10/29 21:33
 */
public interface IQuestionDao {

    /**
     * <p>
     *
     * @return
     * @Description: 查询Question数据
     * </p>
     * @author hiYuzu
     * @date 2018/10/29 21:33
     */
    Question getQuestion();

    /**
     * <p>
     *
     * @param question
     * @return
     * @Description: 插入question数据
     * </p>
     * @author hiYuzu
     * @data 2018/11/5 8:52
     */
    int insertQuestion(@Param("question") Question question);
}