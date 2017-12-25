package com.anjoulee.demospringboot.service;

import com.anjoulee.demospringboot.domain.Girl;
import com.anjoulee.demospringboot.enums.ResultEnum;
import com.anjoulee.demospringboot.exception.GirlException;
import com.anjoulee.demospringboot.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void addTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(35);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(36);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回“你还在上小学吧”
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回“你可能在上初中”
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        } else {
            //返回“你可能再高中以上的学校”
        }
    }
}
