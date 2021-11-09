package com.hgt.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liqiang
 * @title: User
 * @projectName willlink-wid-frontend-api
 * @description:
 * @date 2019/11/11 5:46 下午
 */
@Data
@TableName("wm_user_extension")
public class UserExtension implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String uid;

    /**
     * 认证类型
     * WID: WID_ACCOUNT
     * CAC: CAC_ACCOUNT
     * 小B: B_USER
     * 投资人: INVESTOR_USER
     * 支付宝: ALIPAY_ACCOUNT
     */
    @TableField("`type`")
    private String type;

    private String proveType;

    private String proveName;

    private String val;

    private String createdBy;

    private Date createdTime;

    private String updateBy;

    private Date updateTime;

    private Boolean deletedFlag;

    private Date deletedTime;
}