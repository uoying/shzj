package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjCityMapper;
import com.ruoyi.shzj.domain.ShzjCity;
import com.ruoyi.shzj.service.IShzjCityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 城市信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
@Service
public class ShzjCityServiceImpl implements IShzjCityService 
{
    @Autowired
    private ShzjCityMapper shzjCityMapper;

    /**
     * 查询城市信息
     * 
     * @param cityId 城市信息ID
     * @return 城市信息
     */
    @Override
    public ShzjCity selectShzjCityById(Integer cityId)
    {
        return shzjCityMapper.selectShzjCityById(cityId);
    }

    /**
     * 查询城市信息列表
     * 
     * @param shzjCity 城市信息
     * @return 城市信息
     */
    @Override
    public List<ShzjCity> selectShzjCityList(ShzjCity shzjCity)
    {
        return shzjCityMapper.selectShzjCityList(shzjCity);
    }

    /**
     * 新增城市信息
     * 
     * @param shzjCity 城市信息
     * @return 结果
     */
    @Override
    public int insertShzjCity(ShzjCity shzjCity)
    {
        return shzjCityMapper.insertShzjCity(shzjCity);
    }

    /**
     * 修改城市信息
     * 
     * @param shzjCity 城市信息
     * @return 结果
     */
    @Override
    public int updateShzjCity(ShzjCity shzjCity)
    {
        return shzjCityMapper.updateShzjCity(shzjCity);
    }

    /**
     * 删除城市信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjCityByIds(String ids)
    {
        return shzjCityMapper.deleteShzjCityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除城市信息信息
     * 
     * @param cityId 城市信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjCityById(Integer cityId)
    {
        return shzjCityMapper.deleteShzjCityById(cityId);
    }

    @Override
    public List<ShzjCity> selectShzjFeaCityList() {
        return shzjCityMapper.selectShzjFeaCityList();
    }
}
