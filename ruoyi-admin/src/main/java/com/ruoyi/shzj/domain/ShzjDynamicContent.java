package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态详情信息对象 shzj_dynamic_content
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
public class ShzjDynamicContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 动态详情编号 */
    private Integer dynamicContentId;

    /** 动态编号 */
    @Excel(name = "动态编号")
    private Integer dynamicId;

    /** 动态内容 */
    @Excel(name = "动态内容")
    private String dynamicContent;

    public void setDynamicContentId(Integer dynamicContentId) 
    {
        this.dynamicContentId = dynamicContentId;
    }

    public Integer getDynamicContentId() 
    {
        return dynamicContentId;
    }

    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public void setDynamicContent(String dynamicContent)
    {
        this.dynamicContent = dynamicContent;
    }

    public String getDynamicContent() 
    {
        return dynamicContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dynamicContentId", getDynamicContentId())
            .append("dynamicId", getDynamicId())
            .append("dynamicContent", getDynamicContent())
            .toString();
    }
}
