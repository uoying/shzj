package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专题信息对象 shzj_features
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public class ShzjFeatures extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专题内容编号 */
    private Integer conId;

    /** 专题内容标题 */
    @Excel(name = "专题内容标题")
    private String conTitle;

    /** 专题内容城市 */
    @Excel(name = "专题内容城市")
    private String conCity;

    /** 建议游玩天数 */
    @Excel(name = "建议游玩天数")
    private String recommendDays;

    /** 感兴趣数 */
    @Excel(name = "感兴趣数")
    private String enjoyNum;

    /** 专题类型 */
    @Excel(name = "专题类型")
    private String feaType;

    /** 专题内容路径 */
    @Excel(name = "专题内容路径")
    private String conUrl;

    /** 图片url */
    @Excel(name = "图片url")
    private String picUrl;

    public void setConId(Integer conId) 
    {
        this.conId = conId;
    }

    public Integer getConId() 
    {
        return conId;
    }
    public void setConTitle(String conTitle) 
    {
        this.conTitle = conTitle;
    }

    public String getConTitle() 
    {
        return conTitle;
    }
    public void setConCity(String conCity) 
    {
        this.conCity = conCity;
    }

    public String getConCity() 
    {
        return conCity;
    }
    public void setRecommendDays(String recommendDays) 
    {
        this.recommendDays = recommendDays;
    }

    public String getRecommendDays() 
    {
        return recommendDays;
    }
    public void setEnjoyNum(String enjoyNum) 
    {
        this.enjoyNum = enjoyNum;
    }

    public String getEnjoyNum() 
    {
        return enjoyNum;
    }
    public void setFeaType(String feaType) 
    {
        this.feaType = feaType;
    }

    public String getFeaType() 
    {
        return feaType;
    }
    public void setConUrl(String conUrl) 
    {
        this.conUrl = conUrl;
    }

    public String getConUrl() 
    {
        return conUrl;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("conId", getConId())
            .append("conTitle", getConTitle())
            .append("conCity", getConCity())
            .append("recommendDays", getRecommendDays())
            .append("enjoyNum", getEnjoyNum())
            .append("feaType", getFeaType())
            .append("conUrl", getConUrl())
            .append("picUrl", getPicUrl())
            .toString();
    }
}
