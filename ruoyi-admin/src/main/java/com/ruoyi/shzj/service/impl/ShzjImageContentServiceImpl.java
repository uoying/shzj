package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjImageContentMapper;
import com.ruoyi.shzj.domain.ShzjImageContent;
import com.ruoyi.shzj.service.IShzjImageContentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 图像识别:图片信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
@Service
public class ShzjImageContentServiceImpl implements IShzjImageContentService 
{
    @Autowired
    private ShzjImageContentMapper shzjImageContentMapper;

    /**
     * 查询图像识别:图片信息
     * 
     * @param imageContentId 图像识别:图片信息ID
     * @return 图像识别:图片信息
     */
    @Override
    public ShzjImageContent selectShzjImageContentById(Integer imageContentId)
    {
        return shzjImageContentMapper.selectShzjImageContentById(imageContentId);
    }

    /**
     * 查询图像识别:图片信息列表
     * 
     * @param shzjImageContent 图像识别:图片信息
     * @return 图像识别:图片信息
     */
    @Override
    public List<ShzjImageContent> selectShzjImageContentList(ShzjImageContent shzjImageContent)
    {
        return shzjImageContentMapper.selectShzjImageContentList(shzjImageContent);
    }

    /**
     * 新增图像识别:图片信息
     * 
     * @param shzjImageContent 图像识别:图片信息
     * @return 结果
     */
    @Override
    public int insertShzjImageContent(ShzjImageContent shzjImageContent)
    {
        return shzjImageContentMapper.insertShzjImageContent(shzjImageContent);
    }

    /**
     * 修改图像识别:图片信息
     * 
     * @param shzjImageContent 图像识别:图片信息
     * @return 结果
     */
    @Override
    public int updateShzjImageContent(ShzjImageContent shzjImageContent)
    {
        return shzjImageContentMapper.updateShzjImageContent(shzjImageContent);
    }

    /**
     * 删除图像识别:图片信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjImageContentByIds(String ids)
    {
        return shzjImageContentMapper.deleteShzjImageContentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除图像识别:图片信息信息
     * 
     * @param imageContentId 图像识别:图片信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjImageContentById(Integer imageContentId)
    {
        return shzjImageContentMapper.deleteShzjImageContentById(imageContentId);
    }
}
