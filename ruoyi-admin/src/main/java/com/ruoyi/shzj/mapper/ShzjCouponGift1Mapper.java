package com.ruoyi.shzj.mapper;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.CouponDTO;
import com.ruoyi.shzj.domain.DTO.CouponGiftDTO;
import com.ruoyi.shzj.domain.DTO.MyCouponDTO;
import com.ruoyi.shzj.domain.ShzjCouponGift1;

/**
 * 兑换卷信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
public interface ShzjCouponGift1Mapper 
{
    /**
     * 查询兑换卷信息
     * 
     * @param coupongiftId 兑换卷信息ID
     * @return 兑换卷信息
     */
    public ShzjCouponGift1 selectShzjCouponGift1ById(Integer coupongiftId);

    /**
     * 查询兑换卷信息列表
     * 
     * @param shzjCouponGift1 兑换卷信息
     * @return 兑换卷信息集合
     */
    public List<ShzjCouponGift1> selectShzjCouponGift1List(ShzjCouponGift1 shzjCouponGift1);

    /**
     * 新增兑换卷信息
     * 
     * @param shzjCouponGift1 兑换卷信息
     * @return 结果
     */
    public int insertShzjCouponGift1(ShzjCouponGift1 shzjCouponGift1);

    /**
     * 修改兑换卷信息
     * 
     * @param shzjCouponGift1 兑换卷信息
     * @return 结果
     */
    public int updateShzjCouponGift1(ShzjCouponGift1 shzjCouponGift1);

    /**
     * 删除兑换卷信息
     * 
     * @param coupongiftId 兑换卷信息ID
     * @return 结果
     */
    public int deleteShzjCouponGift1ById(Integer coupongiftId);

    /**
     * 批量删除兑换卷信息
     * 
     * @param coupongiftIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjCouponGift1ByIds(String[] coupongiftIds);
    int insertShzjMyCouponGift(CouponDTO couponDTO);
    List<MyCouponDTO> selectShzjMyCouponGift1(int userId);
    List<CouponGiftDTO> selectShzjCouponGift1();
}
