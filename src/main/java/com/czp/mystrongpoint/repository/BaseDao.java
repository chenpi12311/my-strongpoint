package com.czp.mystrongpoint.repository;

import com.czp.mystrongpoint.model.BaseModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.Map;

@NoRepositoryBean
public interface BaseDao<T extends BaseModel, ID extends Serializable> extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {

    Map<String, Object> findByPage(Map<String, Object> filter, Pageable pageable);

}
