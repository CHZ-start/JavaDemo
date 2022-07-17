package com.chz.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeService {

    public void getEmpList() {
        log.info("无接口下的Spring AOP 动态代理");
    }

}