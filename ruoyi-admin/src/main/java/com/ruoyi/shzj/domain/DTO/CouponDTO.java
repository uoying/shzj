package com.ruoyi.shzj.domain.DTO;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiParam;

import java.util.Date;

public class CouponDTO {
    private int couponId;
    private int exchange;
    private int userId;

    @Override
    public String toString() {
        return "CouponDTO{" +
                "couponId=" + couponId +
                ", exchange=" + exchange +
                ", userId=" + userId +
                '}';
    }

    public int getExchange() {
        return exchange;
    }

    public void setExchange(int exchange) {
        this.exchange = exchange;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
