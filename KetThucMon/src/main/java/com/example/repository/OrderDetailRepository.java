package com.example.repository;

import com.example.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    
	@Query("SELECT o FROM OrderDetail o WHERE o.product.productId = :productId ")
	List<OrderDetail> findOrderDetailsByProductId(@Param("productId") Integer productId);

}
