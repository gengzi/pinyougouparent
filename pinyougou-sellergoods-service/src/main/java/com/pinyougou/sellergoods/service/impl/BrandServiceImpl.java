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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 查询分页数据
     *
     * @param brand    条件查询
     * @param pageNum  当前页码
     * @param pageSize 当前页的大小
     * @return PageResult  分页数据
     */
    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        TbBrandExample tbBrandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        // 判断品牌名称 是否为空
        if (brand !=null && brand.getName() !=null && brand.getName() != "" && brand.getName().length() > 0){
            criteria.andNameLike("%"+brand.getName()+"%");
        }
        // 判断品牌首字母 是否为空
        if(brand != null && brand.getFirstChar() != null && brand.getFirstChar() != "" && brand.getFirstChar().length() > 0){
            criteria.andFirstCharEqualTo(brand.getFirstChar());
        }
        Page<TbBrand> page  = (Page<TbBrand>) mapper.selectByExample(tbBrandExample);
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

    /**
     * 删除品牌信息
     *
     * @param ids 品牌信息id的数组集合
     */
    @Override
    public void deletes(@RequestParam Long[] ids) {
        for (long id: ids) {
            mapper.deleteByPrimaryKey(id);
        }
    }


}
