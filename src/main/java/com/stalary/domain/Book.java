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
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private String title;

    private String author;
}
