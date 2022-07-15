package com.chz;


import com.chz.spring.beans.FirstBean;
import com.chz.spring.config.FirstConfig;
import com.chz.spring.config.TextEditorConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    private static final Logger log = LoggerFactory.getLogger(SpringTest.class);

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01(){
        log.info("测试logback日志已经生效！！");
    }
    @Test
    public void test02(){
        FirstBean.SoldierController tianDog = (FirstBean.SoldierController) applicationContext.getBean("tianDog");
        FirstBean.SoldierService soldierService = tianDog.getSoldierService();
        FirstBean.SoldierDao soldierDao = soldierService.getSoldierDao();
        soldierDao.getMessage();
    }
    @Test
    public void test03(){
        AbstractApplicationContext abstractApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        FirstBean firstBean = (FirstBean) abstractApplicationContext.getBean("firstBean");
        log.info(firstBean.getMessage());
        abstractApplicationContext.registerShutdownHook();
    }
    @Test
    public void test04(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FirstConfig.class);
        FirstBean bean = applicationContext.getBean(FirstBean.class);
        bean.setMessage("完全注解开发");
        log.info("log-output：" + bean.getMessage());
    }
    @Test
    public void test05(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TextEditorConfig.class);
        FirstBean.TextEditor bean = applicationContext.getBean(FirstBean.TextEditor.class);
        bean.spellCheck();
    }
}
