package com.czp.mystrongpoint.biz;

import com.czp.mystrongpoint.model.Rouge;
import com.czp.mystrongpoint.repository.RougeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RougeBiz {

    @Autowired
    private RougeDao rougeDao;

    public Rouge getRouge(String id) {
        return rougeDao.findById(id).get();
    }

}
