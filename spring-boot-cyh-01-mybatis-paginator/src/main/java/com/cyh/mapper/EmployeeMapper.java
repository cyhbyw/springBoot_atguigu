package com.cyh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.cyh.bean.Employee;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Mapper
@Component
public interface EmployeeMapper {

    /**
     * 根据性别查询员工
     * @param gender
     * @param pageBounds
     * @return
     */
    List<Employee> findByGender(Integer gender, PageBounds pageBounds);
}
