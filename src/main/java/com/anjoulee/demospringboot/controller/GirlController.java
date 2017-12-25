package com.anjoulee.demospringboot.controller;

import com.anjoulee.demospringboot.domain.Girl;
import com.anjoulee.demospringboot.domain.Result;
import com.anjoulee.demospringboot.repository.GirlRepository;
import com.anjoulee.demospringboot.service.GirlService;
import com.anjoulee.demospringboot.util.LoggerUtil;
import com.anjoulee.demospringboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        LoggerUtil.info(this.getClass(), "girls Before");
        return girlRepository.findAll();

    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlsByAge(@PathVariable("age") Integer age) {

        return girlRepository.findByAge(age);
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
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

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
