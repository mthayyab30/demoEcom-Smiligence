package com.thayyab.demoEcom.service;

import com.thayyab.demoEcom.model.Product;
import com.thayyab.demoEcom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product createProduct(Product prod) {
        return productRepo.save(prod);
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(new Product());
    }

    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

    public Product updateProduct(Product prod, Long id) {
        prod.setProduct_id(id);
        return productRepo.save(prod);
    }
}
