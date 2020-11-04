package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjButtonContentMapper;
import com.ruoyi.shzj.domain.ShzjButtonContent;
import com.ruoyi.shzj.service.IShzjButtonContentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 按钮内容Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
@Service
public class ShzjButtonContentServiceImpl implements IShzjButtonContentService 
{
    @Autowired
    private ShzjButtonContentMapper shzjButtonContentMapper;

    /**
     * 查询按钮内容
     * 
     * @param buttonConId 按钮内容ID
     * @return 按钮内容
     */
    @Override
    public ShzjButtonContent selectShzjButtonContentById(Integer buttonConId)
    {
        return shzjButtonContentMapper.selectShzjButtonContentById(buttonConId);
    }

    /**
     * 查询按钮内容列表
     * 
     * @param shzjButtonContent 按钮内容
     * @return 按钮内容
     */
    @Override
    public List<ShzjButtonContent> selectShzjButtonContentList(ShzjButtonContent shzjButtonContent)
    {
        return shzjButtonContentMapper.selectShzjButtonContentList(shzjButtonContent);
    }

    /**
     * 新增按钮内容
     * 
     * @param shzjButtonContent 按钮内容
     * @return 结果
     */
    @Override
    public int insertShzjButtonContent(ShzjButtonContent shzjButtonContent)
    {
        return shzjButtonContentMapper.insertShzjButtonContent(shzjButtonContent);
    }

    /**
     * 修改按钮内容
     * 
     * @param shzjButtonContent 按钮内容
     * @return 结果
     */
    @Override
    public int updateShzjButtonContent(ShzjButtonContent shzjButtonContent)
    {
        return shzjButtonContentMapper.updateShzjButtonContent(shzjButtonContent);
    }

    /**
     * 删除按钮内容对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjButtonContentByIds(String ids)
    {
        return shzjButtonContentMapper.deleteShzjButtonContentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除按钮内容信息
     * 
     * @param buttonConId 按钮内容ID
     * @return 结果
     */
    @Override
    public int deleteShzjButtonContentById(Integer buttonConId)
    {
        return shzjButtonContentMapper.deleteShzjButtonContentById(buttonConId);
    }
}
