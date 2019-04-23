package com.zxy.bil.service;

import java.util.List;

import com.zxy.bil.pojo.User;

/**
 * <p>
 *
 * @author yuzu
 * @Description: User操作服务类接口
 * </p>
 * @date 2018/9/29 16:08
 */

public interface IUserService {

    /**
     * <p>
     *
     * @return
     * @Description: 查询user数据
     * </p>
     * @author yuzu
     * @date 2018/9/29 13:10
     */
    List<User> getUsers();

    /**
     * 查询密码
     * @param userName
     * @return
     */
    String getPassword(String userName);

    /**
     * 查询ID
     * @param userName
     * @return
     */
    int getUserId(String userName);

    /**
     * 新增用户信息(注册)
     * @param user
     * @return
     */
    int insert(User user);
}