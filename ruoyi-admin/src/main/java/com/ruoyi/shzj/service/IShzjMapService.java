package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjMap;

/**
 * 地图信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-13
 */
public interface IShzjMapService 
{
    /**
     * 查询地图信息
     * 
     * @param mapId 地图信息ID
     * @return 地图信息
     */
    public ShzjMap selectShzjMapById(Integer mapId);

    /**
     * 查询地图信息列表
     * 
     * @param shzjMap 地图信息
     * @return 地图信息集合
     */
    public List<ShzjMap> selectShzjMapList(ShzjMap shzjMap);

    /**
     * 新增地图信息
     * 
     * @param shzjMap 地图信息
     * @return 结果
     */
    public int insertShzjMap(ShzjMap shzjMap);

    /**
     * 修改地图信息
     * 
     * @param shzjMap 地图信息
     * @return 结果
     */
    public int updateShzjMap(ShzjMap shzjMap);

    /**
     * 批量删除地图信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjMapByIds(String ids);

    /**
     * 删除地图信息信息
     * 
     * @param mapId 地图信息ID
     * @return 结果
     */
    public int deleteShzjMapById(Integer mapId);
}
