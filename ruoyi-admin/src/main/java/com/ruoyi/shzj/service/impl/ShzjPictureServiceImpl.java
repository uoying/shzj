package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjPictureMapper;
import com.ruoyi.shzj.domain.ShzjPicture;
import com.ruoyi.shzj.service.IShzjPictureService;
import com.ruoyi.common.core.text.Convert;

/**
 * 图片信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
@Service
public class ShzjPictureServiceImpl implements IShzjPictureService 
{
    @Autowired
    private ShzjPictureMapper shzjPictureMapper;

    /**
     * 查询图片信息
     * 
     * @param picId 图片信息ID
     * @return 图片信息
     */
    @Override
    public ShzjPicture selectShzjPictureById(Integer picId)
    {
        return shzjPictureMapper.selectShzjPictureById(picId);
    }

    /**
     * 查询图片信息列表
     * 
     * @param shzjPicture 图片信息
     * @return 图片信息
     */
    @Override
    public List<ShzjPicture> selectShzjPictureList(ShzjPicture shzjPicture)
    {
        return shzjPictureMapper.selectShzjPictureList(shzjPicture);
    }

    /**
     * 新增图片信息
     * 
     * @param shzjPicture 图片信息
     * @return 结果
     */
    @Override
    public int insertShzjPicture(ShzjPicture shzjPicture)
    {
        return shzjPictureMapper.insertShzjPicture(shzjPicture);
    }

    /**
     * 修改图片信息
     * 
     * @param shzjPicture 图片信息
     * @return 结果
     */
    @Override
    public int updateShzjPicture(ShzjPicture shzjPicture)
    {
        return shzjPictureMapper.updateShzjPicture(shzjPicture);
    }

    /**
     * 删除图片信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjPictureByIds(String ids)
    {
        return shzjPictureMapper.deleteShzjPictureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除图片信息信息
     * 
     * @param picId 图片信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjPictureById(Integer picId)
    {
        return shzjPictureMapper.deleteShzjPictureById(picId);
    }
}
