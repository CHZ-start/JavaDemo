package com.chz;

import com.chz.spring.beans.HelloWorld;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Unit test for simple App.
 */
/**
 * 1、创建spring：maven-Create from... - 选择archetype-quickstart,一路next
 * 2、创建beans文件夹，创建bean
 * 3、配置ApplicationContext.xml文件，将bean交给spring管理
 * 4、创建test，测试spring管理bean
 * 5、new一个ClassPathXmlApplicationContext读取配置文件,有多种方法
 * 6、将读取的对象转换为bean类型，调用bean方法
 *
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        System.out.println(helloWorld.getName());
    }
    @Test
    public void factoryBeanTest(){
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("ApplicationContext.xml"));
        HelloWorld helloWorld = (HelloWorld) xmlBeanFactory.getBean("helloWorld");
        System.out.println(helloWorld.getName());
    }
    @Test
    public void fileSytemTest(){
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("E:\\Java学习\\JavaDemo\\01_springDemp\\src\\main\\java\\resource\\ApplicationContext.xml");
        HelloWorld helloWorld = (HelloWorld) fileSystemXmlApplicationContext.getBean("helloWorld");
        System.out.println(helloWorld.getName());
    }

}
