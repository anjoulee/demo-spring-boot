package com.anjoulee.demospringboot.exception;

import com.anjoulee.demospringboot.enums.ResultEnum;
import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class GirlException extends RuntimeException {
    private Integer code;

//    public GirlException(Integer code, String message) {
//        super(message);
//        this.code = code;
//    }

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
