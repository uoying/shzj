package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjGift;

/**
 * 礼包信息Service接口
 * 
 * @author ruoyi
 * @date 2020-07-29
 */
public interface IShzjGiftService 
{
    /**
     * 查询礼包信息
     * 
     * @param giftId 礼包信息ID
     * @return 礼包信息
     */
    public ShzjGift selectShzjGiftById(Integer giftId);

    /**
     * 查询礼包信息列表
     * 
     * @param shzjGift 礼包信息
     * @return 礼包信息集合
     */
    public List<ShzjGift> selectShzjGiftList(ShzjGift shzjGift);

    /**
     * 新增礼包信息
     * 
     * @param shzjGift 礼包信息
     * @return 结果
     */
    public int insertShzjGift(ShzjGift shzjGift);

    /**
     * 修改礼包信息
     * 
     * @param shzjGift 礼包信息
     * @return 结果
     */
    public int updateShzjGift(ShzjGift shzjGift);

    /**
     * 批量删除礼包信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjGiftByIds(String ids);

    /**
     * 删除礼包信息信息
     * 
     * @param giftId 礼包信息ID
     * @return 结果
     */
    public int deleteShzjGiftById(Integer giftId);
}
