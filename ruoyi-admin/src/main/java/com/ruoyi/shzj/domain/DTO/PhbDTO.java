package com.ruoyi.shzj.domain.DTO;

import com.ruoyi.shzj.util.VariableName;

/**
 * @author PhbDTO
 */
public class PhbDTO {
    private String userId,userName,headPortrait,answerNumber,integral;

    @Override
    public String toString() {
        return "PhbDTO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", answerNumber='" + answerNumber + '\'' +
                ", integral='" + integral + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadPortrait() {
        return VariableName.domain+headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(String answerNumber) {
        this.answerNumber = answerNumber;
    }
}
