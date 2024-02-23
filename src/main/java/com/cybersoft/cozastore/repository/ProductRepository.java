package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <ProductEntity, Integer> {
    List<ProductEntity>findByCategoryId(int id);

    @Query("select p from product p " +
            "join p.orderDetails od " +
            "join od.order o " +
            "join o.user u where u.id = ?1")
    List<ProductEntity>findByUser(int id);
}