package com.pinyougou.pojo.vo;

import com.pinyougou.pojo.TbItemCat;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/26.
 * 商品分类管理的Vo
 */
public class ItemCatEditVo  extends TbItemCat implements Serializable{

    // 上一级的分类名称
    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
