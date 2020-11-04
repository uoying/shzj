package com.ruoyi.shzj.domain.DTO;

public class MyCouponDTO {
    private String whetherToRedeem, coupongiftId, qian, information1, information2, information3, createTime, endTime;

    @Override
    public String toString() {
        return "MyCouponDTO{" +
                "whetherToRedeem='" + whetherToRedeem + '\'' +
                ", couponId='" + coupongiftId + '\'' +
                ", qian='" + qian + '\'' +
                ", information1='" + information1 + '\'' +
                ", information2='" + information2 + '\'' +
                ", information3='" + information3 + '\'' +
                ", createTime='" + createTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    public String getWhetherToRedeem() {
        return whetherToRedeem;
    }

    public void setWhetherToRedeem(String whetherToRedeem) {
        this.whetherToRedeem = whetherToRedeem;
    }

    public String getCoupongiftId() {
        return coupongiftId;
    }

    public void setCoupongiftId(String coupongiftId) {
        this.coupongiftId = coupongiftId;
    }

    public String getQian() {
        return qian;
    }

    public void setQian(String qian) {
        this.qian = qian;
    }

    public String getInformation1() {
        return information1;
    }

    public void setInformation1(String information1) {
        this.information1 = information1;
    }

    public String getInformation2() {
        return information2;
    }

    public void setInformation2(String information2) {
        this.information2 = information2;
    }

    public String getInformation3() {
        return information3;
    }

    public void setInformation3(String information3) {
        this.information3 = information3;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
