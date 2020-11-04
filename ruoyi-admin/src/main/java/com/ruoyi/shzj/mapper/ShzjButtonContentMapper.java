package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjButtonContent;

/**
 * 按钮内容Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
public interface ShzjButtonContentMapper 
{
    /**
     * 查询按钮内容
     * 
     * @param buttonConId 按钮内容ID
     * @return 按钮内容
     */
    public ShzjButtonContent selectShzjButtonContentById(Integer buttonConId);

    /**
     * 查询按钮内容列表
     * 
     * @param shzjButtonContent 按钮内容
     * @return 按钮内容集合
     */
    public List<ShzjButtonContent> selectShzjButtonContentList(ShzjButtonContent shzjButtonContent);

    /**
     * 新增按钮内容
     * 
     * @param shzjButtonContent 按钮内容
     * @return 结果
     */
    public int insertShzjButtonContent(ShzjButtonContent shzjButtonContent);

    /**
     * 修改按钮内容
     * 
     * @param shzjButtonContent 按钮内容
     * @return 结果
     */
    public int updateShzjButtonContent(ShzjButtonContent shzjButtonContent);

    /**
     * 删除按钮内容
     * 
     * @param buttonConId 按钮内容ID
     * @return 结果
     */
    public int deleteShzjButtonContentById(Integer buttonConId);

    /**
     * 批量删除按钮内容
     * 
     * @param buttonConIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjButtonContentByIds(String[] buttonConIds);
}
