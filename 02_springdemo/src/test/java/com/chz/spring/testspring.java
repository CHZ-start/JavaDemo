package com.chz.spring;

import com.chz.spring.beans.HappyMachine;
import com.chz.spring.beans.HelloWorld;
import com.chz.spring.beans.HelloWorld2;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class testspring {

    private static final Logger log = (Logger) LoggerFactory.getLogger(testspring.class);

    /**
     * 使用AplicationContext接口获取bean
     */
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        System.out.println(helloWorld.getName());
    }

    /**
     * 使用ApplicationContext通过类加载bean
     */
    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        HelloWorld bean = applicationContext.getBean(HelloWorld.class);
        log.info("设置bean对象参数");
        bean.setName("springtest");
        String name = bean.getName();
        log.info("bean属性值：" + name);
    }

    /**
     * 使用ApplicationContext通过类加载bean，调用方法
     */
    @Test
    public void test03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        HelloWorld2 bean = applicationContext.getBean(HelloWorld2.class);
        bean.doWork();
    }
    /**
     *
     */
    @Test
    public void test04(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        HelloWorld2 helloWorld3 = (HelloWorld2) applicationContext.getBean("helloWorld3");
        HappyMachine happyMachine = helloWorld3.getHappyMachine();
        String machineName = happyMachine.getMachineName();
        log.info("bean属性值：" + machineName);
    }
    /**
     *
     */
    @Test
    public void test05() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        DataSource druidDatasource = (DataSource) applicationContext.getBean("druidDatasource");
        Connection connection = druidDatasource.getConnection();
        log.info("数据池连接：" + connection);
        connection.close();
    }

}
