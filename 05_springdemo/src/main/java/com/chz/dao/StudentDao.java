package com.chz.dao;

import com.chz.pojo.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {

    public void updateNameById(Integer id,String name);

    public Student queryNameById(Integer id);
}
