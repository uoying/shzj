package com.ruoyi.shzj.domain.DTO;

import com.ruoyi.shzj.domain.ShzjCoupon;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;

public class Coupon1DTO{
  private List<ShzjCoupon>  shzjCoupon;
 private int myjifen;

    @Override
    public String toString() {
        return "Coupon1DTO{" +
                "shzjCoupon=" + shzjCoupon +
                ", myjifen=" + myjifen +
                '}';
    }

    public List<ShzjCoupon> getShzjCoupon() {
        return shzjCoupon;
    }

    public void setShzjCoupon(List<ShzjCoupon> shzjCoupon) {
        this.shzjCoupon = shzjCoupon;
    }

    public int getMyjifen() {
        return myjifen;
    }

    public void setMyjifen(int myjifen) {
        this.myjifen = myjifen;
    }
}
