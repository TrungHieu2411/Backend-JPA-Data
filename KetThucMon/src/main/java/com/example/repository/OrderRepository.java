package com.example.repository;

import com.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("SELECT o FROM Order o WHERE o.customer.customerId = :customerId")
	List<Order> findOrdersByCustomerId(@Param("customerId") Integer customerId);

	@Query("SELECT o FROM Order o WHERE o.employee.employeeId = :employeeId")
	List<Order> findOrdersByEmployeeId(@Param("employeeId") Integer employeeId);

	@Query("SELECT o FROM Order o WHERE o.customer.customerId = :customerId AND o.employee.employeeId = :employeeId")
	List<Order> findOrderByCustomerAndEmployee(@Param("customerId") Integer customerId,
			@Param("employeeId") Integer employeeId);

	Long countByPaymentMethod(String paymentMethod);
	
	Long countByOrderStatus(String orderStatus);
	
	@Query("SELECT o FROM Order o WHERE o.paymentMethod LIKE %:paymentMethod%")
	List<Order> findOrdersByPaymentMethod(@Param("paymentMethod") String paymentMethod);

	@Query("SELECT o FROM Order o WHERE o.orderStatus LIKE %:orderStatus%")
	List<Order> findOrdersByOrderStatus(@Param("orderStatus") String orderStatus);
	
	@Query("SELECT o FROM Order o WHERE o.paymentMethod LIKE %:paymentMethod% AND o.orderStatus LIKE %:orderStatus%")
    List<Order> findPaymentMethodAndOrderStatus(@Param("paymentMethod") String paymentMethod,
                                                                       @Param("orderStatus") String orderStatus);

}
