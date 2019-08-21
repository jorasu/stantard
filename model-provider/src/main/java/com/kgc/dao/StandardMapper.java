package com.kgc.dao;

import com.github.pagehelper.PageInfo;
import com.kgc.vo.Standard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by jora on 2019/6/18.
 */
@Repository
public interface StandardMapper {
    /*传参不是对象要注解@Param("title")*/
    List<Map<String,Object>> query(@Param("title") String title);

    Map<String,Object> queryById(Integer id);

    Map<String,Object> queryByNum(String stdnum);

    int add(Standard standard);

    int update(Standard standard);

    int del(Integer id);
}
