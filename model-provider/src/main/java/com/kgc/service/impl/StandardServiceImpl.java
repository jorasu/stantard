package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.dao.StandardMapper;
import com.kgc.service.StandardService;
import com.kgc.vo.Standard;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by jora on 2019/6/18.
 */
@Service
public class StandardServiceImpl implements StandardService{
    @Resource
    private StandardMapper mapper;
    @Override
    public PageInfo<Map<String, Object>> query(Integer pNo, Integer pSize, String title) {
        PageHelper.startPage(pNo,pSize);
        return new PageInfo<Map<String, Object>>(mapper.query(title));
    }

    @Override
    public Map<String, Object> queryById(Integer id) {
        return mapper.queryById(id);
    }

    @Override
    public String add(Standard standard) {
        String addRes="";
        if(mapper.queryByNum(standard.getStdnum())!=null){
            addRes="标准号重复";
        }else {

            if( mapper.add(standard)>0){
                addRes="添加成功";
            }else {
                addRes="添加失败";
            }
        };
        return addRes;
    }

    @Override
    public int update(Standard standard) {
        return mapper.update(standard);
    }

    @Override
    public int del(Integer id) {
        return mapper.del(id);
    }
}
