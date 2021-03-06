package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjImageContent;

/**
 * 图像识别:图片信息Service接口
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
public interface IShzjImageContentService 
{
    /**
     * 查询图像识别:图片信息
     * 
     * @param imageContentId 图像识别:图片信息ID
     * @return 图像识别:图片信息
     */
    public ShzjImageContent selectShzjImageContentById(Integer imageContentId);

    /**
     * 查询图像识别:图片信息列表
     * 
     * @param shzjImageContent 图像识别:图片信息
     * @return 图像识别:图片信息集合
     */
    public List<ShzjImageContent> selectShzjImageContentList(ShzjImageContent shzjImageContent);

    /**
     * 新增图像识别:图片信息
     * 
     * @param shzjImageContent 图像识别:图片信息
     * @return 结果
     */
    public int insertShzjImageContent(ShzjImageContent shzjImageContent);

    /**
     * 修改图像识别:图片信息
     * 
     * @param shzjImageContent 图像识别:图片信息
     * @return 结果
     */
    public int updateShzjImageContent(ShzjImageContent shzjImageContent);

    /**
     * 批量删除图像识别:图片信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjImageContentByIds(String ids);

    /**
     * 删除图像识别:图片信息信息
     * 
     * @param imageContentId 图像识别:图片信息ID
     * @return 结果
     */
    public int deleteShzjImageContentById(Integer imageContentId);
}
