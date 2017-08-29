package com.ningbo.garbage.dao;

/**
 * Created by qiuch on 2017/8/9.
 */
import java.util.List;
import java.util.Map;

import com.ningbo.garbage.po.KeywordsPo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordsDao extends PagingAndSortingRepository<KeywordsPo, Long>, JpaSpecificationExecutor<KeywordsPo> {
    @Query("select count(id) from KeywordsPo where keywords = :keywords")
    int existKeywords(@Param("keywords") String keywords);
//
//    @Query("from Tuser t where id = :id")
//    List<KeywordsPo> queryFamilyList(@Param("id") Long id, Pageable pageable);

}