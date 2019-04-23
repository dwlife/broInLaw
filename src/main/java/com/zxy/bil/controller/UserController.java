package com.zxy.bil.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.zxy.bil.model.ResultModel;
import com.zxy.bil.util.DefaultArgument;
import com.zxy.bil.util.EncodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxy.bil.model.UserModel;
import com.zxy.bil.pojo.User;
import com.zxy.bil.service.IUserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *
 * @author yuzu
 * @Description: User控制器
 * </p>
 * @date 2018/9/29 13:18
 */
@Controller
@RequestMapping("/UserController")
public class UserController {
    /**
     * 声明服务
     */
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/signUp", method = {RequestMethod.POST})
    public @ResponseBody
    ResultModel signUp(HttpSession session, UserModel userModel) throws Exception {
        if (session.getAttribute(DefaultArgument.LOGIN_USER) == null) {
            return null;
        }
        ResultModel resultModel = new ResultModel();
        if (userModel != null && userModel.getUserName() != null && userModel.getUserPwd() != null) {
            userModel.setUserPwd(EncodeUtil.encode(userModel.getUserPwd()));
            User user = convertUser(userModel);
            userService.insert(user);
        } else {
            resultModel.setResult(false);
            resultModel.setDetail("注册所需信息不全!");
        }
        return resultModel;
    }
    /**
     * <p>
     *
     * @param userModel
     * @return
     * @Description: 将UserModel转为User
     * </p>
     * @author yuzu
     * @date 2018/9/29 14:49
     */
    private User convertUser(UserModel userModel) {
        User user = new User();
        if (userModel != null) {
            user.setUserName(userModel.getUserName());
            user.setUserPwd(userModel.getUserPwd());
        }
        return user;
    }

}