package com.smartpos.payhero.txb.bean;

/**
 * Created by yy520 on 2018-4-28.
 */

public enum PayType{
    XJ(0,"现金"),
    SK(1,"刷卡"),
    ZFB(2,"支付宝"),
    WX(3,"微信"),
    ALL(99,"全部");

    private int id;
    private String name;

    PayType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static String[] getNames(){
        String [] arr = new String[PayType.values().length];
        for (int i=0; i<arr.length; i++){
            arr[i] = selectName(i);
        }
        return arr;
    }

    public static int selectId(int index){
        return PayType.values()[index].id;
    }

    public static String selectName(int index) {
        return PayType.values()[index].name;
    }
}
