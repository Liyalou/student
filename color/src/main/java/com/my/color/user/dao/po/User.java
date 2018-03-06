package com.my.color.user.dao.po;

/**
 * 用户
 * @author lyl
 *
 */
public class User {
    /**用户ID*/
    private String userId;

    /**用户姓名*/
    private String userName;

    /**用户登录账号*/
    private String userAccount;

    /**登陆密码*/
    private String userPassword;

    /**性别*/
    private String userSex;

    /**身份证号*/
    private String userIdCard;

    /**联系电话*/
    private String userPhone;

    /**email*/
    private String userEmail;

    /**用户类型（1后台，2客户端）*/
    private String userType;

    /**微信openid*/
    private String userOpenId;

    /**app的token*/
    private String userAppToken;

    /**登录次数(默认为0)*/
    private Integer userLoginNumber;

    /**手机码（手机身份唯一标识，登录时，验证和上次登录是否同一手机，不同则发送验证码）*/
    private String userLoginPhoneCode;

    /**是否有效（0无效，1有效）*/
    private String userIsValid;

    /**创建时间*/
    private String userCreateTime;

    /**上次登录时间*/
    private String userLastLoginTime;

    /**最后修改时间*/
    private String userLastUpdatetime;

    
    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    public String getUserName() {
        return userName;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public String getUserAccount() {
        return userAccount;
    }

    
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    
    public String getUserPassword() {
        return userPassword;
    }

    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    
    public String getUserSex() {
        return userSex;
    }

    
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    
    public String getUserIdCard() {
        return userIdCard;
    }

    
    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    
    public String getUserPhone() {
        return userPhone;
    }

    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    
    public String getUserEmail() {
        return userEmail;
    }

    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    
    public String getUserType() {
        return userType;
    }

    
    public void setUserType(String userType) {
        this.userType = userType;
    }

    
    public String getUserOpenId() {
        return userOpenId;
    }

    
    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    
    public String getUserAppToken() {
        return userAppToken;
    }

    
    public void setUserAppToken(String userAppToken) {
        this.userAppToken = userAppToken;
    }

    
    public Integer getUserLoginNumber() {
        return userLoginNumber;
    }

    
    public void setUserLoginNumber(Integer userLoginNumber) {
        this.userLoginNumber = userLoginNumber;
    }

    
    public String getUserLoginPhoneCode() {
        return userLoginPhoneCode;
    }

    
    public void setUserLoginPhoneCode(String userLoginPhoneCode) {
        this.userLoginPhoneCode = userLoginPhoneCode;
    }

    
    public String getUserIsValid() {
        return userIsValid;
    }

    
    public void setUserIsValid(String userIsValid) {
        this.userIsValid = userIsValid;
    }

    
    public String getUserCreateTime() {
        return userCreateTime;
    }

    
    public void setUserCreateTime(String userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    
    public String getUserLastLoginTime() {
        return userLastLoginTime;
    }

    
    public void setUserLastLoginTime(String userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    
    public String getUserLastUpdatetime() {
        return userLastUpdatetime;
    }

    
    public void setUserLastUpdatetime(String userLastUpdatetime) {
        this.userLastUpdatetime = userLastUpdatetime;
    }
}