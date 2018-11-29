package com.czp.mystrongpoint.repository;

import com.czp.mystrongpoint.model.Rouge;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRougeDao {

    @Autowired
    private RougeDao rougeDao;

    @Test
    public void getUser() {
        Rouge rouge = new Rouge();
        rouge.setName("陈皮测试");
        rouge.setGender(1);
        rouge.setCellphone("18962660982");
        rouge.setEmail("a172497698@qq.com");
        rouge.setProvince("江苏");
        rouge.setCity("昆山");
        rouge.setDistrict("玉山镇");
        rouge.setAddress("中华园北村25#406");
        rouge.setVersion(1L);

        Rouge newRouge = rougeDao.save(rouge);
        System.out.println(rougeDao.findById(newRouge.getId()));
    }

    @Test
    public void updateUser() {
        Rouge rouge = rougeDao.findById("ec92421a-83ed-4e94-aafe-c13392fdacf9").get();
        rouge.setSingle(1);
        rougeDao.save(rouge);
    }

    @Test
    public void findUsers() {
        Iterator<Rouge> rouges = rougeDao.findAll(PageRequest.of(0, 2, Sort.Direction.DESC, "ctime")).iterator();
        while(rouges.hasNext()) {
            Rouge rouge = rouges.next();
            System.out.println(rouge.getCtime());
        }
    }

}
