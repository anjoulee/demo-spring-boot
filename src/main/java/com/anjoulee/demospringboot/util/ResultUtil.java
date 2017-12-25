package com.anjoulee.demospringboot.util;


import com.anjoulee.demospringboot.domain.Result;

public class ResultUtil {

    /**
     * 成功
     *
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    /**
     * 失败
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}