package com.ruoyi.shzj.domain.DTO;

public class IntegralDTO {
    private Integer integral;

    @Override
    public String toString() {
        return "integralDTO{" +
                "integral=" + integral +
                '}';
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
