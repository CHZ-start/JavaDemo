package com.chz.spring.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FirstBean {

    private static final Logger log = LoggerFactory.getLogger(FirstBean.class);

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @PostConstruct
    public void init(){
        log.info("@PostConstruct");
    }
    @PreDestroy
    public void destroy(){
        log.info("@PreDestroy");
    }

    @Component
    public static class CommonComponent {

    }

    @Controller("tianDog")
    public static class SoldierController {
        @Autowired
        private SoldierService soldierService;

        public SoldierService getSoldierService() {
            return soldierService;
        }

    }

    @Repository
    public static class SoldierDao {

        private static final Logger log = LoggerFactory.getLogger(SoldierDao.class);

        public void getMessage(){
            log.info("I am a soldier");
        }
    }

    @Service("smallDog")
    public static class SoldierService {

        @Autowired
        private SoldierDao soldierDao;

        public SoldierDao getSoldierDao() {
            return soldierDao;
        }

    }

    public static class SpellChecker {
        public SpellChecker(){
            System.out.println("Inside SpellChecker constructor." );
        }
        public void checkSpelling(){
            System.out.println("Inside checkSpelling." );
        }

    }

    public static class TextEditor {
        private SpellChecker spellChecker;
        public TextEditor(SpellChecker spellChecker){
            System.out.println("Inside TextEditor constructor." );
            this.spellChecker = spellChecker;
        }
        public void spellCheck(){
            spellChecker.checkSpelling();
        }
    }
}
