package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjContentParticular;

/**
 * 内容详情信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
public interface ShzjContentParticularMapper 
{
    /**
     * 查询内容详情信息
     * 
     * @param particularId 内容详情信息ID
     * @return 内容详情信息
     */
    public ShzjContentParticular selectShzjContentParticularById(Integer particularId);

    /**
     * 查询内容详情信息列表
     * 
     * @param shzjContentParticular 内容详情信息
     * @return 内容详情信息集合
     */
    public List<ShzjContentParticular> selectShzjContentParticularList(ShzjContentParticular shzjContentParticular);

    /**
     * 新增内容详情信息
     * 
     * @param shzjContentParticular 内容详情信息
     * @return 结果
     */
    public int insertShzjContentParticular(ShzjContentParticular shzjContentParticular);

    /**
     * 修改内容详情信息
     * 
     * @param shzjContentParticular 内容详情信息
     * @return 结果
     */
    public int updateShzjContentParticular(ShzjContentParticular shzjContentParticular);

    /**
     * 删除内容详情信息
     * 
     * @param particularId 内容详情信息ID
     * @return 结果
     */
    public int deleteShzjContentParticularById(Integer particularId);

    /**
     * 批量删除内容详情信息
     * 
     * @param particularIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjContentParticularByIds(String[] particularIds);
}
