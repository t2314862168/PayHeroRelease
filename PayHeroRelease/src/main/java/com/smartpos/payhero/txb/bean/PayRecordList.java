package com.smartpos.payhero.txb.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yy520 on 2018-4-14.
 */

public class PayRecordList<T> implements Serializable {

    private int error_code;
    private String msg;
    private List<PayRecord> data;
    private Pager pager;

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public List<PayRecord> getData() {
        return data;
    }

    public void setData(List<PayRecord> data) {
        this.data = data;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
