package com.ruoyi.shzj.service.impl;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.CouponDTO;
import com.ruoyi.shzj.domain.DTO.CouponGiftDTO;
import com.ruoyi.shzj.domain.DTO.MyCouponDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjCouponGift1Mapper;
import com.ruoyi.shzj.domain.ShzjCouponGift1;
import com.ruoyi.shzj.service.IShzjCouponGift1Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 兑换卷信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
@Service
public class ShzjCouponGift1ServiceImpl implements IShzjCouponGift1Service
{
    @Autowired
    private ShzjCouponGift1Mapper shzjCouponGift1Mapper;

    /**
     * 查询兑换卷信息
     * 
     * @param coupongiftId 兑换卷信息ID
     * @return 兑换卷信息
     */
    @Override
    public ShzjCouponGift1 selectShzjCouponGift1ById(Integer coupongiftId)
    {
        return shzjCouponGift1Mapper.selectShzjCouponGift1ById(coupongiftId);
    }

    /**
     * 查询兑换卷信息列表
     * 
     * @param shzjCouponGift1 兑换卷信息
     * @return 兑换卷信息
     */
    @Override
    public List<ShzjCouponGift1> selectShzjCouponGift1List(ShzjCouponGift1 shzjCouponGift1)
    {
        return shzjCouponGift1Mapper.selectShzjCouponGift1List(shzjCouponGift1);
    }

    /**
     * 新增兑换卷信息
     * 
     * @param shzjCouponGift1 兑换卷信息
     * @return 结果
     */
    @Override
    public int insertShzjCouponGift1(ShzjCouponGift1 shzjCouponGift1)
    {
        return shzjCouponGift1Mapper.insertShzjCouponGift1(shzjCouponGift1);
    }

    /**
     * 修改兑换卷信息
     * 
     * @param shzjCouponGift1 兑换卷信息
     * @return 结果
     */
    @Override
    public int updateShzjCouponGift1(ShzjCouponGift1 shzjCouponGift1)
    {
        return shzjCouponGift1Mapper.updateShzjCouponGift1(shzjCouponGift1);
    }

    /**
     * 删除兑换卷信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjCouponGift1ByIds(String ids)
    {
        return shzjCouponGift1Mapper.deleteShzjCouponGift1ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除兑换卷信息信息
     * 
     * @param coupongiftId 兑换卷信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjCouponGift1ById(Integer coupongiftId)
    {
        return shzjCouponGift1Mapper.deleteShzjCouponGift1ById(coupongiftId);
    }

    @Override
    public int insertShzjMyCouponGift(CouponDTO couponDTO) {
        return shzjCouponGift1Mapper.insertShzjMyCouponGift(couponDTO);
    }

    @Override
    public List<MyCouponDTO> selectShzjMyCouponGift1(int userId) {
        return shzjCouponGift1Mapper.selectShzjMyCouponGift1(userId);
    }

    @Override
    public List<CouponGiftDTO> selectShzjCouponGift1() {
        return shzjCouponGift1Mapper.selectShzjCouponGift1();
    }
}
