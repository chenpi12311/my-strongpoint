package com.czp.mystrongpoint.biz;

import com.czp.mystrongpoint.repository.StrongpointLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrongpointLogBiz {

    @Autowired
    private StrongpointLogDao strongpointLogDao;

}
