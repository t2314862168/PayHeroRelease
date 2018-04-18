package com.smartpos.payhero.txb.bean;

/**
 * Created by tangxuebing on 2018/4/18.
 */

public class Pager {
    private int page;
    private int pageSize;
    private int totalNum;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
