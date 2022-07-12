package com.chz;

import com.chz.spring.beans.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final Logger log = Logger.getLogger(AppTest.class);

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test01(){
        FirstBean firstSpring = (FirstBean) applicationContext.getBean("firstSpring");
        log.info("bean对象name属性：" + firstSpring);
    }
    @Test
    public void test02(){
        FirstBean secondSpring = (FirstBean) applicationContext.getBean("secondSpring");
        Bean01 bean01 = secondSpring.getBean01();
        log.info("bean01对象name属性：" + bean01.getId());
    }
    @Test
    public void test03(){
        FirstBean thirdSpring = (FirstBean) applicationContext.getBean("thirdSpring");
        Bean01 bean01 = thirdSpring.getBean01();
        log.info("级联属性赋值 id：" + bean01.getId());
    }
    @Test
    public void test04(){
        HappyTeam happyTeam = (HappyTeam) applicationContext.getBean("happyTeam");
        log.info("构造器注入：" + happyTeam.toString());
    }
    @Test
    public void test05(){
        Bean01 pBean01 = (Bean01) applicationContext.getBean("pBean01");
        log.info(pBean01.getId());
    }
    @Test
    public void test06(){
        HappyTeam happyTeamList = (HappyTeam) applicationContext.getBean("happyTeamList");
        List<String> memberList = happyTeamList.getMemberList();
        log.info("集合类型：" + memberList);
    }
    @Test
    public void test07(){
        FirstBean autoWire = (FirstBean) applicationContext.getBean("autoWire");
        Bean01 bean01 = autoWire.getBean01();
        log.info("自动装配：" + bean01.getId());
    }
    @Test
    public void test08(){
        List<HappyMachine> machineList = (List<HappyMachine>) applicationContext.getBean("machineList");
        log.info("集合类型的bean" + machineList.toString());
    }
    @Test
    public void test09(){
        HappyMachine happyFactoryBean = (HappyMachine) applicationContext.getBean("happyFactoryBean");
        log.info(happyFactoryBean.getMachineName());
    }
    @Test
    public void test10(){
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");
        String happyname = happyComponent.getHappyname();
        log.info("执行：" + happyname);

    }
    @Test
    public void test11(){
        AbstractApplicationContext abstractApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyComponent happyComponent = (HappyComponent) abstractApplicationContext.getBean("happyComponent");
        happyComponent.getHappyname();
        abstractApplicationContext.registerShutdownHook();
    }
    @Test
    public void test12(){
        FirstBean autoWireByType = (FirstBean) applicationContext.getBean("autoWireByType");
        Bean01 bean01 = autoWireByType.getBean01();
        log.info("根据类型自动装配" + bean01.getId());
    }
    @Test
    public void test13(){
        TextEditor textEditor = (TextEditor) applicationContext.getBean("textEditor");
        textEditor.spellCheck();
    }
    @Test
    public void test14(){
        FirstBean autoCon = (FirstBean) applicationContext.getBean("autoCon");
        Bean01 bean01 = autoCon.getBean01();
        log.info("构造器装配" + bean01.getId());

    }
}
