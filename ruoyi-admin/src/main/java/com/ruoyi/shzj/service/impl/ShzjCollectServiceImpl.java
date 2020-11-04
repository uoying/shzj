package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjCollectMapper;
import com.ruoyi.shzj.domain.ShzjCollect;
import com.ruoyi.shzj.service.IShzjCollectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 收藏列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-24
 */
@Service
public class ShzjCollectServiceImpl implements IShzjCollectService 
{
    @Autowired
    private ShzjCollectMapper shzjCollectMapper;

    /**
     * 查询收藏列表
     * 
     * @param id 收藏列表ID
     * @return 收藏列表
     */
    @Override
    public ShzjCollect selectShzjCollectById(Integer id)
    {
        return shzjCollectMapper.selectShzjCollectById(id);
    }

    /**
     * 查询收藏列表列表
     * 
     * @param shzjCollect 收藏列表
     * @return 收藏列表
     */
    @Override
    public List<ShzjCollect> selectShzjCollectList(ShzjCollect shzjCollect)
    {
        return shzjCollectMapper.selectShzjCollectList(shzjCollect);
    }

    /**
     * 新增收藏列表
     * 
     * @param shzjCollect 收藏列表
     * @return 结果
     */
    @Override
    public int insertShzjCollect(ShzjCollect shzjCollect)
    {
        return shzjCollectMapper.insertShzjCollect(shzjCollect);
    }

    /**
     * 修改收藏列表
     * 
     * @param shzjCollect 收藏列表
     * @return 结果
     */
    @Override
    public int updateShzjCollect(ShzjCollect shzjCollect)
    {
        return shzjCollectMapper.updateShzjCollect(shzjCollect);
    }

    /**
     * 删除收藏列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjCollectByIds(String ids)
    {
        return shzjCollectMapper.deleteShzjCollectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收藏列表信息
     * 
     * @param id 收藏列表ID
     * @return 结果
     */
    @Override
    public int deleteShzjCollectById(Integer id)
    {
        return shzjCollectMapper.deleteShzjCollectById(id);
    }
}
