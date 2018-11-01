package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.manager.vo.Ids;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.IBrandService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import sun.java2d.loops.TransformBlit;

import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2018/9/13.
 * 品牌管理-controller层
 * @author gengzi
 * @Date 2018年9月13日12:01:14
 */
@RestController
@RequestMapping("/brand")
@Api(value = "BrandController 品牌管理",tags = {"品牌管理的接口"}) //用在类上，说明该类的作用
public class BrandController {


    //使用dubbox 的注解
    @Reference
    private IBrandService service;


    /**
     * 获取所有的品牌信息
     * @return List<TbBrand>
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation(value="查找品牌", notes="返回所有品牌信息",produces = "application/json")  //注解来给API增加方法说明。
    @ApiResponses(value = {@ApiResponse(code = 200,message = "[\n" +
            "  {\n" +
            "    \"firstChar\": \"品牌首字母\",\n" +
            "    \"id\": 品牌唯一标识,\n" +
            "    \"name\": \"品牌名称\"\n" +
            "  }]")})                        //返回结果的描述
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
    @ApiOperation(value = "分页查询品牌信息",notes = "返回条件查询得到品牌的分页数据",produces = "application/json")  //方法的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "brand",value = "品牌对象",paramType = "body",dataType = "TbBrand"),
            @ApiImplicitParam(name = "pageNum",value = "当前的页码",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "当前的分页大小",paramType = "query",dataType = "int"),

    })  // 请求参数的描述
    @ApiResponses(value={
            @ApiResponse(code = 200,message = "{\n" +
                    "  \"rows\": [\n" +
                    "    {\n" +
                    "      \"firstChar\": \"品牌的首字母\",\n" +
                    "      \"id\": 品牌的唯一标识,\n" +
                    "      \"name\": \"品牌的名称\"\n" +
                    "    }" +
                    "  ],\n" +
                    "  \"total\": 总条数\n" +
                    "}")

    })
    @RequestMapping(value = "/findPage",method= RequestMethod.POST)
    public PageResult findPage(@RequestBody TbBrand brand , @RequestParam int pageNum , @RequestParam int pageSize){
        return service.findPage(brand,pageNum,pageSize);
    }


    /**
     *  添加品牌信息
     * @param brand 品牌
     * @return  Result
     */
    @ApiOperation(value = "添加品牌信息",notes = "添加单个品牌信息",produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "brand",value = "品牌对象",paramType = "body",dataType = "TbBrand")
    })
    @ApiResponse(code = 200,message = "")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody TbBrand brand){
        try {
                service.add(brand);
           return new Result(true,"品牌信息添加成功");

        }catch (Exception e){
           return new Result(false,"品牌信息添加失败");
        }
    }


    /**
     * 查询一个品牌信息
     * @param id 品牌id
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public TbBrand findOne(@RequestParam long id){
            return service.findOne(id);
    }


    /**
     * 更新一个品牌信息
     * @param brand 品牌
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody TbBrand brand){
        try {
            service.update(brand);
            return new Result(true,"品牌信息更新成功");

        }catch (Exception e){
            return new Result(false,"品牌信息更新失败");
        }
    }

    /**
     * 删除品牌信息
     * @param  ids 品牌信息的ids 集合数组value = 23
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Result delete(@RequestParam Long ids[]){
        try {
            service.deletes(ids);
            return new Result(true,"品牌信息删除成功");

        }catch (Exception e){
            return new Result(false,"品牌信息删除失败");
        }
    }

    /**
     * 删除品牌信息 接受参数方式采用 request payload
     * @param  ids 品牌信息的ids 集合数组value = 23
     * @return
     */
    @RequestMapping(value = "/delete-reqpayload",method =RequestMethod.GET )
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

     //测试git 冲突

    /**
     * 获取下拉框的品牌信息
     * @return
     */
    @RequestMapping(value = "/selectOptionsList",method =RequestMethod.GET )
    public List<Map> selectOptionsList(){
        return service.selectOptionsList();
    }




}
