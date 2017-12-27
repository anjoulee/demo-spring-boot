package com.anjoulee.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @DESC
 * @Author Anjoulee
 * @Date 2017/12/26
 */
@Controller
public class HotDeployController {
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(HttpServletRequest request) {
        //属性say对应在resources/templates/imooc.html中引用
        request.setAttribute("say", "Hello lilei Hello hanki Hello anjoulee");
        return "imooc";
    }
}
