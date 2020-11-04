package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 锦囊信息对象 shzj_silk
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public class ShzjSilk extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 锦囊编号 */
    private Integer silkId;

    /** 锦囊标题 */
    @Excel(name = "锦囊标题")
    private String silkTitle;

    /** 锦囊线路 */
    @Excel(name = "锦囊线路")
    private String silkLine;

    /** 内容链接 */
    @Excel(name = "内容链接")
    private String silkUrl;

    /** 锦囊图片 */
    @Excel(name = "锦囊图片")
    private String silkPic;

    /** 感兴趣数 */
    @Excel(name = "感兴趣数")
    private String enjoyNum;

    /** 城市编号 */
    @Excel(name = "城市编号")
    private Integer cityId;

    public void setSilkId(Integer silkId) 
    {
        this.silkId = silkId;
    }

    public Integer getSilkId() 
    {
        return silkId;
    }
    public void setSilkTitle(String silkTitle) 
    {
        this.silkTitle = silkTitle;
    }

    public String getSilkTitle() 
    {
        return silkTitle;
    }
    public void setSilkLine(String silkLine) 
    {
        this.silkLine = silkLine;
    }

    public String getSilkLine() 
    {
        return silkLine;
    }
    public void setSilkUrl(String silkUrl) 
    {
        this.silkUrl = silkUrl;
    }

    public String getSilkUrl() 
    {
        return silkUrl;
    }
    public void setSilkPic(String silkPic) 
    {
        this.silkPic = silkPic;
    }

    public String getSilkPic() 
    {
        return silkPic;
    }
    public void setEnjoyNum(String enjoyNum) 
    {
        this.enjoyNum = enjoyNum;
    }

    public String getEnjoyNum() 
    {
        return enjoyNum;
    }
    public void setCityId(Integer cityId) 
    {
        this.cityId = cityId;
    }

    public Integer getCityId() 
    {
        return cityId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("silkId", getSilkId())
            .append("silkTitle", getSilkTitle())
            .append("silkLine", getSilkLine())
            .append("silkUrl", getSilkUrl())
            .append("silkPic", getSilkPic())
            .append("enjoyNum", getEnjoyNum())
            .append("cityId", getCityId())
            .toString();
    }
}
