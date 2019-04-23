package com.zxy.bil.dao;

import com.zxy.bil.pojo.Answer;
import org.apache.ibatis.annotations.Param;

/**
 * @author hiYuzu
 * @version V1.0
 * @description
 * @date 2019/4/22 13:38
 */
public interface IAnswerDao {
    /**
     * 记录回答
     * @param answer
     * @return
     */
    int insertAnswer(@Param("answer") Answer answer);
}
