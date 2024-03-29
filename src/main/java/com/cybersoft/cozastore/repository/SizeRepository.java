package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity, Integer>{
    @Query("select s from size s " +
            "join  s.products p where p.name = ?1 " +
            "group by s.id")
    List<SizeEntity> findAllByProductName(String name);
}
