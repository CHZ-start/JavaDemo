package com.chz.Service;

import com.chz.pojo.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService{

    public void updateNameById(Integer id,String name);

    public Student queryNameById(Integer id);
}
