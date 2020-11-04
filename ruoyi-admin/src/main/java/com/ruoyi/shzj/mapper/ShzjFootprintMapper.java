package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjFootprint;

/**
 * 足迹信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
public interface ShzjFootprintMapper 
{
    /**
     * 查询足迹信息
     * 
     * @param footId 足迹信息ID
     * @return 足迹信息
     */
    public ShzjFootprint selectShzjFootprintById(Integer footId);

    /**
     * 查询足迹信息列表
     * 
     * @param shzjFootprint 足迹信息
     * @return 足迹信息集合
     */
    public List<ShzjFootprint> selectShzjFootprintList(ShzjFootprint shzjFootprint);

    /**
     * 查询足迹信息列表按时间排序
     *
     * @param shzjFootprint 足迹信息
     * @return 足迹信息集合
     */
    public List<ShzjFootprint> selectShzjFootprintListOrderByCreatTime(ShzjFootprint shzjFootprint);

    /**
     * 新增足迹信息
     * 
     * @param shzjFootprint 足迹信息
     * @return 结果
     */
    public int insertShzjFootprint(ShzjFootprint shzjFootprint);

    /**
     * 修改足迹信息
     * 
     * @param shzjFootprint 足迹信息
     * @return 结果
     */
    public int updateShzjFootprint(ShzjFootprint shzjFootprint);

    /**
     * 删除足迹信息
     * 
     * @param footId 足迹信息ID
     * @return 结果
     */
    public int deleteShzjFootprintById(Integer footId);

    /**
     * 批量删除足迹信息
     * 
     * @param footIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjFootprintByIds(String[] footIds);
}
