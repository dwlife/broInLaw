package com.zxy.bil.pojo;

import com.zxy.bil.util.DateUtil;

import java.sql.Timestamp;

/**
 * <p>
 *
 * @author hiYuzu
 * @version V1.0
 * </p>
 * @description 基础实体类
 * @date 2018/12/3 14:38
 */
public class BasePojo {
    private Timestamp optTime = DateUtil.getSystemDateTime(DateUtil.DEFAULT_PATTERN);

    public Timestamp getOptTime() {
        return optTime;
    }

    public void setOptTime(Timestamp optTime) {
        this.optTime = optTime;
    }
}
