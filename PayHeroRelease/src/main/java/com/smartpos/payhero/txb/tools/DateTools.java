package com.smartpos.payhero.txb.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具
 * Created by tangxuebing on 2018/4/19.
 */

public class DateTools {
    private static final SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    /**
     * 将时间转换位yyyy-MM-dd  HH:mm:ss
     *
     * @param time
     * @return
     */
    public static String formatHms_Str(long time) {
        return formatTime.format(new Date(time));
    }
}
