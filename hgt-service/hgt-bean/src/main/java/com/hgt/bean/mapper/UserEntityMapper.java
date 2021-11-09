package com.hgt.bean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hgt.bean.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liqiang
 * @title: UserEntityMapper
 * @projectName willlink-wid-frontend-api
 * @description: 用户Mapper
 * @date 2019/11/11 5:54 下午
 */
public interface UserEntityMapper extends BaseMapper<UserEntity> {

    /**
     * 根据UID查询用户
     *
     * @param uid
     * @return
     */
    UserEntity findByUid(@Param("uid") String uid);

    /**
     * 根据手机号查询用户
     *
     * @param mobile
     * @return
     */
    UserEntity findByMobile(@Param("mobile") String mobile, @Param("countryCode") String countryCode);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    UserEntity findByUsername(@Param("username") String username);

    /**
     * 更新用户信息
     * @param userEntity
     * @return
     */
    int updateUser(UserEntity userEntity);

    /**
     * 更新用户支付宝账号
     * @param uid
     * @param alipayAccount
     * @param alipayAccountName
     * @return
     */
    int updateUserAlipayAccount(@Param("uid") String uid, @Param("alipayAccount") String alipayAccount, @Param("alipayAccountName") String alipayAccountName);

    //根据推荐码查询客户经理的用户信息
    UserEntity selectUserInfoByCode(String recomdCode);

    UserEntity selectByCustomerId(@Param("customerId") String customerId);

    /**
     * 根据客户经理手机号码，查询客户经理信息
     * @return
     */
    UserEntity selectRecomderByPhoneNumber(@Param("recomdPhoneNumber") String recomdPhoneNumber);

    /**
     * 根据客户经理手机号获取消费者列表
     * @param phoneNumber
     * @return
     */
    List<UserEntity> findUserByRecomd(@Param("phoneNumber") String phoneNumber);


}
