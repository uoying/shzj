package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjPhotoMapper;
import com.ruoyi.shzj.domain.ShzjPhoto;
import com.ruoyi.shzj.service.IShzjPhotoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 照片信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
@Service
public class ShzjPhotoServiceImpl implements IShzjPhotoService 
{
    @Autowired
    private ShzjPhotoMapper shzjPhotoMapper;

    /**
     * 查询照片信息
     * 
     * @param photoId 照片信息ID
     * @return 照片信息
     */
    @Override
    public ShzjPhoto selectShzjPhotoById(Integer photoId)
    {
        return shzjPhotoMapper.selectShzjPhotoById(photoId);
    }

    /**
     * 查询照片信息列表
     * 
     * @param shzjPhoto 照片信息
     * @return 照片信息
     */
    @Override
    public List<ShzjPhoto> selectShzjPhotoList(ShzjPhoto shzjPhoto)
    {
        return shzjPhotoMapper.selectShzjPhotoList(shzjPhoto);
    }

    /**
     * 新增照片信息
     * 
     * @param shzjPhoto 照片信息
     * @return 结果
     */
    @Override
    public int insertShzjPhoto(ShzjPhoto shzjPhoto)
    {
        return shzjPhotoMapper.insertShzjPhoto(shzjPhoto);
    }

    /**
     * 修改照片信息
     * 
     * @param shzjPhoto 照片信息
     * @return 结果
     */
    @Override
    public int updateShzjPhoto(ShzjPhoto shzjPhoto)
    {
        return shzjPhotoMapper.updateShzjPhoto(shzjPhoto);
    }

    /**
     * 删除照片信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjPhotoByIds(String ids)
    {
        return shzjPhotoMapper.deleteShzjPhotoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除照片信息信息
     * 
     * @param photoId 照片信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjPhotoById(Integer photoId)
    {
        return shzjPhotoMapper.deleteShzjPhotoById(photoId);
    }
}
