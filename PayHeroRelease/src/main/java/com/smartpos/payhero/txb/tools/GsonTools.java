package com.smartpos.payhero.txb.tools;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * gson转换工具
 * Created by tangxuebing on 2018/4/19.
 */

public class GsonTools {
    private static Gson gson = new Gson();

    public static <T> T fromJson(String jsonStr, Class<T> cls) {
        try {
            return gson.fromJson(jsonStr, cls);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
