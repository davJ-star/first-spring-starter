package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ResponseBodyApiController {

    @GetMapping("hello-api")
    @ResponseBody
    public Hello responseBodyApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }
    static class Hello {
        private String name = null;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


