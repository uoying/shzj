package com.ruoyi.shzj.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 攻略信息对象 shzj_strategy
 * 
 * @author ruoyi
 * @date 2020-08-05
 */
public class ShzjStrategy
{
    private static final long serialVersionUID = 1L;

    /** 攻略编号 */
    private Integer strategyId;

    /** 攻略标题 */
    @Excel(name = "攻略标题")
    private String strategyTitle;

    /** 攻略评分 */
    @Excel(name = "攻略评分")
    private BigDecimal strategyGrade;

    /** 评论数 */
    @Excel(name = "评论数")
    private String commentNum;

    /** 喜欢数 */
    @Excel(name = "喜欢数")
    private String enjoyNum;

    /** 景区评级 */
    @Excel(name = "景区评级")
    private String scenicGrade;

    /** 景区称号 */
    @Excel(name = "景区称号")
    private String scenicHonor;

    /** 内容URL */
    @Excel(name = "内容URL")
    private String contentUrl;

    /** 攻略类型 */
    @Excel(name = "攻略类型")
    private String strategyType;

    /** 图片URL */
    @Excel(name = "图片URL")
    private String picUrl;

    /** 城市编号 */
    @Excel(name = "城市编号")
    private Integer cityId;

    public void setStrategyId(Integer strategyId) 
    {
        this.strategyId = strategyId;
    }

    public Integer getStrategyId() 
    {
        return strategyId;
    }
    public void setStrategyTitle(String strategyTitle) 
    {
        this.strategyTitle = strategyTitle;
    }

    public String getStrategyTitle() 
    {
        return strategyTitle;
    }
    public void setStrategyGrade(BigDecimal strategyGrade) 
    {
        this.strategyGrade = strategyGrade;
    }

    public BigDecimal getStrategyGrade() 
    {
        return strategyGrade;
    }
    public void setCommentNum(String commentNum) 
    {
        this.commentNum = commentNum;
    }

    public String getCommentNum() 
    {
        return commentNum;
    }
    public void setEnjoyNum(String enjoyNum) 
    {
        this.enjoyNum = enjoyNum;
    }

    public String getEnjoyNum() 
    {
        return enjoyNum;
    }
    public void setScenicGrade(String scenicGrade) 
    {
        this.scenicGrade = scenicGrade;
    }

    public String getScenicGrade() 
    {
        return scenicGrade;
    }
    public void setScenicHonor(String scenicHonor) 
    {
        this.scenicHonor = scenicHonor;
    }

    public String getScenicHonor() 
    {
        return scenicHonor;
    }
    public void setContentUrl(String contentUrl) 
    {
        this.contentUrl = contentUrl;
    }

    public String getContentUrl() 
    {
        return contentUrl;
    }
    public void setStrategyType(String strategyType) 
    {
        this.strategyType = strategyType;
    }

    public String getStrategyType() 
    {
        return strategyType;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }
    public void setCityId(Integer cityId) 
    {
        this.cityId = cityId;
    }

    public Integer getCityId() 
    {
        return cityId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("strategyId", getStrategyId())
            .append("strategyTitle", getStrategyTitle())
            .append("strategyGrade", getStrategyGrade())
            .append("commentNum", getCommentNum())
            .append("enjoyNum", getEnjoyNum())
            .append("scenicGrade", getScenicGrade())
            .append("scenicHonor", getScenicHonor())
            .append("contentUrl", getContentUrl())
            .append("strategyType", getStrategyType())
            .append("picUrl", getPicUrl())
            .append("cityId", getCityId())
            .toString();
    }
}
