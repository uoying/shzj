package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地图信息对象 shzj_map
 * 
 * @author ruoyi
 * @date 2020-09-13
 */
public class ShzjMap 
{
    private static final long serialVersionUID = 1L;

    /** 地图编号 */
    private Integer mapId;

    /** 地图城市 */
    @Excel(name = "地图城市")
    private String mapCity;

    /** 内容类型 */
    @Excel(name = "内容类型")
    private String mapType;

    /** 图片 */
    @Excel(name = "图片")
    private String picUrl;

    /** 内容编号 */
    @Excel(name = "内容编号")
    private Long contentId;

    /** 标题 */
    @Excel(name = "标题")
    private String mapTitle;

    public void setMapId(Integer mapId) 
    {
        this.mapId = mapId;
    }

    public Integer getMapId() 
    {
        return mapId;
    }
    public void setMapCity(String mapCity) 
    {
        this.mapCity = mapCity;
    }

    public String getMapCity() 
    {
        return mapCity;
    }
    public void setMapType(String mapType) 
    {
        this.mapType = mapType;
    }

    public String getMapType() 
    {
        return mapType;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }
    public void setContentId(Long contentId) 
    {
        this.contentId = contentId;
    }

    public Long getContentId() 
    {
        return contentId;
    }
    public void setMapTitle(String mapTitle) 
    {
        this.mapTitle = mapTitle;
    }

    public String getMapTitle() 
    {
        return mapTitle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mapId", getMapId())
            .append("mapCity", getMapCity())
            .append("mapType", getMapType())
            .append("picUrl", getPicUrl())
            .append("contentId", getContentId())
            .append("mapTitle", getMapTitle())
            .toString();
    }
}
