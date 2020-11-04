package com.ruoyi.shzj.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 照片信息对象 shzj_photo
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
public class ShzjPhoto extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 照片编号 */
    private Integer photoId;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

    /** 照片路径 */
    @Excel(name = "照片路径")
    private String photoUrl;

    public void setPhotoId(Integer photoId) 
    {
        this.photoId = photoId;
    }

    public Integer getPhotoId() 
    {
        return photoId;
    }
    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setPhotoUrl(String photoUrl) 
    {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() 
    {
        return photoUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("photoId", getPhotoId())
            .append("creatTime", getCreatTime())
            .append("userId", getUserId())
            .append("photoUrl", getPhotoUrl())
            .toString();
    }
}
