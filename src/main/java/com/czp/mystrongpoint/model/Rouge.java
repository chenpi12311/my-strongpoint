package com.czp.mystrongpoint.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rouge extends BaseModel {

    public static final String NAME = "name";
    public static final String GENDER = "gender";
    public static final String CELLPHONE = "cellphone";
    public static final String EMAIL = "email";
    public static final String PROVINCE = "province";
    public static final String CITY = "city";
    public static final String DISTRICT = "district";
    public static final String ADDRESS = "address";
    public static final String SINGLE = "single";

    @Column
    private String name;

    @Column
    private int gender;

    @Column
    private String cellphone;

    @Column
    private String email;

    @Column
    private String province;

    @Column
    private String city;

    @Column
    private String district;

    @Column
    private String address;

    @Column
    private int single;

}
