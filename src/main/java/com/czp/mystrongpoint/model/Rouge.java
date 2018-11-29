package com.czp.mystrongpoint.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rouge extends BaseModel {

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
