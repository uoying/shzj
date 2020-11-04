package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 足迹信息对象 shzj_footprint
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
public class ShzjFootprint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 足迹编号 */
    private Integer footId;

    /** 城市编号 */
    @Excel(name = "城市编号")
    private Integer cityId;

    /** 足迹标题 */
    @Excel(name = "足迹标题")
    private String footTitle;

    /** 足迹内容 */
    @Excel(name = "足迹内容")
    private String footContent;

    /** 照片编号 */
    @Excel(name = "照片编号")
    private String footPicture;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

    private List<String> picURL;

    public void setFootId(Integer footId) 
    {
        this.footId = footId;
    }

    public List<String> getPicURL() {
        return picURL;
    }

    public void setPicURL(List<String> picURL) {
        this.picURL = picURL;
    }

    public Integer getFootId()
    {
        return footId;
    }
    public void setCityId(Integer cityId) 
    {
        this.cityId = cityId;
    }

    public Integer getCityId() 
    {
        return cityId;
    }
    public void setFootTitle(String footTitle) 
    {
        this.footTitle = footTitle;
    }

    public String getFootTitle() 
    {
        return footTitle;
    }
    public void setFootContent(String footContent) 
    {
        this.footContent = footContent;
    }

    public String getFootContent() 
    {
        return footContent;
    }
    public void setFootPicture(String footPicture) 
    {
        this.footPicture = footPicture;
    }

    public String getFootPicture() 
    {
        return footPicture;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("footId", getFootId())
            .append("cityId", getCityId())
            .append("footTitle", getFootTitle())
            .append("footContent", getFootContent())
            .append("footPicture", getFootPicture())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
