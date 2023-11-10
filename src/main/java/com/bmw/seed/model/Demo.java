package com.bmw.seed.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo {

    /****/

    private Long id;


    /****/

    private String text;


    /****/

    private Date createTime;


    /****/

    private Date updateTime;


    /****/

    private Integer isDeleted;


    /****/

    private Integer isEnabled;

    /**
     * dcode
     **/
    private String dcode;

}
