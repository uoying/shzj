package com.ruoyi.shzj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjFootprintMapper;
import com.ruoyi.shzj.domain.ShzjFootprint;
import com.ruoyi.shzj.service.IShzjFootprintService;
import com.ruoyi.common.core.text.Convert;

/**
 * 足迹信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
@Service
public class ShzjFootprintServiceImpl implements IShzjFootprintService 
{
    @Autowired
    private ShzjFootprintMapper shzjFootprintMapper;

    /**
     * 查询足迹信息
     * 
     * @param footId 足迹信息ID
     * @return 足迹信息
     */
    @Override
    public ShzjFootprint selectShzjFootprintById(Integer footId)
    {
        return shzjFootprintMapper.selectShzjFootprintById(footId);
    }

    /**
     * 查询足迹信息列表
     * 
     * @param shzjFootprint 足迹信息
     * @return 足迹信息
     */
    @Override
    public List<ShzjFootprint> selectShzjFootprintList(ShzjFootprint shzjFootprint)
    {
        return shzjFootprintMapper.selectShzjFootprintList(shzjFootprint);
    }

    @Override
    public List<ShzjFootprint> selectShzjFootprintListOrderByCreatTime(ShzjFootprint shzjFootprint) {
        return shzjFootprintMapper.selectShzjFootprintListOrderByCreatTime(shzjFootprint);
    }

    /**
     * 新增足迹信息
     * 
     * @param shzjFootprint 足迹信息
     * @return 结果
     */
    @Override
    public int insertShzjFootprint(ShzjFootprint shzjFootprint)
    {
        shzjFootprint.setCreateTime(DateUtils.getNowDate());
        return shzjFootprintMapper.insertShzjFootprint(shzjFootprint);
    }

    /**
     * 修改足迹信息
     * 
     * @param shzjFootprint 足迹信息
     * @return 结果
     */
    @Override
    public int updateShzjFootprint(ShzjFootprint shzjFootprint)
    {
        return shzjFootprintMapper.updateShzjFootprint(shzjFootprint);
    }

    /**
     * 删除足迹信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjFootprintByIds(String ids)
    {
        return shzjFootprintMapper.deleteShzjFootprintByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除足迹信息信息
     * 
     * @param footId 足迹信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjFootprintById(Integer footId)
    {
        return shzjFootprintMapper.deleteShzjFootprintById(footId);
    }
}
