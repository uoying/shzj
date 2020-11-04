package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjCoupon;

/**
 * 兑换卷Service接口
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public interface IShzjCouponService 
{
    /**
     * 查询兑换卷
     * 
     * @param couponId 兑换卷ID
     * @return 兑换卷
     */
    public ShzjCoupon selectShzjCouponById(Integer couponId);

    /**
     * 查询兑换卷列表
     * 
     * @param shzjCoupon 兑换卷
     * @return 兑换卷集合
     */
    public List<ShzjCoupon> selectShzjCouponList(ShzjCoupon shzjCoupon);

    /**
     * 新增兑换卷
     * 
     * @param shzjCoupon 兑换卷
     * @return 结果
     */
    public int insertShzjCoupon(ShzjCoupon shzjCoupon);

    /**
     * 修改兑换卷
     * 
     * @param shzjCoupon 兑换卷
     * @return 结果
     */
    public int updateShzjCoupon(ShzjCoupon shzjCoupon);

    /**
     * 批量删除兑换卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjCouponByIds(String ids);

    /**
     * 删除兑换卷信息
     * 
     * @param couponId 兑换卷ID
     * @return 结果
     */
    public int deleteShzjCouponById(Integer couponId);
}
