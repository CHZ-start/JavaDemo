package com.chz.dao.impl;

import com.chz.dao.StudentDao;
import com.chz.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    RowMapper<Student> mapper = new BeanPropertyRowMapper<Student>(Student.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateNameById(Integer id,String name){
        String sql = "update Student set name = ? where id = ?";
        jdbcTemplate.update(sql,name,id);
    }

    public Student queryNameById(Integer id){
        String sql = "select * from student where id = ?";
        return jdbcTemplate.queryForObject(sql,mapper, id);
    }
}
