package com.anjoulee.demospringboot.service;

import com.anjoulee.demospringboot.domain.Girl;
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
}
