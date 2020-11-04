package com.ruoyi.shzj.domain.DTO;

public class AnswerDTO {

    private String exeId,answer,parse, voiceUrl,author,userName;

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "exeId='" + exeId + '\'' +
                ", answer='" + answer + '\'' +
                ", parse='" + parse + '\'' +
                ", voiceUrl='" + voiceUrl + '\'' +
                ", author='" + author + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getExeId() {
        return exeId;
    }

    public void setExeId(String exeId) {
        this.exeId = exeId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getParse() {
        return parse;
    }

    public void setParse(String parse) {
        this.parse = parse;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }
}
