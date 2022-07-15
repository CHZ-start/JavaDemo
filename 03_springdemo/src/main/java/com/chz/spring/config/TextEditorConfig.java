package com.chz.spring.config;

import com.chz.spring.beans.FirstBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.chz.spring")
public class TextEditorConfig {

    @Bean
    public FirstBean.TextEditor textEditor(){
        return new FirstBean.TextEditor(spellChecker());
    }

    @Bean
    public FirstBean.SpellChecker spellChecker(){
        return new FirstBean.SpellChecker();
    }
}
