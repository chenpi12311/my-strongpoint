package com.czp.mystrongpoint.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Strongpoint extends BaseModel {

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private String province;

    @Column
    private String city;

    @Column
    private String district;

    @Column
    private String address;

    @Column
    private int count;

    @Column
    private double score;

}
