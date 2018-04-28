package com.smartpos.payhero.txb;


import com.smartpos.payhero.txb.bean.Order;
import com.smartpos.payhero.txb.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yy520 on 2018-4-9.
 */

public class Constant {

    public static Map<Integer,String> pType = new HashMap<>();
    public static final String[] pTypeArr = {"现金","刷卡","支付宝","全部"};
    static {
        pType.put(0,"");
        pType.put(1,"");
        pType.put(2,"");
        pType.put(3,"");
        pType.put(99,"");
    }

    private static User user;

    private static Order order;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Constant.user = user;
    }

    public static Order getOrder() {
        return order;
    }

    public static void setOrder(Order order) {
        Constant.order = order;
    }
}
