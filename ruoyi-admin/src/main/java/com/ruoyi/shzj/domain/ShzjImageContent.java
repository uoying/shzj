package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图像识别:图片信息对象 shzj_image_content
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
public class ShzjImageContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图像内容编号 */
    private Integer imageContentId;

    /** 识别内容名称 */
    @Excel(name = "识别内容名称")
    private String imageContentName;

    /** 图像内容H5 */
    @Excel(name = "图像内容H5")
    private String imageContentH5;

    /** 音频 */
    @Excel(name = "音频")
    private String imageContentAudio;

    /** 背景图 */
    @Excel(name = "背景图")
    private String imageContentBackgroundimg;

    public void setImageContentId(Integer imageContentId) 
    {
        this.imageContentId = imageContentId;
    }

    public Integer getImageContentId() 
    {
        return imageContentId;
    }
    public void setImageContentName(String imageContentName) 
    {
        this.imageContentName = imageContentName;
    }

    public String getImageContentName() 
    {
        return imageContentName;
    }
    public void setImageContentH5(String imageContentH5) 
    {
        this.imageContentH5 = imageContentH5;
    }

    public String getImageContentH5() 
    {
        return imageContentH5;
    }
    public void setImageContentAudio(String imageContentAudio) 
    {
        this.imageContentAudio = imageContentAudio;
    }

    public String getImageContentAudio() 
    {
        return imageContentAudio;
    }
    public void setImageContentBackgroundimg(String imageContentBackgroundimg) 
    {
        this.imageContentBackgroundimg = imageContentBackgroundimg;
    }

    public String getImageContentBackgroundimg() 
    {
        return imageContentBackgroundimg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("imageContentId", getImageContentId())
            .append("imageContentName", getImageContentName())
            .append("imageContentH5", getImageContentH5())
            .append("imageContentAudio", getImageContentAudio())
            .append("imageContentBackgroundimg", getImageContentBackgroundimg())
            .toString();
    }
}
