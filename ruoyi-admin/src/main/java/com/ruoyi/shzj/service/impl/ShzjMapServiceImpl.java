package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjMapMapper;
import com.ruoyi.shzj.domain.ShzjMap;
import com.ruoyi.shzj.service.IShzjMapService;
import com.ruoyi.common.core.text.Convert;

/**
 * 地图信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-13
 */
@Service
public class ShzjMapServiceImpl implements IShzjMapService 
{
    @Autowired
    private ShzjMapMapper shzjMapMapper;

    /**
     * 查询地图信息
     * 
     * @param mapId 地图信息ID
     * @return 地图信息
     */
    @Override
    public ShzjMap selectShzjMapById(Integer mapId)
    {
        return shzjMapMapper.selectShzjMapById(mapId);
    }

    /**
     * 查询地图信息列表
     * 
     * @param shzjMap 地图信息
     * @return 地图信息
     */
    @Override
    public List<ShzjMap> selectShzjMapList(ShzjMap shzjMap)
    {
        return shzjMapMapper.selectShzjMapList(shzjMap);
    }

    /**
     * 新增地图信息
     * 
     * @param shzjMap 地图信息
     * @return 结果
     */
    @Override
    public int insertShzjMap(ShzjMap shzjMap)
    {
        return shzjMapMapper.insertShzjMap(shzjMap);
    }

    /**
     * 修改地图信息
     * 
     * @param shzjMap 地图信息
     * @return 结果
     */
    @Override
    public int updateShzjMap(ShzjMap shzjMap)
    {
        return shzjMapMapper.updateShzjMap(shzjMap);
    }

    /**
     * 删除地图信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjMapByIds(String ids)
    {
        return shzjMapMapper.deleteShzjMapByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除地图信息信息
     * 
     * @param mapId 地图信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjMapById(Integer mapId)
    {
        return shzjMapMapper.deleteShzjMapById(mapId);
    }
}
