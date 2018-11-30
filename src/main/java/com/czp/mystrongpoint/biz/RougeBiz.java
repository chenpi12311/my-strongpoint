package com.czp.mystrongpoint.biz;

import com.czp.mystrongpoint.model.Rouge;
import com.czp.mystrongpoint.repository.RougeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class RougeBiz {

    @Autowired
    private RougeDao rougeDao;

    public Rouge getRouge(String id) {
        return rougeDao.findById(id).get();
    }

    public Rouge getRouge(String field, Object value, Class<?> classType) {
        return (Rouge) rougeDao.findOne(new Specification<Rouge>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Rouge> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(field).as(classType), value);
            }
        }).get();
    }

}
