package com.example.service;

import com.example.model.Order;

import java.util.List;

public interface OrderService {
	// Tìm kiếm và hiển thị
	List<Order> getOrderByCustomerId(Integer customerId);

	List<Order> getOrderByEmployeeId(Integer employeeId);

	List<Order> getOrderByCustomerAndEmployee(Integer customerId, Integer employeeId);

	// Tìm kiếm và hiển thị
	List<Order> getOrderByPaymentMethod(String paymentMethod);

	List<Order> getOrderByOrderStatus(String orderStatus);

	List<Order> getPaymentMethodAndOrderStatus(String paymentMethod, String orderStatus);

	// Tìm kiếm theo ID
	Order getOrderById(Integer orderId);

	Order findOrderById(Integer orderId);

	// search and show
	List<Order> getAllOrders();

	List<Order> getAllOrder(Order order);

	// Thêm, cập nhật và xóa
	void addOrder(Order order);

	void updateOrder(Order order);

	void deleteOrder(Integer order);

	// thong ke
	public Long countOrderByPaymentMethod(String paymentMethod);
	
	public Long countOrderByOrderStatus(String orderStatus);
	
	public Long countTotalOrders();

}
