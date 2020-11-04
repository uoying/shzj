package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjSilk;

/**
 * 锦囊信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface ShzjSilkMapper 
{
    /**
     * 查询锦囊信息
     * 
     * @param silkId 锦囊信息ID
     * @return 锦囊信息
     */
    public ShzjSilk selectShzjSilkById(Integer silkId);

    /**
     * 查询锦囊信息列表
     * 
     * @param shzjSilk 锦囊信息
     * @return 锦囊信息集合
     */
    public List<ShzjSilk> selectShzjSilkList(ShzjSilk shzjSilk);

    /**
     * 新增锦囊信息
     * 
     * @param shzjSilk 锦囊信息
     * @return 结果
     */
    public int insertShzjSilk(ShzjSilk shzjSilk);

    /**
     * 修改锦囊信息
     * 
     * @param shzjSilk 锦囊信息
     * @return 结果
     */
    public int updateShzjSilk(ShzjSilk shzjSilk);

    /**
     * 删除锦囊信息
     * 
     * @param silkId 锦囊信息ID
     * @return 结果
     */
    public int deleteShzjSilkById(Integer silkId);

    /**
     * 批量删除锦囊信息
     * 
     * @param silkIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjSilkByIds(String[] silkIds);
}
