package com.example.service;

import com.example.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
	// search and show
	public List<OrderDetail> getAllOrderDetail(OrderDetail orderDetail);

    OrderDetail getOrderDetailById(Integer orderDetailId);
    
    // Tìm kiếm và hiển thị
    List<OrderDetail> getOrderByProductId(Integer productId);

	public List<OrderDetail> getAllOrderDetails();
	
	//CRUD
	public void addOrderDetail(OrderDetail orderDetail);
	
}
