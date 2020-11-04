package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 定制信息对象 shzj_customization
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
public class ShzjCustomization
{
    private static final long serialVersionUID = 1L;

    /** 定制编号 */
    private Integer customId;

    /** 背景图片 */
    @Excel(name = "背景图片")
    private String customPic;

    /** 定制标题 */
    @Excel(name = "定制标题")
    private String customTitle;

    /** 地址 */
    @Excel(name = "地址")
    private String customAddress;

    /** 内容 */
    @Excel(name = "内容")
    private String customContent;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 类型 */
    @Excel(name = "类型")
    private String customType;

    /** 有无按钮 */
    @Excel(name = "有无按钮")
    private Integer isbutton;

    /** 按钮标题 */
    @Excel(name = "按钮标题")
    private String buttonName;

    /** 按钮内容组 */
    @Excel(name = "按钮内容组")
    private String buttonContents;

    private List<ShzjButtonContent>contents;

    public List<ShzjButtonContent> getContents() {
        return contents;
    }

    public void setContents(List<ShzjButtonContent> contents) {
        this.contents = contents;
    }

    public void setCustomId(Integer customId)
    {
        this.customId = customId;
    }

    public Integer getCustomId() 
    {
        return customId;
    }
    public void setCustomPic(String customPic) 
    {
        this.customPic = customPic;
    }

    public String getCustomPic() 
    {
        return customPic;
    }
    public void setCustomTitle(String customTitle) 
    {
        this.customTitle = customTitle;
    }

    public String getCustomTitle() 
    {
        return customTitle;
    }
    public void setCustomAddress(String customAddress) 
    {
        this.customAddress = customAddress;
    }

    public String getCustomAddress() 
    {
        return customAddress;
    }
    public void setCustomContent(String customContent) 
    {
        this.customContent = customContent;
    }

    public String getCustomContent() 
    {
        return customContent;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCustomType(String customType) 
    {
        this.customType = customType;
    }

    public String getCustomType() 
    {
        return customType;
    }
    public void setIsbutton(Integer isbutton) 
    {
        this.isbutton = isbutton;
    }

    public Integer getIsbutton() 
    {
        return isbutton;
    }
    public void setButtonName(String buttonName) 
    {
        this.buttonName = buttonName;
    }

    public String getButtonName() 
    {
        return buttonName;
    }
    public void setButtonContents(String buttonContents) 
    {
        this.buttonContents = buttonContents;
    }

    public String getButtonContents() 
    {
        return buttonContents;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customId", getCustomId())
            .append("customPic", getCustomPic())
            .append("customTitle", getCustomTitle())
            .append("customAddress", getCustomAddress())
            .append("customContent", getCustomContent())
            .append("city", getCity())
            .append("customType", getCustomType())
            .append("isbutton", getIsbutton())
            .append("buttonName", getButtonName())
            .append("buttonContents", getButtonContents())
            .toString();
    }
}
