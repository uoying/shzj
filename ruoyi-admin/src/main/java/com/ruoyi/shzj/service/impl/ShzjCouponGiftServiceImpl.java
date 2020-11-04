package com.ruoyi.shzj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.shzj.domain.DTO.CouponDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjCouponGiftMapper;
import com.ruoyi.shzj.domain.ShzjCouponGift;
import com.ruoyi.shzj.service.IShzjCouponGiftService;
import com.ruoyi.common.core.text.Convert;

/**
 * 兑换卷(已兑换)Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class ShzjCouponGiftServiceImpl implements IShzjCouponGiftService 
{
    @Autowired
    private ShzjCouponGiftMapper shzjCouponGiftMapper;

    /**
     * 查询兑换卷(已兑换)
     * 
     * @param couponId 兑换卷(已兑换)ID
     * @return 兑换卷(已兑换)
     */
    @Override
    public ShzjCouponGift selectShzjCouponGiftById(Integer couponId)
    {
        return shzjCouponGiftMapper.selectShzjCouponGiftById(couponId);
    }

    /**
     * 查询兑换卷(已兑换)列表
     * 
     * @param shzjCouponGift 兑换卷(已兑换)
     * @return 兑换卷(已兑换)
     */
    @Override
    public List<ShzjCouponGift> selectShzjCouponGiftList(ShzjCouponGift shzjCouponGift)
    {
        return shzjCouponGiftMapper.selectShzjCouponGiftList(shzjCouponGift);
    }

    /**
     * 新增兑换卷(已兑换)
     * 
     * @param shzjCouponGift 兑换卷(已兑换)
     * @return 结果
     */
    @Override
    public int insertShzjCouponGift(ShzjCouponGift shzjCouponGift)
    {
        shzjCouponGift.setCreateTime(DateUtils.getNowDate());
        return shzjCouponGiftMapper.insertShzjCouponGift(shzjCouponGift);
    }

    /**
     * 修改兑换卷(已兑换)
     * 
     * @param shzjCouponGift 兑换卷(已兑换)
     * @return 结果
     */
    @Override
    public int updateShzjCouponGift(ShzjCouponGift shzjCouponGift)
    {
        return shzjCouponGiftMapper.updateShzjCouponGift(shzjCouponGift);
    }

    /**
     * 删除兑换卷(已兑换)对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjCouponGiftByIds(String ids)
    {
        return shzjCouponGiftMapper.deleteShzjCouponGiftByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除兑换卷(已兑换)信息
     * 
     * @param couponId 兑换卷(已兑换)ID
     * @return 结果
     */
    @Override
    public int deleteShzjCouponGiftById(Integer couponId)
    {
        return shzjCouponGiftMapper.deleteShzjCouponGiftById(couponId);
    }

    @Override
    public int insertShzjMyCouponGift(CouponDTO couponDTO) {
        return shzjCouponGiftMapper.insertShzjMyCouponGift(couponDTO);
    }
}
