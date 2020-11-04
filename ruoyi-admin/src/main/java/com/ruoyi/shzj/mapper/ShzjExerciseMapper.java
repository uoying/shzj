package com.ruoyi.shzj.mapper;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.AnswerDTO;
import com.ruoyi.shzj.domain.DTO.ExerciseDTO;
import com.ruoyi.shzj.domain.DTO.UpDataExerciseDTo;
import com.ruoyi.shzj.domain.ShzjExercise;
import org.apache.ibatis.annotations.Param;

/**
 * 答题信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-21
 */
public interface ShzjExerciseMapper 
{
    /**
     * 查询答题信息
     * 
     * @param exeId 答题信息ID
     * @return 答题信息
     */
    public ShzjExercise selectShzjExerciseById(Integer exeId);

    /**
     * 查询答题信息列表
     * 
     * @param shzjExercise 答题信息
     * @return 答题信息集合
     */
    public List<ShzjExercise> selectShzjExerciseList(ShzjExercise shzjExercise);

    /**
     * 新增答题信息
     * 
     * @param shzjExercise 答题信息
     * @return 结果
     */
    public int insertShzjExercise(ShzjExercise shzjExercise);

    /**
     * 修改答题信息
     * 
     * @param shzjExercise 答题信息
     * @return 结果
     */
    public int updateShzjExercise(ShzjExercise shzjExercise);

    /**
     * 删除答题信息
     * 
     * @param exeId 答题信息ID
     * @return 结果
     */
    public int deleteShzjExerciseById(Integer exeId);

    /**
     * 批量删除答题信息
     * 
     * @param exeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjExerciseByIds(String[] exeIds);

    /**
     * @return 结果
     */
   public List<ExerciseDTO> selectShzjExercise(int judge);

    AnswerDTO selectShzjAnswerById(int parseInt);

    int updateShzjtiExercise(@Param("subject") String subject,
                             @Param("choiceA") String choiceA,
                             @Param("choiceB") String choiceB,
                             @Param("choiceC") String choiceC,
                             @Param("choiceD") String choiceD,
                             @Param("answer") String answer,
                             @Param("parse") String parse,
                             @Param("judge") int judge,
                             @Param("userId") int userId);
}
