package com.hgt.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liqiang
 * @title: UserLoginLog
 * @projectName willlink-wid-user
 * @description: 用户登录日志
 * @date 2019/11/13 4:45 下午
 */
@Data
@ToString
@TableName("wm_user_login_log")
public class UserLoginLog implements Serializable {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Long id;
    /**
     * 用户UID
     */
    @TableField("user_id")
    private String userId;
    /**
     * 登录类型 sms_code、password
     */
    @TableField("type")
    private String type;
    /**
     * 国际区域编码
     */
    @TableField("country_code")
    private String countryCode;
    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * app下载渠道
     */
    @TableField("channel")
    private String channel;
    /**
     * 平台
     */
    @TableField("platform")
    private String platform;
    /**
     * 平台版本
     */
    @TableField("platform_version")
    private String platformVersion;
    /**
     * 客户端唯一标识
     */
    @TableField("device_id")
    private String deviceId;
    /**
     * clientIp
     */
    @TableField("client_ip")
    private String clientIp;
    /**
     * app版本号
     */
    @TableField("app_version")
    private String appVersion;
    /**
     * 地区
     */
    @TableField("area")
    private String area;
    /**
     * 登录时间
     */
    @TableField("login_time")
    private Date loginTime;

    /**
     * 访问渠道
     */
    @TableField("access_channel")
    private String accessChannel;

    /**
     * 专区选择 1-二轮车销售专区  2-物流车代运营专区
     */
    @TableField("login_time")
    private String userChoose;

    /**
     * 专区选择 1-二轮车销售专区  2-物流车代运营专区
     */
    @TableField("last_role")
    private String lastRole;
}
