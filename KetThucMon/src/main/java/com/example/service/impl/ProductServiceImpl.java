package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductsByProvider(Integer providerId) {
        return productRepository.findProductsByProviderId(providerId);
    }

    @Override
    public List<Product> getProductsByProducer(Integer producerId) {
        return productRepository.findProductsByProducerId(producerId);
    }

    @Override
    public List<Product> getProductsByProviderAndProducer(Integer providerId, Integer producerId) {
        return productRepository.findProductsByProviderAndProducer(providerId, producerId);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product findProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProduct(Product product) {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Long countToTalProducts() {
        return productRepository.count();
    }

}
