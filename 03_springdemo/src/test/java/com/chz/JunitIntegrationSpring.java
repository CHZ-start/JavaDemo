package com.chz;

import com.chz.spring.EmployeeService;
import com.chz.spring.IWork;
import com.chz.spring.Task;
import com.chz.spring.config.TextEditorConfig;
import com.chz.spring.impl.TaskImpl;
import com.chz.spring.proxy.TaskProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
//@ContextConfiguration(classes = TextEditorConfig.class)
public class JunitIntegrationSpring {

    private static final Logger log = LoggerFactory.getLogger(JunitIntegrationSpring.class);

//    @Autowired
//    private SoldierController soldierController;
//
//    @Test
//    public void testFirst(){
//        log.info("junit4测试类"+ soldierController);
//    }
    @Autowired
    private TextEditorConfig textEditorConfig;

    @Autowired
    private Task task;

    @Autowired
    private IWork work;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testSecond(){
        log.info("junit4测试类" + textEditorConfig);
    }
    @Test
    public void test01(){
        Task task = new TaskImpl();
        Task taskproxy = (Task) Proxy.newProxyInstance(task.getClass().getClassLoader(), task.getClass().getInterfaces(), new TaskProxy(task));
        taskproxy.doSomething("任务进行中");
    }
    @Test
    public void test02(){
        work.print();
    }
    @Test
    public void test03(){
        task.doSomething("as home");
    }
    @Test
    public void test04(){
        log.info("makeSomething执行：" + task.makeSomething("我是返回值"));
    }

    @Test
    public void test05(){
        employeeService.getEmpList();
    }
}
