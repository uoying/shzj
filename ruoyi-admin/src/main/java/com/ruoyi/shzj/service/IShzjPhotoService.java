package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjPhoto;

/**
 * 照片信息Service接口
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
public interface IShzjPhotoService 
{
    /**
     * 查询照片信息
     * 
     * @param photoId 照片信息ID
     * @return 照片信息
     */
    public ShzjPhoto selectShzjPhotoById(Integer photoId);

    /**
     * 查询照片信息列表
     * 
     * @param shzjPhoto 照片信息
     * @return 照片信息集合
     */
    public List<ShzjPhoto> selectShzjPhotoList(ShzjPhoto shzjPhoto);

    /**
     * 新增照片信息
     * 
     * @param shzjPhoto 照片信息
     * @return 结果
     */
    public int insertShzjPhoto(ShzjPhoto shzjPhoto);

    /**
     * 修改照片信息
     * 
     * @param shzjPhoto 照片信息
     * @return 结果
     */
    public int updateShzjPhoto(ShzjPhoto shzjPhoto);

    /**
     * 批量删除照片信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjPhotoByIds(String ids);

    /**
     * 删除照片信息信息
     * 
     * @param photoId 照片信息ID
     * @return 结果
     */
    public int deleteShzjPhotoById(Integer photoId);
}
