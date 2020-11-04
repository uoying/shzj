package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjType;

/**
 * 类别Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
public interface ShzjTypeMapper 
{
    /**
     * 查询类别
     * 
     * @param typeId 类别ID
     * @return 类别
     */
    public ShzjType selectShzjTypeById(Integer typeId);

    /**
     * 查询类别列表
     * 
     * @param shzjType 类别
     * @return 类别集合
     */
    public List<ShzjType> selectShzjTypeList(ShzjType shzjType);

    /**
     * 新增类别
     * 
     * @param shzjType 类别
     * @return 结果
     */
    public int insertShzjType(ShzjType shzjType);

    /**
     * 修改类别
     * 
     * @param shzjType 类别
     * @return 结果
     */
    public int updateShzjType(ShzjType shzjType);

    /**
     * 删除类别
     * 
     * @param typeId 类别ID
     * @return 结果
     */
    public int deleteShzjTypeById(Integer typeId);

    /**
     * 批量删除类别
     * 
     * @param typeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjTypeByIds(String[] typeIds);
}
