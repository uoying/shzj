package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 礼包信息对象 shzj_gift
 * 
 * @author ruoyi
 * @date 2020-07-29
 */
public class ShzjGift extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 礼品编号 */
    private Integer giftId;

    /** 礼品标题 */
    @Excel(name = "礼品标题")
    private String giftTitle;

    /** 礼品详情 */
    @Excel(name = "礼品详情")
    private String giftInfo;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

    public void setGiftId(Integer giftId) 
    {
        this.giftId = giftId;
    }

    public Integer getGiftId() 
    {
        return giftId;
    }
    public void setGiftTitle(String giftTitle) 
    {
        this.giftTitle = giftTitle;
    }

    public String getGiftTitle() 
    {
        return giftTitle;
    }
    public void setGiftInfo(String giftInfo) 
    {
        this.giftInfo = giftInfo;
    }

    public String getGiftInfo() 
    {
        return giftInfo;
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
            .append("giftId", getGiftId())
            .append("giftTitle", getGiftTitle())
            .append("giftInfo", getGiftInfo())
            .append("userId", getUserId())
            .toString();
    }
}
