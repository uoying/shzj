package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjPoem;

/**
 * 诗词信息Service接口
 * 
 * @author ruoyi
 * @date 2020-07-16
 */
public interface IShzjPoemService 
{
    /**
     * 查询诗词信息
     * 
     * @param poemId 诗词信息ID
     * @return 诗词信息
     */
    public ShzjPoem selectShzjPoemById(Integer poemId);

    /**
     * 查询诗词信息列表
     * 
     * @param shzjPoem 诗词信息
     * @return 诗词信息集合
     */
    public List<ShzjPoem> selectShzjPoemList(ShzjPoem shzjPoem);

    /**
     * 新增诗词信息
     * 
     * @param shzjPoem 诗词信息
     * @return 结果
     */
    public int insertShzjPoem(ShzjPoem shzjPoem);

    /**
     * 修改诗词信息
     * 
     * @param shzjPoem 诗词信息
     * @return 结果
     */
    public int updateShzjPoem(ShzjPoem shzjPoem);

    /**
     * 批量删除诗词信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjPoemByIds(String ids);

    /**
     * 删除诗词信息信息
     * 
     * @param poemId 诗词信息ID
     * @return 结果
     */
    public int deleteShzjPoemById(Integer poemId);
}
