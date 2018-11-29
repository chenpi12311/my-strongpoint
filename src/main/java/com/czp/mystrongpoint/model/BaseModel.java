package com.czp.mystrongpoint.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GenericGenerator(name="uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    protected String id;

    @Column(name = "deleted")
    protected int deleted;

    @Column(name = "ctime")
    protected Long ctime = System.currentTimeMillis();

    @Column(name = "mtime")
    protected Long mtime = System.currentTimeMillis();

    @Column(name = "version")
    protected Long version;

}
