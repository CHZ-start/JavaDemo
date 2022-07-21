package com.chz;

import com.chz.Service.StudentService;
import com.chz.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTest02 {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private StudentService studentService;

    @Test
    public void test01() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info("连接结果：" + connection);
    }
    @Test
    public void test02(){
        Student student = studentService.queryNameById(2);
        log.info("查询结果" + student);
    }
}
