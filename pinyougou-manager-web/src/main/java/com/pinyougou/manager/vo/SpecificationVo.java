package com.pinyougou.manager.vo;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/29.
 * 规格管理的响应实体
 * @author gengzi
 * @date 2018年9月29日08:44:44
 */
public class SpecificationVo implements Serializable{


    private TbSpecification tbSpecification;

    private List<TbSpecificationOption> specificationOptionList = new ArrayList<>();

    public TbSpecification getTbSpecification() {
        return tbSpecification;
    }

    public void setTbSpecification(TbSpecification tbSpecification) {
        this.tbSpecification = tbSpecification;
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }

    @Override
    public String toString() {
        return "SpecificationDto{" +
                "tbSpecification=" + tbSpecification +
                ", specificationOptionList=" + specificationOptionList +
                '}';
    }



}
