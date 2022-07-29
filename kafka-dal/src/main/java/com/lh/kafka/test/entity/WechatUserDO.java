package com.lh.kafka.test.entity;


/**
 * The table 用户微信表
 */
public class WechatUserDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * userId USER_ID.
     */
    private Long userId;
    /**
     * pic 头像.
     */
    private String pic;
    /**
     * name 用户登录名：手机号.
     */
    private String name;
    /**
     * openId openid.
     */
    private String openId;
    /**
     * unionId UNION_ID.
     */
    private String unionId;

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
     * Set userId USER_ID.
     */
    public void setUserId(Long userId){
        this.userId = userId;
    }

    /**
     * Get userId USER_ID.
     *
     * @return the string
     */
    public Long getUserId(){
        return userId;
    }

    /**
     * Set pic 头像.
     */
    public void setPic(String pic){
        this.pic = pic;
    }

    /**
     * Get pic 头像.
     *
     * @return the string
     */
    public String getPic(){
        return pic;
    }

    /**
     * Set name 用户登录名：手机号.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name 用户登录名：手机号.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Set openId openid.
     */
    public void setOpenId(String openId){
        this.openId = openId;
    }

    /**
     * Get openId openid.
     *
     * @return the string
     */
    public String getOpenId(){
        return openId;
    }

    /**
     * Set unionId UNION_ID.
     */
    public void setUnionId(String unionId){
        this.unionId = unionId;
    }

    /**
     * Get unionId UNION_ID.
     *
     * @return the string
     */
    public String getUnionId(){
        return unionId;
    }
}
