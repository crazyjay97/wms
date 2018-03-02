package com.jay.wms.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Department {
    private Integer id;
    private Integer code;
    private String name;
    private String createBy;
    private String isAdmin;
}
