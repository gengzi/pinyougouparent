package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * Created by Administrator on 2018/9/13.
 * 品牌管理（Brand）-接口类
 * @author  gengzi
 * @date 2018年9月13日09:29:10
 *
 */
public interface IBrandService {

    /**
     * 查询品牌列表
     * @return  List<TbBrand>
     */
    List<TbBrand> findAll();

}
