package com.zxy.bil.service.impl;

import com.zxy.bil.dao.ILoginDao;
import com.zxy.bil.pojo.Login;
import com.zxy.bil.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description
 * @date 2019/3/12 14:08
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    @Resource
    private ILoginDao loginDao;

    @Override
    public int insertLoginData(Login login) {
        return loginDao.insertLoginData(login);
    }
}
