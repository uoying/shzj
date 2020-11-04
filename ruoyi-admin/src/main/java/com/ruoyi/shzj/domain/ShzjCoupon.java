package com.ruoyi.shzj.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 兑换卷对象 shzj_coupon
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public class ShzjCoupon
{
    private static final long serialVersionUID = 1L;

    /** 兑换卷Id */
    private Integer couponId;

    /** ￥金额 */
    @Excel(name = "￥金额")
    private String qian;

    /** 无金额门槛 */
    @Excel(name = "无金额门槛")
    private String information1;

    /** 信息卷 */
    @Excel(name = "信息卷")
    private String information2;

    /** 任意景点门票 */
    @Excel(name = "任意景点门票")
    private String information3;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 兑换积分 */
    @Excel(name = "兑换积分")
    private Integer exchange;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCouponId(Integer couponId)
    {
        this.couponId = couponId;
    }

    public Integer getCouponId() 
    {
        return couponId;
    }
    public void setQian(String qian) 
    {
        this.qian = qian;
    }

    public String getQian() 
    {
        return qian;
    }
    public void setInformation1(String information1) 
    {
        this.information1 = information1;
    }

    public String getInformation1() 
    {
        return information1;
    }
    public void setInformation2(String information2) 
    {
        this.information2 = information2;
    }

    public String getInformation2() 
    {
        return information2;
    }
    public void setInformation3(String information3) 
    {
        this.information3 = information3;
    }

    public String getInformation3() 
    {
        return information3;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setExchange(Integer exchange) 
    {
        this.exchange = exchange;
    }

    public Integer getExchange() 
    {
        return exchange;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("couponId", getCouponId())
            .append("qian", getQian())
            .append("information1", getInformation1())
            .append("information2", getInformation2())
            .append("information3", getInformation3())
            .append("createTime", getCreateTime())
            .append("endTime", getEndTime())
            .append("exchange", getExchange())
            .toString();
    }
}
