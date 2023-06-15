package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.provider.providerId = :providerId")
    List<Product> findProductsByProviderId(@Param("providerId") Integer providerId);
    
    @Query("SELECT p FROM Product p WHERE p.producer.producerId = :producerId")
    List<Product> findProductsByProducerId(@Param("producerId") Integer producerId);
    
    @Query("SELECT p FROM Product p WHERE p.provider.providerId = :providerId AND p.producer.producerId = :producerId")
    List<Product> findProductsByProviderAndProducer(@Param("providerId") Integer providerId, @Param("producerId") Integer producerId);

}
