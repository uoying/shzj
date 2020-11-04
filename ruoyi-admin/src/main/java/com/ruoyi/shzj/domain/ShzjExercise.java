package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 shzj_exercise
 * 
 * @author ruoyi
 * @date 2020-08-18
 */
public class ShzjExercise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 题目编号 */
    private Integer exeId;

    /** 题目 */
    @Excel(name = "题目")
    private String subject;

    /** 选项A */
    @Excel(name = "选项A")
    private String choiceA;

    /** 选项B */
    @Excel(name = "选项B")
    private String choiceB;

    /** 选项C */
    @Excel(name = "选项C")
    private String choiceC;

    /** 选项D */
    @Excel(name = "选项D")
    private String choiceD;

    /** 审核状态（0-审核中，1-通过，2-为通过） */
    @Excel(name = "审核状态", readConverterExp = "0=-审核中，1-通过，2-为通过")
    private Integer status;

    /** 答案 */
    @Excel(name = "答案")
    private String answer;

    /** 发布者 */
    @Excel(name = "发布者")
    private Long author;

    /** 解析 */
    @Excel(name = "解析")
    private String parse;

    /** 声音url */
    @Excel(name = "声音url")
    private String voiceUrl;

    /** 题目类型（1-选你所选 2-你一句我一句 3-图片连一连 4-是否题 */
    @Excel(name = "题目类型", readConverterExp = "题目类型（1-选你所选 2-你一句我一句 3-图片连一连 4-是否题")
    private Long judge;

    public void setExeId(Integer exeId) 
    {
        this.exeId = exeId;
    }

    public Integer getExeId() 
    {
        return exeId;
    }
    public void setSubject(String subject) 
    {
        this.subject = subject;
    }

    public String getSubject() 
    {
        return subject;
    }
    public void setChoiceA(String choiceA) 
    {
        this.choiceA = choiceA;
    }

    public String getChoiceA() 
    {
        return choiceA;
    }
    public void setChoiceB(String choiceB) 
    {
        this.choiceB = choiceB;
    }

    public String getChoiceB() 
    {
        return choiceB;
    }
    public void setChoiceC(String choiceC) 
    {
        this.choiceC = choiceC;
    }

    public String getChoiceC() 
    {
        return choiceC;
    }
    public void setChoiceD(String choiceD) 
    {
        this.choiceD = choiceD;
    }

    public String getChoiceD() 
    {
        return choiceD;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setAuthor(Long author) 
    {
        this.author = author;
    }

    public Long getAuthor() 
    {
        return author;
    }
    public void setParse(String parse) 
    {
        this.parse = parse;
    }

    public String getParse() 
    {
        return parse;
    }
    public void setVoiceUrl(String voiceUrl) 
    {
        this.voiceUrl = voiceUrl;
    }

    public String getVoiceUrl() 
    {
        return voiceUrl;
    }
    public void setJudge(Long judge) 
    {
        this.judge = judge;
    }

    public Long getJudge() 
    {
        return judge;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("exeId", getExeId())
            .append("subject", getSubject())
            .append("choiceA", getChoiceA())
            .append("choiceB", getChoiceB())
            .append("choiceC", getChoiceC())
            .append("choiceD", getChoiceD())
            .append("status", getStatus())
            .append("answer", getAnswer())
            .append("author", getAuthor())
            .append("parse", getParse())
            .append("voiceUrl", getVoiceUrl())
            .append("judge", getJudge())
            .toString();
    }
}
