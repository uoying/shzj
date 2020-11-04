package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图像识别:图片对象 shzj_image
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
public class ShzjImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图像编号 */
    private Integer imageId;

    /** 识别内容编号 */
    @Excel(name = "识别内容编号")
    private Integer imageContentId;

    /** 图片url */
    @Excel(name = "图片url")
    private String imageUrl;

    public void setImageId(Integer imageId) 
    {
        this.imageId = imageId;
    }

    public Integer getImageId() 
    {
        return imageId;
    }
    public void setImageContentId(Integer imageContentId) 
    {
        this.imageContentId = imageContentId;
    }

    public Integer getImageContentId() 
    {
        return imageContentId;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("imageId", getImageId())
            .append("imageContentId", getImageContentId())
            .append("imageUrl", getImageUrl())
            .toString();
    }
}
