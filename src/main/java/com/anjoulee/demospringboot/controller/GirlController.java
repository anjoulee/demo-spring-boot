package com.anjoulee.demospringboot.controller;

import com.anjoulee.demospringboot.domain.Girl;
import com.anjoulee.demospringboot.repository.GirlRepository;
import com.anjoulee.demospringboot.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girls() {
        return girlRepository.findAll();
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlsByAge(@PathVariable("age") Integer age) {

        return girlRepository.findByAge(age);
    }

    /**
     * 添加
     *
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新
     *
     * @param cupSize
     * @param age
     * @param id
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlEdit(@PathVariable("id") Integer id,
                         @RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @PostMapping(value = "/girls/two")
    public void addTwo() {
        girlService.addTwo();
    }
}
