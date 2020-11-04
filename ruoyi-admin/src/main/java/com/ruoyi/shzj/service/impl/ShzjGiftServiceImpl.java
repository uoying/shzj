package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjGiftMapper;
import com.ruoyi.shzj.domain.ShzjGift;
import com.ruoyi.shzj.service.IShzjGiftService;
import com.ruoyi.common.core.text.Convert;

/**
 * 礼包信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-29
 */
@Service
public class ShzjGiftServiceImpl implements IShzjGiftService 
{
    @Autowired
    private ShzjGiftMapper shzjGiftMapper;

    /**
     * 查询礼包信息
     * 
     * @param giftId 礼包信息ID
     * @return 礼包信息
     */
    @Override
    public ShzjGift selectShzjGiftById(Integer giftId)
    {
        return shzjGiftMapper.selectShzjGiftById(giftId);
    }

    /**
     * 查询礼包信息列表
     * 
     * @param shzjGift 礼包信息
     * @return 礼包信息
     */
    @Override
    public List<ShzjGift> selectShzjGiftList(ShzjGift shzjGift)
    {
        return shzjGiftMapper.selectShzjGiftList(shzjGift);
    }

    /**
     * 新增礼包信息
     * 
     * @param shzjGift 礼包信息
     * @return 结果
     */
    @Override
    public int insertShzjGift(ShzjGift shzjGift)
    {
        return shzjGiftMapper.insertShzjGift(shzjGift);
    }

    /**
     * 修改礼包信息
     * 
     * @param shzjGift 礼包信息
     * @return 结果
     */
    @Override
    public int updateShzjGift(ShzjGift shzjGift)
    {
        return shzjGiftMapper.updateShzjGift(shzjGift);
    }

    /**
     * 删除礼包信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjGiftByIds(String ids)
    {
        return shzjGiftMapper.deleteShzjGiftByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除礼包信息信息
     * 
     * @param giftId 礼包信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjGiftById(Integer giftId)
    {
        return shzjGiftMapper.deleteShzjGiftById(giftId);
    }
}
