package com.czp.mystrongpoint.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class StrongpointLog extends BaseModel {

    @Column(name = "sp_id")
    private String spId;

    @Column(name = "consume_time")
    private Long consumeTime;

    @Column(name = "consume_amount")
    private Long consumeAmount;

    @Column(name = "users_count")
    private Integer usersCount;

    @Column(name = "user_ids")
    private String userIds;

}
