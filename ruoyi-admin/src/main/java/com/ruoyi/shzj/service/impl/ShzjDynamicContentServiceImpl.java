package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjDynamicContentMapper;
import com.ruoyi.shzj.domain.ShzjDynamicContent;
import com.ruoyi.shzj.service.IShzjDynamicContentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 动态详情信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
@Service
public class ShzjDynamicContentServiceImpl implements IShzjDynamicContentService 
{
    @Autowired
    private ShzjDynamicContentMapper shzjDynamicContentMapper;

    /**
     * 查询动态详情信息
     * 
     * @param dynamicContentId 动态详情信息ID
     * @return 动态详情信息
     */
    @Override
    public ShzjDynamicContent selectShzjDynamicContentById(Integer dynamicContentId)
    {
        return shzjDynamicContentMapper.selectShzjDynamicContentById(dynamicContentId);
    }

    /**
     * 查询动态详情信息列表
     * 
     * @param shzjDynamicContent 动态详情信息
     * @return 动态详情信息
     */
    @Override
    public List<ShzjDynamicContent> selectShzjDynamicContentList(ShzjDynamicContent shzjDynamicContent)
    {
        return shzjDynamicContentMapper.selectShzjDynamicContentList(shzjDynamicContent);
    }

    /**
     * 新增动态详情信息
     * 
     * @param shzjDynamicContent 动态详情信息
     * @return 结果
     */
    @Override
    public int insertShzjDynamicContent(ShzjDynamicContent shzjDynamicContent)
    {
        return shzjDynamicContentMapper.insertShzjDynamicContent(shzjDynamicContent);
    }

    /**
     * 修改动态详情信息
     * 
     * @param shzjDynamicContent 动态详情信息
     * @return 结果
     */
    @Override
    public int updateShzjDynamicContent(ShzjDynamicContent shzjDynamicContent)
    {
        return shzjDynamicContentMapper.updateShzjDynamicContent(shzjDynamicContent);
    }

    /**
     * 删除动态详情信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjDynamicContentByIds(String ids)
    {
        return shzjDynamicContentMapper.deleteShzjDynamicContentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除动态详情信息信息
     * 
     * @param dynamicContentId 动态详情信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjDynamicContentById(Integer dynamicContentId)
    {
        return shzjDynamicContentMapper.deleteShzjDynamicContentById(dynamicContentId);
    }
}
