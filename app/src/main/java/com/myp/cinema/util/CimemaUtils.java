package com.myp.cinema.util;

import android.content.Context;
import android.content.res.Resources;

import java.lang.reflect.Method;

/**
 * Created by wuliang on 2017/6/30.
 * <p>
 * 德信app公用方法工具
 */

public class CimemaUtils {

    /**
     * 拼接座位
     */
    public static String getSeats(String seat) {
        StringBuffer buffer = new StringBuffer();
        String[] seatList = seat.split(",");
        for (int i = 0; i < seatList.length; i++) {
            if (seatList[i].split("_") != null && seatList[i].split("_").length >= 2) {
                buffer.append(seatList[i].split("_")[0] + "排" + seatList[i].split("_")[1] + "座  ");
            }
        }
        return buffer.toString();
    }


    /**
     * 返回评分结果
     */
    public static String getComment(float souce) {
        if (souce <= 2) {
            return souce + "分，极差";
        }
        if (souce <= 4) {
            return souce + "分，较差";
        }
        if (souce <= 6) {
            return souce + "分，一般";
        }
        if (souce <= 8) {
            return souce + "分，比较好";
        }
        return souce + "分，很好";
    }


    /**
     * 判断是否有虚拟控件
     */
    //获取是否存在NavigationBar
    public static boolean checkDeviceHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;
    }


}
