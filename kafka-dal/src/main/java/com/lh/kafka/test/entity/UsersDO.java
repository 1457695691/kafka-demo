package com.lh.kafka.test.entity;


/**
 * The table 用户表
 */
public class UsersDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * phone 手机号.
     */
    private String phone;
    /**
     * userPwd 密码.
     */
    private String userPwd;
    /**
     * realName 名呢.
     */
    private String realName;
    /**
     * userName 用户名.
     */
    private String userName;
    /**
     * gender 性别 0女 1男.
     */
    private Integer gender;
    /**
     * status 0正常 1无效.
     */
    private Integer status;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set phone 手机号.
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * Get phone 手机号.
     *
     * @return the string
     */
    public String getPhone(){
        return phone;
    }

    /**
     * Set userPwd 密码.
     */
    public void setUserPwd(String userPwd){
        this.userPwd = userPwd;
    }

    /**
     * Get userPwd 密码.
     *
     * @return the string
     */
    public String getUserPwd(){
        return userPwd;
    }

    /**
     * Set realName 名呢.
     */
    public void setRealName(String realName){
        this.realName = realName;
    }

    /**
     * Get realName 名呢.
     *
     * @return the string
     */
    public String getRealName(){
        return realName;
    }

    /**
     * Set userName 用户名.
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * Get userName 用户名.
     *
     * @return the string
     */
    public String getUserName(){
        return userName;
    }

    /**
     * Set gender 性别 0女 1男.
     */
    public void setGender(Integer gender){
        this.gender = gender;
    }

    /**
     * Get gender 性别 0女 1男.
     *
     * @return the string
     */
    public Integer getGender(){
        return gender;
    }

    /**
     * Set status 0正常 1无效.
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * Get status 0正常 1无效.
     *
     * @return the string
     */
    public Integer getStatus(){
        return status;
    }
}
