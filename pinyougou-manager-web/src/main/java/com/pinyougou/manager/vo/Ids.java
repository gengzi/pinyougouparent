package com.pinyougou.manager.vo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/9/25.
 */
public class Ids implements Serializable{
    private Long ids[];

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "Ids{" +
                "ids=" + Arrays.toString(ids) +
                '}';
    }
}
