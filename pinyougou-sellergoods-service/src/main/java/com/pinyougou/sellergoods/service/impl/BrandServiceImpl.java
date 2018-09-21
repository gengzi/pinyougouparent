package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 品牌管理-服务实现类
 * @author gengzi
 * @date 2018年9月13日09:38:19
 */
@Service
public class BrandServiceImpl implements IBrandService{

    @Autowired
    private TbBrandMapper mapper;

    @Override
    public List<TbBrand> findAll() {
        return mapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum,int pageSize) {
        //使用pagehelper 来实现分页查询
        PageHelper.startPage(pageNum,pageSize);
//        List<TbBrand> tbBrands = mapper.selectByExample(null);
//
//        int total = mapper.countByExample(null);
        Page<TbBrand> page = (Page<TbBrand>) mapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 添加一个品牌信息
     *
     * @param brand 品牌信息
     */
    @Override
    public void add(TbBrand brand) {
        mapper.insert(brand);
    }

    /**
     * 查询一个品牌的信息
     *
     * @param brandId  品牌的id
     * @return TbBrand
     */
    @Override
    public TbBrand findOne(long brandId) {

        return mapper.selectByPrimaryKey(brandId);
    }


    /**
     * 更新一个品牌的信息
     *
     * @param brand 品牌信息
     */
    @Override
    public void update(TbBrand brand) {
        mapper.updateByPrimaryKey(brand);
    }


}
