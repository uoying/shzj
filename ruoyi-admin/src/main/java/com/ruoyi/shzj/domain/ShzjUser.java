package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 shzj_user
 * 
 * @author ruoyi
 * @date 2020-08-12
 */
public class ShzjUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户编号 */
    private Integer userId;

    /** 用户名/手机号 */
    @Excel(name = "用户名/手机号")
    private String loginId;

    /** 密码 */
    @Excel(name = "密码")
    private String loginPwd;

    /** 盐值 */
    @Excel(name = "盐值")
    private String salt;

    /** 关注 */
    @Excel(name = "关注")
    private String myConcern;

    /** 粉丝 */
    @Excel(name = "粉丝")
    private String myFans;

    /** 评论 */
    @Excel(name = "评论")
    private String myDiscuss;

    /** 获赞 */
    @Excel(name = "获赞")
    private String myAdmire;

    /** 答题数 */
    @Excel(name = "答题数")
    private Integer answerNumber;

    /** 出题数 */
    @Excel(name = "出题数")
    private Integer quizNumber;

    /** 昵称 */
    @Excel(name = "昵称")
    private String userName;

    /** 头像URL */
    @Excel(name = "头像URL")
    private String headPortrait;
    private String quizURL;
    private String answerURL;
    private Integer answerMax;
    private Integer quizMax;
    private boolean isSign;

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }

    /** 积分 */
    @Excel(name = "积分")
    private Long integral;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 个性签名 */
    @Excel(name = "个性签名")
    private String signature;

    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public String getQuizURL() {
        return quizURL;
    }

    public void setQuizURL(String quizURL) {
        this.quizURL = quizURL;
    }

    public String getAnswerURL() {
        return answerURL;
    }

    public void setAnswerURL(String answerURL) {
        this.answerURL = answerURL;
    }

    public Integer getAnswerMax() {
        return answerMax;
    }

    public void setAnswerMax(Integer answerMax) {
        this.answerMax = answerMax;
    }

    public Integer getQuizMax() {
        return quizMax;
    }

    public void setQuizMax(Integer quizMax) {
        this.quizMax = quizMax;
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setLoginId(String loginId) 
    {
        this.loginId = loginId;
    }

    public String getLoginId() 
    {
        return loginId;
    }
    public void setLoginPwd(String loginPwd) 
    {
        this.loginPwd = loginPwd;
    }

    public String getLoginPwd() 
    {
        return loginPwd;
    }
    public void setSalt(String salt) 
    {
        this.salt = salt;
    }

    public String getSalt() 
    {
        return salt;
    }
    public void setMyConcern(String myConcern) 
    {
        this.myConcern = myConcern;
    }

    public String getMyConcern() 
    {
        return myConcern;
    }
    public void setMyFans(String myFans) 
    {
        this.myFans = myFans;
    }

    public String getMyFans() 
    {
        return myFans;
    }
    public void setMyDiscuss(String myDiscuss) 
    {
        this.myDiscuss = myDiscuss;
    }

    public String getMyDiscuss() 
    {
        return myDiscuss;
    }
    public void setMyAdmire(String myAdmire) 
    {
        this.myAdmire = myAdmire;
    }

    public String getMyAdmire() 
    {
        return myAdmire;
    }
    public void setAnswerNumber(Integer answerNumber) 
    {
        this.answerNumber = answerNumber;
    }

    public Integer getAnswerNumber() 
    {
        return answerNumber;
    }
    public void setQuizNumber(Integer quizNumber) 
    {
        this.quizNumber = quizNumber;
    }

    public Integer getQuizNumber() 
    {
        return quizNumber;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setHeadPortrait(String headPortrait) 
    {
        this.headPortrait = headPortrait;
    }

    public String getHeadPortrait() 
    {
        return headPortrait;
    }
    public void setIntegral(Long integral) 
    {
        this.integral = integral;
    }

    public Long getIntegral() 
    {
        return integral;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setSignature(String signature) 
    {
        this.signature = signature;
    }

    public String getSignature() 
    {
        return signature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("loginId", getLoginId())
            .append("loginPwd", getLoginPwd())
            .append("salt", getSalt())
            .append("myConcern", getMyConcern())
            .append("myFans", getMyFans())
            .append("myDiscuss", getMyDiscuss())
            .append("myAdmire", getMyAdmire())
            .append("answerNumber", getAnswerNumber())
            .append("quizNumber", getQuizNumber())
            .append("userName", getUserName())
            .append("headPortrait", getHeadPortrait())
            .append("integral", getIntegral())
            .append("sex", getSex())
            .append("signature", getSignature())
            .toString();
    }
}
