package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.manager.vo.Ids;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.loops.TransformBlit;

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

//    /**
//     *  查询分页的品牌信息
//     * @param pageNum  当前的页码
//     * @param pageSize  当前页的大小
//     * @return PageResult
//     */
//    @RequestMapping("/findPage")
//    public PageResult findPage(@RequestParam int pageNum , @RequestParam int pageSize){
//        return service.findPage(pageNum,pageSize);
//    }

    /**
     *  查询分页的品牌信息
     * @param pageNum  当前的页码
     * @param pageSize  当前页的大小
     * @return PageResult
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody TbBrand brand , @RequestParam int pageNum , @RequestParam int pageSize){
        return service.findPage(brand,pageNum,pageSize);
    }


    /**
     *  添加品牌信息
     * @param brand 品牌
     * @return  Result
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
                service.add(brand);
           return new Result("品牌信息添加成功",true);

        }catch (Exception e){
           return new Result("品牌信息添加失败",false);
        }
    }


    /**
     * 查询一个品牌信息
     * @param id 品牌id
     * @return
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(@RequestParam long id){
            return service.findOne(id);
    }


    /**
     * 更新一个品牌信息
     * @param brand 品牌
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            service.update(brand);
            return new Result("品牌信息更新成功",true);

        }catch (Exception e){
            return new Result("品牌信息更新失败",false);
        }
    }

    /**
     * 删除品牌信息
     * @param  ids 品牌信息的ids 集合数组value = 23
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(@RequestParam Long ids[]){
        try {
            service.deletes(ids);
            return new Result("品牌信息删除成功",true);

        }catch (Exception e){
            return new Result("品牌信息删除失败",false);
        }
    }

    /**
     * 删除品牌信息 接受参数方式采用 request payload
     * @param  ids 品牌信息的ids 集合数组value = 23
     * @return
     */
    @RequestMapping("/delete-reqpayload")
    public Result delete_reqplayload(@RequestBody Ids ids){
        System.out.printf("ids"+ids.toString());
//        try {
//            service.deletes(ids);
//            return new Result("品牌信息删除成功",true);
//
//        }catch (Exception e){
//            return new Result("品牌信息删除失败",false);
//        }
        return null;
    }





}
