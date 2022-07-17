package com.chz.spring;

import com.chz.spring.beans.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class SpringTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test01() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info("[druid数据库连接：]" + connection);
    }

    @Test
    public void test_update(){
        String sql = "update student set name = '赵云' where id = ?";
        int count = jdbcTemplate.update(sql, 5);
        log.info("影响条数：" + count);
    }

    @Test
    public void test_queryAll(){
        RowMapper<Student> rowMap = new BeanPropertyRowMapper<Student>(Student.class);
        String sql = "select * from student";
        List<Student> students = (List<Student>) jdbcTemplate.query(sql,rowMap);
        log.info("查询数据：" + students.toString());
    }
}
