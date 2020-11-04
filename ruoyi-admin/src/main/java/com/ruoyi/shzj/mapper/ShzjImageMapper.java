package com.ruoyi.shzj.mapper;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.ImageDTO;
import com.ruoyi.shzj.domain.DTO.TxsbDTO;
import com.ruoyi.shzj.domain.ShzjImage;

/**
 * 图像识别:图片Mapper接口
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
public interface ShzjImageMapper 
{
    /**
     * 查询图像识别:图片
     * 
     * @param imageId 图像识别:图片ID
     * @return 图像识别:图片
     */
    public ShzjImage selectShzjImageById(Integer imageId);

    /**
     * 查询图像识别:图片列表
     * 
     * @param shzjImage 图像识别:图片
     * @return 图像识别:图片集合
     */
    public List<ShzjImage> selectShzjImageList(ShzjImage shzjImage);

    /**
     * 新增图像识别:图片
     * 
     * @param shzjImage 图像识别:图片
     * @return 结果
     */
    public int insertShzjImage(ShzjImage shzjImage);

    /**
     * 修改图像识别:图片
     * 
     * @param shzjImage 图像识别:图片
     * @return 结果
     */
    public int updateShzjImage(ShzjImage shzjImage);

    /**
     * 删除图像识别:图片
     * 
     * @param imageId 图像识别:图片ID
     * @return 结果
     */
    public int deleteShzjImageById(Integer imageId);

    /**
     * 批量删除图像识别:图片
     * 
     * @param imageIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjImageByIds(String[] imageIds);
    TxsbDTO selectShzjImageH5(Integer imageContentId);
    List<ImageDTO> selectShzjImage();
}
