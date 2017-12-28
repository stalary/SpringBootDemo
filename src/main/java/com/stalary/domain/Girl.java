package com.stalary.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Stalary
 * @description
 * @date 2017/10/21
 */
@Entity
@Data
@NoArgsConstructor
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;

    @NotNull(message = "金额必填")
    private Double money;

}
