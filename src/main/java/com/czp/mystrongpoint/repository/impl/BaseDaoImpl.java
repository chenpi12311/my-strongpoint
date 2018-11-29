package com.czp.mystrongpoint.repository.impl;

import com.czp.mystrongpoint.model.BaseModel;
import com.czp.mystrongpoint.repository.BaseDao;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

@Transactional
public class BaseDaoImpl<T extends BaseModel, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseDao<T, ID> {

    @SuppressWarnings("unused")
    private final EntityManager entityManager;

    public BaseDaoImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    public BaseDaoImpl(JpaEntityInformation<T, Serializable> information, EntityManager entityManager) {
        super(information, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public <S extends T> S save(S s) {
        s.setMtime(System.currentTimeMillis());
        return super.save(s);
    }

    @Override
    public void delete(T entity) {
        entity.setDeleted(1);
        save(entity);
    }

    @Override
    public void deleteById(Serializable id) {
        Optional<T> entityOp = super.findById((ID) id);
        if (entityOp.isPresent()) {
            T entity = entityOp.get();
            delete(entity);
        }
    }

    @Override
    public Map<String, Object> findByPage(Map<String, Object> filter, Pageable pageable) {
        return null;
    }
}
