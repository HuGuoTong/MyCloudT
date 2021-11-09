package com.hgt.bean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liqiang
 * @title: User
 * @projectName willlink-wid-frontend-api
 * @description:
 * @date 2019/11/11 5:46 下午
 */
@Data
@ToString
@TableName("wm_user")
public class UserEntity implements Serializable {
    /**
     * 用户UID
     */
    @TableId
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 支付密码
     */
    private String payPassword;
    /**
     * 手机号码
     */
    private String phoneNumber;
    /**
     * 国际区域编码
     */
    private String countryCode;
    /**
     * 商家ID(商家用户不能为空)
     */
    private String customerId;
    /**
     * 用户头像
     */
    private String headPortrait;
    /**
     * EMAIL
     */
    private String email;
    /**
     * 性别1: 保密 2: 男 3: 女
     */
    private Integer gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 绑定的WID账户的手机号
     */
    private String widPhoneNumber;
    /**
     * 用户在CBEx 的wid地址
     */
    private String widWalletAddress;
    /**
     * 用户在CBEx 的cac地址
     */
    private String cacWalletAddress;
    /**
     * wid 数量
     */
    private BigDecimal widValue;
    /**
     * wac数量
     */
    private BigDecimal wacValue;
    /**
     * cac数量
     */
    private BigDecimal cacValue;
    /**
     * 支付宝账号
     */
    private String alipayAccount;
    /**
     * 支付宝账号真实姓名
     */
    private String alipayAccountName;
    /**
     * 微信  APP openID
     */
    private String appOpenid;
    /**
     * 小程序openId
     */
    private String miniProgramOpenId;
    /**
     * 云科微信开放平台
     */
    private String wechatUnionId;
    /**
     * 用户冻结状态 0：正常 1：冻结
     */
    private Integer locked;
    /**
     * 是否删除
     */
    private boolean deletedFlag;
    /**
     * 推荐人手机号
     */
    private String recomdPhoneNumber;
    /**
     * 用户推荐码
     */
    private String recommendCode;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
}