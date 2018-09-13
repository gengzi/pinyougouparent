package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;
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
}
