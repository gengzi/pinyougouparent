package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.TbBrand;
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
}
