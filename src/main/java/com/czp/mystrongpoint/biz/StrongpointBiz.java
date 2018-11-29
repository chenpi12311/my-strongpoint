package com.czp.mystrongpoint.biz;

import com.czp.mystrongpoint.repository.StrongpointDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrongpointBiz {

    @Autowired
    private StrongpointDao strongpointDao;

}
