package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjCustomization;

/**
 * 定制信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
public interface ShzjCustomizationMapper 
{
    /**
     * 查询定制信息
     * 
     * @param customId 定制信息ID
     * @return 定制信息
     */
    public ShzjCustomization selectShzjCustomizationById(Integer customId);

    /**
     * 查询定制信息列表
     * 
     * @param shzjCustomization 定制信息
     * @return 定制信息集合
     */
    public List<ShzjCustomization> selectShzjCustomizationList(ShzjCustomization shzjCustomization);

    /**
     * 新增定制信息
     * 
     * @param shzjCustomization 定制信息
     * @return 结果
     */
    public int insertShzjCustomization(ShzjCustomization shzjCustomization);

    /**
     * 修改定制信息
     * 
     * @param shzjCustomization 定制信息
     * @return 结果
     */
    public int updateShzjCustomization(ShzjCustomization shzjCustomization);

    /**
     * 删除定制信息
     * 
     * @param customId 定制信息ID
     * @return 结果
     */
    public int deleteShzjCustomizationById(Integer customId);

    /**
     * 批量删除定制信息
     * 
     * @param customIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjCustomizationByIds(String[] customIds);
}
