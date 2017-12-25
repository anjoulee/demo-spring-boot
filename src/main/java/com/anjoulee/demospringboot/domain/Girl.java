package com.anjoulee.demospringboot.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Girl {
    //ID
    @Id
    @GeneratedValue
    private Integer id;

    //罩杯
    private String cupSize;

    //年龄
    private Integer age;


}
