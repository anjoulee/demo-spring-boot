package com.anjoulee.demospringboot.controller;

import com.anjoulee.demospringboot.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @RestController 等同于
 * @Controller和@ResponseBody
 * @PathVariable:获取url中的数据
 * @RequestParam:获取请求参数的值
 * @GetMapping:组合注解
 */
@RequestMapping("/hello")
@RestController
public class HellController {
//    //罩杯
//    @Value("${cupSize}")
//    private String cupSize;
//    //年龄
//    @Value("${age}")
//    private int age;
//
//    //内容
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String say() {
//        return cupSize + age + "====" + content;
//    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String say2() {
//        return girlBean.getCupSize();
//    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String index() {
//        return "index";
//    }

    /**
     * value 如果用多个参数调用一个路径的话可以采用集合的方式实现 如：{"/hello","/hi"},
     *
     * @return /say/{id}或者/{id}或/say,
     */
    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
        return "id：" + id;
    }

    @RequestMapping(value = "/{id}/say2", method = RequestMethod.GET)
    public String say2(@PathVariable("id") Integer id) {
        return "id：" + id;
    }

    /**
     * /say3?id=xxx
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/say3", method = RequestMethod.GET)
    public String say3(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id：" + myId;
    }
}
