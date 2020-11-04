package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 按钮内容对象 shzj_button_content
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
public class ShzjButtonContent
{
    private static final long serialVersionUID = 1L;

    /** 按钮内容编号 */
    private Integer buttonConId;

    /** 图片url */
    @Excel(name = "图片url")
    private String conPic;

    /** 内容文本 */
    @Excel(name = "内容文本")
    private String btnCon;

    public void setButtonConId(Integer buttonConId) 
    {
        this.buttonConId = buttonConId;
    }

    public Integer getButtonConId() 
    {
        return buttonConId;
    }
    public void setConPic(String conPic) 
    {
        this.conPic = conPic;
    }

    public String getConPic() 
    {
        return conPic;
    }
    public void setBtnCon(String btnCon) 
    {
        this.btnCon = btnCon;
    }

    public String getBtnCon() 
    {
        return btnCon;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("buttonConId", getButtonConId())
            .append("conPic", getConPic())
            .append("btnCon", getBtnCon())
            .toString();
    }
}
