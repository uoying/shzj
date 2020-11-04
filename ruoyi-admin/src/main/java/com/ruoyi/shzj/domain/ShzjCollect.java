package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收藏列表对象 shzj_collect
 * 
 * @author ruoyi
 * @date 2020-08-24
 */
public class ShzjCollect
{
    private static final long serialVersionUID = 1L;

    /** 收藏列表编号 */
    private Integer id;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

    /** 收藏类型 */
    @Excel(name = "收藏类型")
    private String collectType;

    /** 收藏对象id */
    @Excel(name = "收藏对象id")
    private Integer collectId;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setCollectType(String collectType) 
    {
        this.collectType = collectType;
    }

    public String getCollectType() 
    {
        return collectType;
    }
    public void setCollectId(Integer collectId) 
    {
        this.collectId = collectId;
    }

    public Integer getCollectId() 
    {
        return collectId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("collectType", getCollectType())
            .append("collectId", getCollectId())
            .toString();
    }
}
