package com.cyh;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cyh.bean.Employee;
import com.cyh.mapper.EmployeeMapper;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmployeeApplication.class})
public class EmployeeTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testMybatisPaginator() throws IOException {
        int pageNum = 1;
        int pageSize = 3;
        Order order1 = new Order("last_name", Order.Direction.ASC, null);
        Order order2 = new Order("id", Order.Direction.ASC, null);
        PageBounds pageBounds = new PageBounds(pageNum, pageSize, order1, order2);

        List<Employee> resultList = employeeMapper.findByGender(1, pageBounds);
        System.out.println(resultList.getClass().getName() + " ,, " + resultList.size());
        Assert.assertTrue(resultList instanceof PageList);
        PageList<Employee> pageList = (PageList<Employee>) resultList;
        System.out.println(pageList.getPaginator());
    }

}
