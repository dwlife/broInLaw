package com.zxy.bil.pojo;

import com.zxy.bil.util.DefaultArgument;
import org.codehaus.jackson.map.Serializers;

/**
 * <p>
 *
 * @author yuzu
 * @Description: UserPojo
 * </p>
 * @date 2018/9/29 13:18
 */

public class User extends BasePojo {
	private Integer userId = DefaultArgument.INT_DEFAULT;
	private String userName;
	private String userPwd;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}