package com.jay.wms.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cargo {
    private Integer id;
    private String img;
    private String name;
    private String createBy;
    private Integer count;
    private Integer deptId;

}
