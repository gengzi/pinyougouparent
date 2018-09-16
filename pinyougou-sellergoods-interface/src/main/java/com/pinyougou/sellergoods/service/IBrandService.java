package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.PageResult;
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


    /**
     * 查询分页数据
     * @param pageNum 当前页码
     * @param pageSize 当前页的大小
     * @return PageResult
     */
    PageResult  findPage(int pageNum,int pageSize);

}
