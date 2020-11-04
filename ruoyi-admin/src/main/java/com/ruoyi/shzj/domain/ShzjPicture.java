package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图片信息对象 shzj_picture
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
public class ShzjPicture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片编号 */
    private Integer picId;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String picUrl;

    public void setPicId(Integer picId) 
    {
        this.picId = picId;
    }

    public Integer getPicId() 
    {
        return picId;
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
            .append("picId", getPicId())
            .append("picUrl", getPicUrl())
            .toString();
    }
}
