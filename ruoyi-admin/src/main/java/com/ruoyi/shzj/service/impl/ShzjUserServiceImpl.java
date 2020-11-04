package com.ruoyi.shzj.service.impl;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.HeadPortraitDTO;
import com.ruoyi.shzj.domain.DTO.PhbDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjUserMapper;
import com.ruoyi.shzj.domain.ShzjUser;
import com.ruoyi.shzj.service.IShzjUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户信息Service业务层处理
 *
 * @author ruoyi
 * @date 2020-07-28
 */
@Service
public class ShzjUserServiceImpl implements IShzjUserService {
    @Autowired
    private ShzjUserMapper shzjUserMapper;

    /**
     * 查询用户信息
     *
     * @param userId 用户信息ID
     * @return 用户信息
     */
    @Override
    public ShzjUser selectShzjUserById(Integer userId) {
        return shzjUserMapper.selectShzjUserById(userId);
    }

    /**
     * 查询用户信息列表
     *
     * @param shzjUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<ShzjUser> selectShzjUserList(ShzjUser shzjUser) {
        return shzjUserMapper.selectShzjUserList(shzjUser);
    }

    /**
     * 新增用户信息
     *
     * @param shzjUser 用户信息
     * @return 结果
     */
    @Override
    public int insertShzjUser(ShzjUser shzjUser) {
        return shzjUserMapper.insertShzjUser(shzjUser);
    }

    /**
     * 修改用户信息
     *
     * @param shzjUser 用户信息
     * @return 结果
     */
    @Override
    public int updateShzjUser(ShzjUser shzjUser) {
        return shzjUserMapper.updateShzjUser(shzjUser);
    }

    /**
     * 删除用户信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjUserByIds(String ids) {
        return shzjUserMapper.deleteShzjUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息信息
     *
     * @param userId 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjUserById(Integer userId) {
        return shzjUserMapper.deleteShzjUserById(userId);
    }

    @Override
    public Integer updateShzjUserAnswer(int userId) {
        return shzjUserMapper.updateShzjUserAnswer(userId);
    }

    @Override
    public List<PhbDTO> selectShzjUserAnswerPhb() {
        return shzjUserMapper.selectShzjUserAnswerPhb();
    }

    @Override
    public Integer updateShzjUserQuiz(int userId) {
        return shzjUserMapper.updateShzjUserQuiz(userId);
    }

    @Override
    public int updateShzjUserReward(int userId, int reward) {
        return shzjUserMapper.updateShzjUserReward(userId,reward);
    }

    @Override
    public int updateShzjSubtract(int userId, int jif) {
        return shzjUserMapper.updateShzjSubtract(userId,jif);
    }

    @Override
    public HeadPortraitDTO selectShzjHeadPortrait(int userId) {
        return shzjUserMapper.selectShzjHeadPortrait(userId);
    }

    @Override
    public int selectShzjIntegral(int userId) {
        return shzjUserMapper.selectShzjIntegral(userId);
    }
}
