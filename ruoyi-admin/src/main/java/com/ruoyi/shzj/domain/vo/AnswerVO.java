package com.ruoyi.shzj.domain.vo;

import com.ruoyi.shzj.domain.DTO.AnswerDTO;

/**
 * @author
 */
public class AnswerVO {
    private String headPortrait;
    private String gradeUrl;
    private String actionForce;

    @Override
    public String toString() {
        return "AnswerVO{" +
                "headPortrait='" + headPortrait + '\'' +
                ", gradeUrl='" + gradeUrl + '\'' +
                ", actionForce='" + actionForce + '\'' +
                '}';
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getGradeUrl() {
        return gradeUrl;
    }

    public void setGradeUrl(String gradeUrl) {
        this.gradeUrl = gradeUrl;
    }

    public String getActionForce() {
        return actionForce;
    }

    public void setActionForce(String actionForce) {
        this.actionForce = actionForce;
    }

}
