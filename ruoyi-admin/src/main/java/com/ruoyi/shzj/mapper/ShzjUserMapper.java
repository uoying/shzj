package com.ruoyi.shzj.mapper;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.HeadPortraitDTO;
import com.ruoyi.shzj.domain.DTO.PhbDTO;
import com.ruoyi.shzj.domain.ShzjUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-28
 */
public interface ShzjUserMapper 
{
    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    public ShzjUser selectShzjUserById(Integer userId);

    /**
     * 查询用户信息列表
     * 
     * @param shzjUser 用户信息
     * @return 用户信息集合
     */
    public List<ShzjUser> selectShzjUserList(ShzjUser shzjUser);

    /**
     * 新增用户信息
     * 
     * @param shzjUser 用户信息
     * @return 结果
     */
    public int insertShzjUser(ShzjUser shzjUser);

    /**
     * 修改用户信息
     * 
     * @param shzjUser 用户信息
     * @return 结果
     */
    public int updateShzjUser(ShzjUser shzjUser);

    /**
     * 删除用户信息
     * 
     * @param userId 用户信息ID
     * @return 结果
     */
    public int deleteShzjUserById(Integer userId);

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjUserByIds(String[] userIds);

    public Integer updateShzjUserAnswer(int userId);


    Integer updateShzjUserQuiz(int userId);

    List<PhbDTO> selectShzjUserAnswerPhb();

    int updateShzjUserReward(@Param("userId") int userId,@Param("reward") int reward);
    int updateShzjSubtract(@Param("userId") int userId,@Param("jif")  int jif);
    HeadPortraitDTO selectShzjHeadPortrait(int userId);
    int selectShzjIntegral(int userId);
}
