package com.czp.mystrongpoint.service;

import com.czp.mystrongpoint.model.Rouge;

public interface RougeService {

    /**
     * 根据ID获取用户
     * @param id
     * @return
     */
    Rouge getRouge(String id);

    /**
     * 根据邮箱获取用户
     * @param email
     * @return
     */
    Rouge getRougeByEmail(String email);

}
