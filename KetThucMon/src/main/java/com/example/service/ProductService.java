package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    // Tìm kiếm và hiển thị
    List<Product> getProductsByProvider(Integer providerId);
    
    // Tìm kiếm và hiển thị
    List<Product> getProductsByProducer(Integer producerId);
    
	List<Product> getProductsByProviderAndProducer(Integer providerId, Integer producerId);
	
    Product getProductById(Integer productId);
    
    // Tìm kiếm theo ID
    Product findProductById(Integer productId);
    
    List<Product> getAllProducts();
    
	 //search and show
    List<Product> getAllProduct(Product product);

    // Thêm, cập nhật và xóa
    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer productId);
    
	public Long countToTalProducts();
}
