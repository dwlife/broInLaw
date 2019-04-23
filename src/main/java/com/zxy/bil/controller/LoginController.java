package com.zxy.bil.controller;

import com.zxy.bil.model.UserModel;
import com.zxy.bil.pojo.Login;
import com.zxy.bil.pojo.User;
import com.zxy.bil.service.ILoginService;
import com.zxy.bil.service.IUserService;
import com.zxy.bil.util.DefaultArgument;
import com.zxy.bil.util.EncodeUtil;
import com.zxy.bil.util.IpUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description 登录及页面跳转控制
 * @date 2018/12/18 19:09
 */
@Controller
public class LoginController {

    /**
     * 声明User服务
     */
    @Resource
    private IUserService userService;
   /**
     * 声明登录信息记录服务
     */
    @Resource
    private ILoginService loginService;

    /**
     * 日志输出标记
     */
    private static final String LOG = "UserController";

    /**
     * 声明日志对象
     */
    private static Logger logger = Logger.getLogger(LoginController.class);

    /**
     * 登录请求get
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login() {
        return "html/login";
    }

    /**
     * 登录请求post
     * @param userModel
     * @param vCode
     * @param session
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(UserModel userModel, String vCode, HttpSession session, HttpServletRequest request) throws Exception {
        System.out.println("go");
        Object object = session.getAttribute("_code");
        if (object == null) {
            return "/html/login";
        }
        String realVCode = object.toString();
        if (!realVCode.equals(vCode.toLowerCase())) {
            return "/html/login";
        }
        if (userModel != null && userModel.getUserName() != null && userModel.getUserPwd() != null) {
            userModel.setUserPwd(EncodeUtil.encode(userModel.getUserPwd()));
            User user = convertUser(userModel);
            try {
                String pwd = userService.getPassword(user.getUserName());
                if (user.getUserPwd().equals(pwd)) {
                    session.setAttribute(DefaultArgument.LOGIN_USER, userService.getUserId(user.getUserName()));
                    insertLoginData(session, request);
                    return "/html/updateQuestion";
                } else {
                    return "/html/login";
                }
            } catch (Exception e) {
                logger.error(LOG + "登录失败,失败信息：" + e.getMessage());
                return "/html/login";
            }
        }
        return "/html/login";
    }

    /**
     * 登出接口
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public String logout(HttpSession session) {
        session.removeAttribute(DefaultArgument.LOGIN_USER);
        return "../index";
    }

    /**
     * 转换
     *
     * @param userModel
     * @return
     */
    private User convertUser(UserModel userModel) {
        User user = new User();
        user.setUserName(userModel.getUserName());
        user.setUserPwd(userModel.getUserPwd());
        return user;
    }

    private void insertLoginData(HttpSession session, HttpServletRequest request) {
        Login login = new Login();
        login.setUserId((Integer) session.getAttribute(DefaultArgument.LOGIN_USER));
        //IP地址
        login.setRemoteAddr(request.getRemoteAddr());
        //真实IP地址
        login.setRealIp(IpUtil.getClientIp(request));
        loginService.insertLoginData(login);
    }
}
