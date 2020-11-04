package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 兑换卷信息对象 shzj_coupon_gift1
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
public class ShzjCouponGift1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 我的兑换卷Id */
    private Integer coupongiftId;

    /** 用户Id */
    @Excel(name = "用户Id")
    private Integer userId;

    /** 0为未使用 1为已兑换 */
    @Excel(name = "0为未使用 1为已兑换")
    private Integer whethertoredeem;

    /** 兑换卷ID */
    @Excel(name = "兑换卷ID")
    private Integer couponId;

    public void setCoupongiftId(Integer coupongiftId) 
    {
        this.coupongiftId = coupongiftId;
    }

    public Integer getCoupongiftId() 
    {
        return coupongiftId;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setWhethertoredeem(Integer whethertoredeem) 
    {
        this.whethertoredeem = whethertoredeem;
    }

    public Integer getWhethertoredeem() 
    {
        return whethertoredeem;
    }
    public void setCouponId(Integer couponId) 
    {
        this.couponId = couponId;
    }

    public Integer getCouponId() 
    {
        return couponId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("coupongiftId", getCoupongiftId())
            .append("userId", getUserId())
            .append("whethertoredeem", getWhethertoredeem())
            .append("couponId", getCouponId())
            .toString();
    }
}
