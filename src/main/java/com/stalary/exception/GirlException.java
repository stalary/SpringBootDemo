package com.stalary.exception;

import com.stalary.enums.ResultEnum;

/**
 * @author Stalary
 * @description
 * @date 2017/10/25
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
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
