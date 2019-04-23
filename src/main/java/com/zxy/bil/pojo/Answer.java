package com.zxy.bil.pojo;

import com.zxy.bil.util.DefaultArgument;

/**
 * @author hiYuzu
 * @version V1.0
 * @description
 * @date 2019/4/22 11:47
 */
public class Answer extends BasePojo {
    private int answerId = DefaultArgument.INT_DEFAULT;
    private Integer questionId;
    private String answer;
    private String remoteAddr;
    private String realIp;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getRealIp() {
        return realIp;
    }

    public void setRealIp(String realIp) {
        this.realIp = realIp;
    }
}
