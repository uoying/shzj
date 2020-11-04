package com.ruoyi.shzj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjCouponMapper;
import com.ruoyi.shzj.domain.ShzjCoupon;
import com.ruoyi.shzj.service.IShzjCouponService;
import com.ruoyi.common.core.text.Convert;

/**
 * 兑换卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class ShzjCouponServiceImpl implements IShzjCouponService 
{
    @Autowired
    private ShzjCouponMapper shzjCouponMapper;

    /**
     * 查询兑换卷
     * 
     * @param couponId 兑换卷ID
     * @return 兑换卷
     */
    @Override
    public ShzjCoupon selectShzjCouponById(Integer couponId)
    {
        return shzjCouponMapper.selectShzjCouponById(couponId);
    }

    /**
     * 查询兑换卷列表
     * 
     * @param shzjCoupon 兑换卷
     * @return 兑换卷
     */
    @Override
    public List<ShzjCoupon> selectShzjCouponList(ShzjCoupon shzjCoupon)
    {
        return shzjCouponMapper.selectShzjCouponList(shzjCoupon);
    }

    /**
     * 新增兑换卷
     * 
     * @param shzjCoupon 兑换卷
     * @return 结果
     */
    @Override
    public int insertShzjCoupon(ShzjCoupon shzjCoupon)
    {
        shzjCoupon.setCreateTime(DateUtils.getNowDate());
        return shzjCouponMapper.insertShzjCoupon(shzjCoupon);
    }

    /**
     * 修改兑换卷
     * 
     * @param shzjCoupon 兑换卷
     * @return 结果
     */
    @Override
    public int updateShzjCoupon(ShzjCoupon shzjCoupon)
    {
        return shzjCouponMapper.updateShzjCoupon(shzjCoupon);
    }

    /**
     * 删除兑换卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjCouponByIds(String ids)
    {
        return shzjCouponMapper.deleteShzjCouponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除兑换卷信息
     * 
     * @param couponId 兑换卷ID
     * @return 结果
     */
    @Override
    public int deleteShzjCouponById(Integer couponId)
    {
        return shzjCouponMapper.deleteShzjCouponById(couponId);
    }
}
