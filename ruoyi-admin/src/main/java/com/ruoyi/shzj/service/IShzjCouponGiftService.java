package com.ruoyi.shzj.service;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.CouponDTO;
import com.ruoyi.shzj.domain.ShzjCouponGift;

/**
 * 兑换卷(已兑换)Service接口
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
public interface IShzjCouponGiftService 
{
    /**
     * 查询兑换卷(已兑换)
     * 
     * @param couponId 兑换卷(已兑换)ID
     * @return 兑换卷(已兑换)
     */
    public ShzjCouponGift selectShzjCouponGiftById(Integer couponId);

    /**
     * 查询兑换卷(已兑换)列表
     * 
     * @param shzjCouponGift 兑换卷(已兑换)
     * @return 兑换卷(已兑换)集合
     */
    public List<ShzjCouponGift> selectShzjCouponGiftList(ShzjCouponGift shzjCouponGift);

    /**
     * 新增兑换卷(已兑换)
     * 
     * @param shzjCouponGift 兑换卷(已兑换)
     * @return 结果
     */
    public int insertShzjCouponGift(ShzjCouponGift shzjCouponGift);

    /**
     * 修改兑换卷(已兑换)
     * 
     * @param shzjCouponGift 兑换卷(已兑换)
     * @return 结果
     */
    public int updateShzjCouponGift(ShzjCouponGift shzjCouponGift);

    /**
     * 批量删除兑换卷(已兑换)
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjCouponGiftByIds(String ids);

    /**
     * 删除兑换卷(已兑换)信息
     * 
     * @param couponId 兑换卷(已兑换)ID
     * @return 结果
     */
    public int deleteShzjCouponGiftById(Integer couponId);

    int insertShzjMyCouponGift(CouponDTO couponDTO);
}
