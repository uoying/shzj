package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjCustomizationMapper;
import com.ruoyi.shzj.domain.ShzjCustomization;
import com.ruoyi.shzj.service.IShzjCustomizationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 定制信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
@Service
public class ShzjCustomizationServiceImpl implements IShzjCustomizationService 
{
    @Autowired
    private ShzjCustomizationMapper shzjCustomizationMapper;

    /**
     * 查询定制信息
     * 
     * @param customId 定制信息ID
     * @return 定制信息
     */
    @Override
    public ShzjCustomization selectShzjCustomizationById(Integer customId)
    {
        return shzjCustomizationMapper.selectShzjCustomizationById(customId);
    }

    /**
     * 查询定制信息列表
     * 
     * @param shzjCustomization 定制信息
     * @return 定制信息
     */
    @Override
    public List<ShzjCustomization> selectShzjCustomizationList(ShzjCustomization shzjCustomization)
    {
        return shzjCustomizationMapper.selectShzjCustomizationList(shzjCustomization);
    }

    /**
     * 新增定制信息
     * 
     * @param shzjCustomization 定制信息
     * @return 结果
     */
    @Override
    public int insertShzjCustomization(ShzjCustomization shzjCustomization)
    {
        return shzjCustomizationMapper.insertShzjCustomization(shzjCustomization);
    }

    /**
     * 修改定制信息
     * 
     * @param shzjCustomization 定制信息
     * @return 结果
     */
    @Override
    public int updateShzjCustomization(ShzjCustomization shzjCustomization)
    {
        return shzjCustomizationMapper.updateShzjCustomization(shzjCustomization);
    }

    /**
     * 删除定制信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjCustomizationByIds(String ids)
    {
        return shzjCustomizationMapper.deleteShzjCustomizationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除定制信息信息
     * 
     * @param customId 定制信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjCustomizationById(Integer customId)
    {
        return shzjCustomizationMapper.deleteShzjCustomizationById(customId);
    }
}
