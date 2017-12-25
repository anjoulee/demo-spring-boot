package com.anjoulee.demospringboot.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

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
    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;


}
