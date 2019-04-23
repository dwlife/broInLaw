package com.zxy.bil.dao;

import java.util.List;


import com.zxy.bil.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * @author yuzu
 * @Description: User数据库操作接口
 * </p>
 * @date 2018/10/11 8:25
 */
public interface IUserDao {

    /**
     * <p>
     *
     * @return
     * @Description: 查询User数据
     * </p>
     * @author yuzu
     * @date 2018/10/11 8:30
     */
    List<User> getUser();

    /**
     * 查询密码
     * @param userName
     * @return
     */
    String getPassword(@Param("userName") String userName);

    /**
     * 查询ID
     * @param userName
     * @return
     */
    int getUserId(@Param(value = "userName") String userName);

    /**
     * 新增用户信息(注册)
     * @param user
     * @return
     */
    int insert(@Param(value = "user") User user);
}