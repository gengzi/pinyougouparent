package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/9/13.
 * 品牌管理-controller层
 * @author gengzi
 * @Date 2018年9月13日12:01:14
 */
@RestController
@RequestMapping("/brand")
public class BrandController {


    //使用dubbox 的注解
    @Reference
    private IBrandService service;


    /**
     * 获取所有的品牌信息
     * @return List<TbBrand>
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
       return service.findAll();
    }
}
