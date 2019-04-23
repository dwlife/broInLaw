package com.zxy.bil.pojo;

import com.zxy.bil.util.DefaultArgument;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: QuestionPojo
 * </p>
 * @date 2018/10/29 21:40
 */

public class Question extends BasePojo {
    private Integer questionId = DefaultArgument.INT_DEFAULT;
    private String questionText;
    private String answerText;
    private String tailNote;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getTailNote() {
        return tailNote;
    }

    public void setTailNote(String tailNote) {
        this.tailNote = tailNote;
    }

}