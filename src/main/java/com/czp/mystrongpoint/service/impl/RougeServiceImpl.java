package com.czp.mystrongpoint.service.impl;

import com.czp.mystrongpoint.biz.RougeBiz;
import com.czp.mystrongpoint.model.Rouge;
import com.czp.mystrongpoint.service.RougeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RougeServiceImpl implements RougeService {

    @Autowired
    private RougeBiz rougeBiz;

    @Override
    public Rouge getRouge(String id) {
        return rougeBiz.getRouge(id);
    }
}
