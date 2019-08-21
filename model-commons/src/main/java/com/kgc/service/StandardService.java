package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.vo.Standard;

import java.util.Map;

/**
 * Created by jora on 2019/6/18.
 */
public interface StandardService {
    /**
     * A．分页查询所有标准信息，并按标准号升序 B．根据条件分页查询标准信息，并按标准号升序 C．根据标准信息 id 查询标准信息
     D．根据标准号查询标准信息
     E．添加标准信息
     F．修改标准信息
     G．删除标准信息
     */

    PageInfo<Map<String,Object>> query(Integer pNo,Integer pSize,String title);

    Map<String,Object> queryById(Integer id);

    String add(Standard standard);

    int update(Standard standard);

    int del(Integer id);

}
