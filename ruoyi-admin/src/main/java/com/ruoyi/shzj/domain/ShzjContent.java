package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 内容信息对象 shzj_content
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
public class ShzjContent
{
    private static final long serialVersionUID = 1L;

    /** 内容编号 */
    private Integer conId;

    /** 标题 */
    @Excel(name = "标题")
    private String conTitile;

    /** 地址 */
    @Excel(name = "地址")
    private String conAddress;

    /** 城市编号 */
    @Excel(name = "城市编号")
    private Integer conCity;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private Integer isRecommend;

    /** 文章 */
    @Excel(name = "文章")
    private String conArticle;

    /** 评分 */
    @Excel(name = "评分")
    private Integer conScore;

    /** 类型编号 */
    @Excel(name = "类型编号")
    private Integer conType;
    private String cityName;
    private String typeName;
    /** 图片 */
    @Excel(name = "图片")
    private String conPicture;

    /** 音频编号 */
    @Excel(name = "音频编号")
    private String conAudio;
    private List<String> pictures;
    public String getCityName() {
        return cityName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<String> getPictures() {
        return pictures;
    }
    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public void setConId(Integer conId)
    {
        this.conId = conId;
    }

    public Integer getConId() 
    {
        return conId;
    }
    public void setConTitile(String conTitile) 
    {
        this.conTitile = conTitile;
    }

    public String getConTitile() 
    {
        return conTitile;
    }
    public void setConAddress(String conAddress) 
    {
        this.conAddress = conAddress;
    }

    public String getConAddress() 
    {
        return conAddress;
    }
    public void setConCity(Integer conCity) 
    {
        this.conCity = conCity;
    }

    public Integer getConCity() 
    {
        return conCity;
    }
    public void setIsRecommend(Integer isRecommend) 
    {
        this.isRecommend = isRecommend;
    }

    public Integer getIsRecommend() 
    {
        return isRecommend;
    }
    public void setConArticle(String conArticle) 
    {
        this.conArticle = conArticle;
    }

    public String getConArticle() 
    {
        return conArticle;
    }
    public void setConScore(Integer conScore) 
    {
        this.conScore = conScore;
    }

    public Integer getConScore() 
    {
        return conScore;
    }
    public void setConType(Integer conType) 
    {
        this.conType = conType;
    }

    public Integer getConType() 
    {
        return conType;
    }
    public void setConPicture(String conPicture) 
    {
        this.conPicture = conPicture;
    }

    public String getConPicture() 
    {
        return conPicture;
    }

    public String getConAudio() {
        return conAudio;
    }

    public void setConAudio(String conAudio) {
        this.conAudio = conAudio;
    }

    @Override
    public String toString() {
        return "ShzjContent{" +
                "conId=" + conId +
                ", conTitile='" + conTitile + '\'' +
                ", conAddress='" + conAddress + '\'' +
                ", conCity=" + conCity +
                ", isRecommend=" + isRecommend +
                ", conArticle='" + conArticle + '\'' +
                ", conScore=" + conScore +
                ", conType=" + conType +
                ", cityName='" + cityName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", conPicture='" + conPicture + '\'' +
                ", conAudio='" + conAudio + '\'' +
                ", pictures=" + pictures +
                '}';
    }
}
