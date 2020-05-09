package com.winby.demo.core.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="demo")
public class Demo {

    /**     ID      */
    @Id
    private Long id;
    /**     手机      */
    private Integer tel;
    /**     名字      */
    private String name;
}