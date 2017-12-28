package com.stalary.exception;

import com.stalary.enums.ResultEnum;

/**
 * @author Stalary
 * @description
 * @date 2017/10/25
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
