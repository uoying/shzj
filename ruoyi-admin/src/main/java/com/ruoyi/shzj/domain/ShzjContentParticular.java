package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 内容详情信息对象 shzj_content_particular
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
public class ShzjContentParticular extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 详情编号 */
    private Integer particularId;

    /** 内容编号 */
    @Excel(name = "内容编号")
    private Integer conId;

    /** 是否为720全景图 */
    @Excel(name = "是否为720全景图")
    private Integer is720;

    /** 喜欢数 */
    @Excel(name = "喜欢数")
    private Integer likeNum;

    /** 内容 */
    @Excel(name = "内容")
    private String particularH5;

    /** 主图列表 */
    @Excel(name = "主图列表")
    private String mianPicurl;

    /** 次要图表 */
    @Excel(name = "次要图表")
    private String minorPicurl;

    /** 攻略集合 */
    @Excel(name = "攻略集合")
    private String arrays;

    public String getArrays() {
        return arrays;
    }

    public void setArrays(String arrays) {
        this.arrays = arrays;
    }

    public void setParticularId(Integer particularId)
    {
        this.particularId = particularId;
    }

    public Integer getParticularId() 
    {
        return particularId;
    }
    public void setConId(Integer conId) 
    {
        this.conId = conId;
    }

    public Integer getConId() 
    {
        return conId;
    }
    public void setIs720(Integer is720) 
    {
        this.is720 = is720;
    }

    public Integer getIs720() 
    {
        return is720;
    }
    public void setLikeNum(Integer likeNum) 
    {
        this.likeNum = likeNum;
    }

    public Integer getLikeNum() 
    {
        return likeNum;
    }
    public void setParticularH5(String particularH5) 
    {
        this.particularH5 = particularH5;
    }

    public String getParticularH5() 
    {
        return particularH5;
    }
    public void setMianPicurl(String mianPicurl) 
    {
        this.mianPicurl = mianPicurl;
    }

    public String getMianPicurl() 
    {
        return mianPicurl;
    }
    public void setMinorPicurl(String minorPicurl) 
    {
        this.minorPicurl = minorPicurl;
    }

    public String getMinorPicurl() 
    {
        return minorPicurl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("particularId", getParticularId())
            .append("conId", getConId())
            .append("is720", getIs720())
            .append("likeNum", getLikeNum())
            .append("particularH5", getParticularH5())
            .append("mianPicurl", getMianPicurl())
            .append("minorPicurl", getMinorPicurl())
            .toString();
    }
}
