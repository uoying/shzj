package com.ruoyi.shzj.service.impl;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.ImageDTO;
import com.ruoyi.shzj.domain.DTO.TxsbDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjImageMapper;
import com.ruoyi.shzj.domain.ShzjImage;
import com.ruoyi.shzj.service.IShzjImageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 图像识别:图片Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
@Service
public class ShzjImageServiceImpl implements IShzjImageService 
{
    @Autowired
    private ShzjImageMapper shzjImageMapper;

    /**
     * 查询图像识别:图片
     * 
     * @param imageId 图像识别:图片ID
     * @return 图像识别:图片
     */
    @Override
    public ShzjImage selectShzjImageById(Integer imageId)
    {
        return shzjImageMapper.selectShzjImageById(imageId);
    }

    /**
     * 查询图像识别:图片列表
     * 
     * @param shzjImage 图像识别:图片
     * @return 图像识别:图片
     */
    @Override
    public List<ShzjImage> selectShzjImageList(ShzjImage shzjImage)
    {
        return shzjImageMapper.selectShzjImageList(shzjImage);
    }

    /**
     * 新增图像识别:图片
     * 
     * @param shzjImage 图像识别:图片
     * @return 结果
     */
    @Override
    public int insertShzjImage(ShzjImage shzjImage)
    {
        return shzjImageMapper.insertShzjImage(shzjImage);
    }

    /**
     * 修改图像识别:图片
     * 
     * @param shzjImage 图像识别:图片
     * @return 结果
     */
    @Override
    public int updateShzjImage(ShzjImage shzjImage)
    {
        return shzjImageMapper.updateShzjImage(shzjImage);
    }

    /**
     * 删除图像识别:图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjImageByIds(String ids)
    {
        return shzjImageMapper.deleteShzjImageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除图像识别:图片信息
     * 
     * @param imageId 图像识别:图片ID
     * @return 结果
     */
    @Override
    public int deleteShzjImageById(Integer imageId)
    {
        return shzjImageMapper.deleteShzjImageById(imageId);
    }

    @Override
    public TxsbDTO selectShzjImageH5(Integer imageContentId) {
        return shzjImageMapper.selectShzjImageH5(imageContentId);
    }

    @Override
    public List<ImageDTO> selectShzjImage() {
        return shzjImageMapper.selectShzjImage();
    }
}
