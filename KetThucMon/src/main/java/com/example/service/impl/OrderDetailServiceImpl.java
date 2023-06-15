package com.example.service.impl;

import com.example.model.OrderDetail;
import com.example.repository.OrderDetailRepository;
import com.example.service.OrderDetailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	public List<OrderDetail> getAllOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return orderDetailRepository.findAll();
	}

	@Override
	public OrderDetail getOrderDetailById(Integer orderDetailId) {
		// TODO Auto-generated method stub
		return orderDetailRepository.findById(orderDetailId).orElse(null);
	}

	@Override
	public List<OrderDetail> getOrderByProductId(Integer productId) {
		// TODO Auto-generated method stub
		return orderDetailRepository.findOrderDetailsByProductId(productId);
	}
	
	@Override
	public List<OrderDetail> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return orderDetailRepository.findAll();
	}

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		orderDetailRepository.saveAndFlush(orderDetail);
	}

}
