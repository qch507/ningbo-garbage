package com.ningbo.garbage.dao;

/**
 * Created by qiuch on 2017/8/9.
 */

import com.ningbo.garbage.po.GarbagePo;
import com.ningbo.garbage.po.KeywordsPo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarbageDao extends PagingAndSortingRepository<GarbagePo, Long>, JpaSpecificationExecutor<GarbagePo> {
    @Query("select g from GarbagePo g where gName = :name")
    GarbagePo findByName(@Param("name") String name);
//
//    @Query("from Tuser t where id = :id")
//    List<GarbagePo> queryFamilyList(@Param("id") Long id, Pageable pageable);

}