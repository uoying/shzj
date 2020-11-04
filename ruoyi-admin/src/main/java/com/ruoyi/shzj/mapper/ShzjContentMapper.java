package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjContent;

/**
 * 内容信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-16
 */
public interface ShzjContentMapper 
{
    /**
     * 查询内容信息
     * 
     * @param conId 内容信息ID
     * @return 内容信息
     */
    public ShzjContent selectShzjContentById(Integer conId);

    /**
     * 查询内容信息列表
     * 
     * @param shzjContent 内容信息
     * @return 内容信息集合
     */
    public List<ShzjContent> selectShzjContentList(ShzjContent shzjContent);

    /**
     * 新增内容信息
     * 
     * @param shzjContent 内容信息
     * @return 结果
     */
    public int insertShzjContent(ShzjContent shzjContent);

    /**
     * 修改内容信息
     * 
     * @param shzjContent 内容信息
     * @return 结果
     */
    public int updateShzjContent(ShzjContent shzjContent);

    /**
     * 删除内容信息
     * 
     * @param conId 内容信息ID
     * @return 结果
     */
    public int deleteShzjContentById(Integer conId);

    /**
     * 批量删除内容信息
     * 
     * @param conIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjContentByIds(String[] conIds);
}
