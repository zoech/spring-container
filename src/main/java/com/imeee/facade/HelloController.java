package com.imeee.facade;

import com.imeee.model.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eee
 * Date: 2018-06-13
 * Time: 19:03
 */
@RestController
public class HelloController {
    @Autowired
    MyBean myBean;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!\n msg : " + myBean.getGreetWords();
    }
}
