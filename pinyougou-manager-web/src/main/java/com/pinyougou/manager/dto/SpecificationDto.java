package com.pinyougou.manager.dto;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/28.
 * 规格管理的DTO
 * @author  耿子
 * @date 2018年9月28日08:40:55
 */
public class SpecificationDto implements Serializable{

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
