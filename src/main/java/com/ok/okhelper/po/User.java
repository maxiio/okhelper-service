package com.ok.okhelper.po;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 登录账号
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 登录密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 密保问题
     */
    @Column(name = "pass_problem")
    private String passProblem;

    /**
     * 密保答案
     */
    @Column(name = "pass_answer")
    private String passAnswer;

    /**
     * 昵称
     */
    @Column(name = "user_nick")
    private String userNick;

    /**
     * 头像
     */
    @Column(name = "user_avatar")
    private String userAvatar;

    /**
     * 邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 性别
     */
    @Column(name = "user_sex")
    private String userSex;

    /**
     * 生日
     */
    @Column(name = "user_birthday")
    private Date userBirthday;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新日期
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态 0废除，1激活
     */
    @Column(name = "delete_status")
    private String deleteStatus;

    /**
     * 操作者
     */
    private Long operator;

    public User(Long id, String userName, String userPassword, String passProblem, String passAnswer, String userNick, String userAvatar, String userEmail, String userSex, Date userBirthday, Date createTime, Date updateTime, String deleteStatus, Long operator) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.passProblem = passProblem;
        this.passAnswer = passAnswer;
        this.userNick = userNick;
        this.userAvatar = userAvatar;
        this.userEmail = userEmail;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteStatus = deleteStatus;
        this.operator = operator;
    }

    public User() {
        super();
    }

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取登录账号
     *
     * @return user_name - 登录账号
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置登录账号
     *
     * @param userName 登录账号
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取登录密码
     *
     * @return user_password - 登录密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置登录密码
     *
     * @param userPassword 登录密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 获取密保问题
     *
     * @return pass_problem - 密保问题
     */
    public String getPassProblem() {
        return passProblem;
    }

    /**
     * 设置密保问题
     *
     * @param passProblem 密保问题
     */
    public void setPassProblem(String passProblem) {
        this.passProblem = passProblem == null ? null : passProblem.trim();
    }

    /**
     * 获取密保答案
     *
     * @return pass_answer - 密保答案
     */
    public String getPassAnswer() {
        return passAnswer;
    }

    /**
     * 设置密保答案
     *
     * @param passAnswer 密保答案
     */
    public void setPassAnswer(String passAnswer) {
        this.passAnswer = passAnswer == null ? null : passAnswer.trim();
    }

    /**
     * 获取昵称
     *
     * @return user_nick - 昵称
     */
    public String getUserNick() {
        return userNick;
    }

    /**
     * 设置昵称
     *
     * @param userNick 昵称
     */
    public void setUserNick(String userNick) {
        this.userNick = userNick == null ? null : userNick.trim();
    }

    /**
     * 获取头像
     *
     * @return user_avatar - 头像
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * 设置头像
     *
     * @param userAvatar 头像
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    /**
     * 获取邮箱
     *
     * @return user_email - 邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置邮箱
     *
     * @param userEmail 邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * 获取性别
     *
     * @return user_sex - 性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置性别
     *
     * @param userSex 性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    /**
     * 获取生日
     *
     * @return user_birthday - 生日
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * 设置生日
     *
     * @param userBirthday 生日
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 获取创建日期
     *
     * @return create_time - 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建日期
     *
     * @param createTime 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新日期
     *
     * @return update_time - 更新日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新日期
     *
     * @param updateTime 更新日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取状态 0废除，1激活
     *
     * @return delete_status - 状态 0废除，1激活
     */
    public String getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置状态 0废除，1激活
     *
     * @param deleteStatus 状态 0废除，1激活
     */
    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus == null ? null : deleteStatus.trim();
    }

    /**
     * 获取操作者
     *
     * @return operator - 操作者
     */
    public Long getOperator() {
        return operator;
    }

    /**
     * 设置操作者
     *
     * @param operator 操作者
     */
    public void setOperator(Long operator) {
        this.operator = operator;
    }
}