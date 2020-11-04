package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 话题信息对象 shzj_topic
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
public class ShzjTopic
{
    private static final long serialVersionUID = 1L;

    /** 话题编号 */
    private Integer topicId;

    /** 话题名称 */
    @Excel(name = "话题名称")
    private String topicName;

    /** 动态数量 */
    @Excel(name = "动态数量")
    private Integer articleNum;

    /** 浏览数量 */
    @Excel(name = "浏览数量")
    private Integer browseNum;

    private Integer actionNum;

    /** 背景图url */
    @Excel(name = "背景图url")
    private String picUrl;

    /** 话题类型 */
    @Excel(name = "话题类型")
    private String topicType;

    public Integer getActionNum() {
        return actionNum;
    }

    public void setActionNum(Integer actionNum) {
        this.actionNum = actionNum;
    }

    public void setTopicId(Integer topicId)
    {
        this.topicId = topicId;
    }

    public Integer getTopicId() 
    {
        return topicId;
    }
    public void setTopicName(String topicName) 
    {
        this.topicName = topicName;
    }

    public String getTopicName() 
    {
        return topicName;
    }
    public void setArticleNum(Integer articleNum) 
    {
        this.articleNum = articleNum;
    }

    public Integer getArticleNum() 
    {
        return articleNum;
    }
    public void setBrowseNum(Integer browseNum) 
    {
        this.browseNum = browseNum;
    }

    public Integer getBrowseNum() 
    {
        return browseNum;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }
    public void setTopicType(String topicType) 
    {
        this.topicType = topicType;
    }

    public String getTopicType() 
    {
        return topicType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("topicId", getTopicId())
            .append("topicName", getTopicName())
            .append("articleNum", getArticleNum())
            .append("browseNum", getBrowseNum())
            .append("picUrl", getPicUrl())
            .append("topicType", getTopicType())
            .toString();
    }
}
