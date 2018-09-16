package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装对象
 * @author gengzi
 * @date 2018年9月16日20:40:33
 */
public class PageResult implements Serializable{

    //总记录数
    private long total;

    //当前页的响应数据
    private List rows;

    public PageResult(long total,List rows){
         this.total = total;
         this.rows = rows;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }


    public long getTotal() {
        return total;
    }

    public List getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
