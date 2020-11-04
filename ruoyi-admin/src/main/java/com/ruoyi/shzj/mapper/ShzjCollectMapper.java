package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjCollect;

/**
 * 收藏列表Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-24
 */
public interface ShzjCollectMapper 
{
    /**
     * 查询收藏列表
     * 
     * @param id 收藏列表ID
     * @return 收藏列表
     */
    public ShzjCollect selectShzjCollectById(Integer id);

    /**
     * 查询收藏列表列表
     * 
     * @param shzjCollect 收藏列表
     * @return 收藏列表集合
     */
    public List<ShzjCollect> selectShzjCollectList(ShzjCollect shzjCollect);

    /**
     * 新增收藏列表
     * 
     * @param shzjCollect 收藏列表
     * @return 结果
     */
    public int insertShzjCollect(ShzjCollect shzjCollect);

    /**
     * 修改收藏列表
     * 
     * @param shzjCollect 收藏列表
     * @return 结果
     */
    public int updateShzjCollect(ShzjCollect shzjCollect);

    /**
     * 删除收藏列表
     * 
     * @param id 收藏列表ID
     * @return 结果
     */
    public int deleteShzjCollectById(Integer id);

    /**
     * 批量删除收藏列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjCollectByIds(String[] ids);
}
