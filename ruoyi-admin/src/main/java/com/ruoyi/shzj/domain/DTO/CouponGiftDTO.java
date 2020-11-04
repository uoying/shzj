package com.ruoyi.shzj.domain.DTO;

import com.ruoyi.common.annotation.Excel;

public class CouponGiftDTO {
    private Integer coupongiftId;
    /** 用户Id */
    @Excel(name = "用户Id")
    private Integer userId;

    private String information3;

    private String userName;
    /** 0为未使用 1为已兑换 */
    @Excel(name = "0为未使用 1为已兑换")
    private Integer whethertoredeem;

    /** 兑换卷ID */
    @Excel(name = "兑换卷ID")
    private Integer couponId;

    public Integer getCoupongiftId() {
        return coupongiftId;
    }

    public void setCoupongiftId(Integer coupongiftId) {
        this.coupongiftId = coupongiftId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInformation3() {
        return information3;
    }

    public void setInformation3(String information3) {
        this.information3 = information3;
    }

    public Integer getWhethertoredeem() {
        return whethertoredeem;
    }

    public void setWhethertoredeem(Integer whethertoredeem) {
        this.whethertoredeem = whethertoredeem;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "CouponGiftDTO{" +
                "coupongiftId=" + coupongiftId +
                ", userId=" + userId +
                ", information3='" + information3 + '\'' +
                ", userName='" + userName + '\'' +
                ", whethertoredeem=" + whethertoredeem +
                ", couponId=" + couponId +
                '}';
    }
}
