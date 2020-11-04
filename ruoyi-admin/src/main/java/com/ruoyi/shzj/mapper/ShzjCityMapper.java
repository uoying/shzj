package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjCity;

/**
 * 城市信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface ShzjCityMapper 
{
    /**
     * 查询城市信息
     * 
     * @param cityId 城市信息ID
     * @return 城市信息
     */
    public ShzjCity selectShzjCityById(Integer cityId);

    /**
     * 查询城市信息列表
     * 
     * @param shzjCity 城市信息
     * @return 城市信息集合
     */
    public List<ShzjCity> selectShzjCityList(ShzjCity shzjCity);

    /**
     * 新增城市信息
     * 
     * @param shzjCity 城市信息
     * @return 结果
     */
    public int insertShzjCity(ShzjCity shzjCity);

    /**
     * 修改城市信息
     * 
     * @param shzjCity 城市信息
     * @return 结果
     */
    public int updateShzjCity(ShzjCity shzjCity);

    /**
     * 删除城市信息
     * 
     * @param cityId 城市信息ID
     * @return 结果
     */
    public int deleteShzjCityById(Integer cityId);

    /**
     * 批量删除城市信息
     * 
     * @param cityIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjCityByIds(String[] cityIds);

    public List<ShzjCity> selectShzjFeaCityList();
}
