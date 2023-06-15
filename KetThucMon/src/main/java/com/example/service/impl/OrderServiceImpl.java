package com.example.service.impl;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getOrderByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return orderRepository.findOrdersByCustomerId(customerId);
	}

	@Override
	public List<Order> getOrderByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return orderRepository.findOrdersByEmployeeId(employeeId);
	}

	@Override
	public List<Order> getOrderByCustomerAndEmployee(Integer customerId, Integer employeeId) {
		// TODO Auto-generated method stub
		return orderRepository.findOrderByCustomerAndEmployee(customerId, employeeId);
	}

	@Override
	public Order getOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).orElse(null);
	}

	@Override
	public Order findOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).orElse(null);
	}
	
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public List<Order> getAllOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepository.saveAndFlush(order);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepository.saveAndFlush(order);
	}

	@Override
	public void deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(orderId);
	}

	@Override
	public Long countOrderByPaymentMethod(String paymentMethod) {
		return orderRepository.countByPaymentMethod(paymentMethod);
	}
	
	@Override
	public Long countOrderByOrderStatus(String orderStatus) {
		// TODO Auto-generated method stub
		return orderRepository.countByOrderStatus(orderStatus);
	}

	@Override
	public Long countTotalOrders() {
		// TODO Auto-generated method stub
		return orderRepository.count();
	}

	@Override
	public List<Order> getPaymentMethodAndOrderStatus(String paymentMethod, String orderStatus) {
		// TODO Auto-generated method stub
		return orderRepository.findPaymentMethodAndOrderStatus(paymentMethod, orderStatus);
	}

	@Override
	public List<Order> getOrderByPaymentMethod(String paymentMethod) {
		// TODO Auto-generated method stub
		return orderRepository.findOrdersByPaymentMethod(paymentMethod);
	}

	@Override
	public List<Order> getOrderByOrderStatus(String orderStatus) {
		// TODO Auto-generated method stub
		return orderRepository.findOrdersByOrderStatus(orderStatus);
	}

}
