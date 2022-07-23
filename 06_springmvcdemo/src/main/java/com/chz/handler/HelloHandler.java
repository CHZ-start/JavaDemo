package com.chz.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class HelloHandler {

    @RequestMapping("/")
    public String showPortal(){
        return "portal";
    }

    @RequestMapping("/say/hello/to/spring/mvc")
    public String sayHello(){
        log.info("");
        return "target";
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String Post(){

        log.info("Post测试成功");
        return "portal";
    }
    @GetMapping("/GetMap")
    public String GetMap(){
        log.info("GetMap测试成功");
        return "portal";
    }
    @PostMapping("/value")
    public String ValuePost(@RequestParam String value){
        log.info("传入值：" + value);
        return "portal";
    }
}
