package com.chz.Service.impl;

import com.chz.Service.StudentService;
import com.chz.dao.StudentDao;
import com.chz.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public void updateNameById(Integer id,String name){
        studentDao.updateNameById(id,name);
    }

    @Transactional(readOnly = true,timeout = 3)
    public Student queryNameById(Integer id) {
        return studentDao.queryNameById(id);
    }
}
