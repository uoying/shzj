package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 城市信息对象 shzj_city
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public class ShzjCity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 城市编号 */
    private Integer cityId;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String cityName;

    /** 城市诗词 */
    @Excel(name = "城市诗词")
    private String cityPoem;

    /** 喜欢数 */
    @Excel(name = "喜欢数")
    private String cityLike;

    /** 收藏数 */
    @Excel(name = "收藏数")
    private String cityCollect;

    /** 图片url */
    @Excel(name = "图片url")
    private String picUrl;

    public void setCityId(Integer cityId) 
    {
        this.cityId = cityId;
    }

    public Integer getCityId() 
    {
        return cityId;
    }
    public void setCityName(String cityName) 
    {
        this.cityName = cityName;
    }

    public String getCityName() 
    {
        return cityName;
    }
    public void setCityPoem(String cityPoem) 
    {
        this.cityPoem = cityPoem;
    }

    public String getCityPoem() 
    {
        return cityPoem;
    }
    public void setCityLike(String cityLike) 
    {
        this.cityLike = cityLike;
    }

    public String getCityLike() 
    {
        return cityLike;
    }
    public void setCityCollect(String cityCollect) 
    {
        this.cityCollect = cityCollect;
    }

    public String getCityCollect() 
    {
        return cityCollect;
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
            .append("cityId", getCityId())
            .append("cityName", getCityName())
            .append("cityPoem", getCityPoem())
            .append("cityLike", getCityLike())
            .append("cityCollect", getCityCollect())
            .append("picUrl", getPicUrl())
            .toString();
    }
}
