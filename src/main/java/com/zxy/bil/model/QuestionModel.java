package com.zxy.bil.model;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: QuestionModel
 * </p>
 * @date 2018/10/29 21:38
 */

public class QuestionModel {
    private String questionId;
    private String questionText;
    private String answerText;
    private String tailNote;
    private String optTime;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
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

    public String getOptTime() {
        return optTime;
    }

    public void setOptTime(String optTime) {
        this.optTime = optTime;
    }
}