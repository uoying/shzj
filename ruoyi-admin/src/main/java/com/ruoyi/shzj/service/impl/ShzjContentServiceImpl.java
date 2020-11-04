package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjContentMapper;
import com.ruoyi.shzj.domain.ShzjContent;
import com.ruoyi.shzj.service.IShzjContentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 内容信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-16
 */
@Service
public class ShzjContentServiceImpl implements IShzjContentService 
{
    @Autowired
    private ShzjContentMapper shzjContentMapper;

    /**
     * 查询内容信息
     * 
     * @param conId 内容信息ID
     * @return 内容信息
     */
    @Override
    public ShzjContent selectShzjContentById(Integer conId)
    {
        return shzjContentMapper.selectShzjContentById(conId);
    }

    /**
     * 查询内容信息列表
     * 
     * @param shzjContent 内容信息
     * @return 内容信息
     */
    @Override
    public List<ShzjContent> selectShzjContentList(ShzjContent shzjContent)
    {
        return shzjContentMapper.selectShzjContentList(shzjContent);
    }

    /**
     * 新增内容信息
     * 
     * @param shzjContent 内容信息
     * @return 结果
     */
    @Override
    public int insertShzjContent(ShzjContent shzjContent)
    {
        return shzjContentMapper.insertShzjContent(shzjContent);
    }

    /**
     * 修改内容信息
     * 
     * @param shzjContent 内容信息
     * @return 结果
     */
    @Override
    public int updateShzjContent(ShzjContent shzjContent)
    {
        return shzjContentMapper.updateShzjContent(shzjContent);
    }

    /**
     * 删除内容信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjContentByIds(String ids)
    {
        return shzjContentMapper.deleteShzjContentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除内容信息信息
     * 
     * @param conId 内容信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjContentById(Integer conId)
    {
        return shzjContentMapper.deleteShzjContentById(conId);
    }
}
