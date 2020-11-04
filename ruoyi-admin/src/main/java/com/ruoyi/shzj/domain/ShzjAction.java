package com.ruoyi.shzj.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 关注功能对象 shzj_action
 * 
 * @author ruoyi
 * @date 2020-09-17
 */
public class ShzjAction
{
    private static final long serialVersionUID = 1L;

    /** 关注编号 */
    private Integer actionId;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

    /** 关注类型 */
    @Excel(name = "关注类型")
    private String content;

    /** 类型编号 */
    @Excel(name = "类型编号")
    private Integer contentid;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    public void setActionId(Integer actionId) 
    {
        this.actionId = actionId;
    }

    public Integer getActionId() 
    {
        return actionId;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setContentid(Integer contentid) 
    {
        this.contentid = contentid;
    }

    public Integer getContentid() 
    {
        return contentid;
    }
    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("actionId", getActionId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("contentid", getContentid())
            .append("creatTime", getCreatTime())
            .toString();
    }
}
