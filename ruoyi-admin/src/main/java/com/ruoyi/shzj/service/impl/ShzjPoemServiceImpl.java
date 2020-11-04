package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjPoemMapper;
import com.ruoyi.shzj.domain.ShzjPoem;
import com.ruoyi.shzj.service.IShzjPoemService;
import com.ruoyi.common.core.text.Convert;

/**
 * 诗词信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-16
 */
@Service
public class ShzjPoemServiceImpl implements IShzjPoemService 
{
    @Autowired
    private ShzjPoemMapper shzjPoemMapper;

    /**
     * 查询诗词信息
     * 
     * @param poemId 诗词信息ID
     * @return 诗词信息
     */
    @Override
    public ShzjPoem selectShzjPoemById(Integer poemId)
    {
        return shzjPoemMapper.selectShzjPoemById(poemId);
    }

    /**
     * 查询诗词信息列表
     * 
     * @param shzjPoem 诗词信息
     * @return 诗词信息
     */
    @Override
    public List<ShzjPoem> selectShzjPoemList(ShzjPoem shzjPoem)
    {
        return shzjPoemMapper.selectShzjPoemList(shzjPoem);
    }

    /**
     * 新增诗词信息
     * 
     * @param shzjPoem 诗词信息
     * @return 结果
     */
    @Override
    public int insertShzjPoem(ShzjPoem shzjPoem)
    {
        return shzjPoemMapper.insertShzjPoem(shzjPoem);
    }

    /**
     * 修改诗词信息
     * 
     * @param shzjPoem 诗词信息
     * @return 结果
     */
    @Override
    public int updateShzjPoem(ShzjPoem shzjPoem)
    {
        return shzjPoemMapper.updateShzjPoem(shzjPoem);
    }

    /**
     * 删除诗词信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjPoemByIds(String ids)
    {
        return shzjPoemMapper.deleteShzjPoemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除诗词信息信息
     * 
     * @param poemId 诗词信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjPoemById(Integer poemId)
    {
        return shzjPoemMapper.deleteShzjPoemById(poemId);
    }
}
