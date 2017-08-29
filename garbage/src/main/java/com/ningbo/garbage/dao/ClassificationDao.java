package com.ningbo.garbage.dao;

/**
 * Created by qiuch on 2017/8/9.
 */

import com.ningbo.garbage.po.ClassificationPo;
import com.ningbo.garbage.po.KeywordsPo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassificationDao extends PagingAndSortingRepository<ClassificationPo, Long>, JpaSpecificationExecutor<ClassificationPo> {
    @Query("select c from ClassificationPo c where pName = :pname")
    List<ClassificationPo> findByParentName(@Param("pname") String pname);
}