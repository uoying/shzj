package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjSilkMapper;
import com.ruoyi.shzj.domain.ShzjSilk;
import com.ruoyi.shzj.service.IShzjSilkService;
import com.ruoyi.common.core.text.Convert;

/**
 * 锦囊信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
@Service
public class ShzjSilkServiceImpl implements IShzjSilkService 
{
    @Autowired
    private ShzjSilkMapper shzjSilkMapper;

    /**
     * 查询锦囊信息
     * 
     * @param silkId 锦囊信息ID
     * @return 锦囊信息
     */
    @Override
    public ShzjSilk selectShzjSilkById(Integer silkId)
    {
        return shzjSilkMapper.selectShzjSilkById(silkId);
    }

    /**
     * 查询锦囊信息列表
     * 
     * @param shzjSilk 锦囊信息
     * @return 锦囊信息
     */
    @Override
    public List<ShzjSilk> selectShzjSilkList(ShzjSilk shzjSilk)
    {
        return shzjSilkMapper.selectShzjSilkList(shzjSilk);
    }

    /**
     * 新增锦囊信息
     * 
     * @param shzjSilk 锦囊信息
     * @return 结果
     */
    @Override
    public int insertShzjSilk(ShzjSilk shzjSilk)
    {
        return shzjSilkMapper.insertShzjSilk(shzjSilk);
    }

    /**
     * 修改锦囊信息
     * 
     * @param shzjSilk 锦囊信息
     * @return 结果
     */
    @Override
    public int updateShzjSilk(ShzjSilk shzjSilk)
    {
        return shzjSilkMapper.updateShzjSilk(shzjSilk);
    }

    /**
     * 删除锦囊信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjSilkByIds(String ids)
    {
        return shzjSilkMapper.deleteShzjSilkByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除锦囊信息信息
     * 
     * @param silkId 锦囊信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjSilkById(Integer silkId)
    {
        return shzjSilkMapper.deleteShzjSilkById(silkId);
    }
}
