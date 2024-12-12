package com.thayyab.demoEcom.controller;

import com.thayyab.demoEcom.model.Product;
import com.thayyab.demoEcom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
public class productController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return  productService.getProductById(id);
    }

    @PostMapping("/create")
    public Product  createProduct(@RequestBody Product prod){
        return  productService.createProduct(prod);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product prod,@PathVariable Long id){
        Product tempProd= productService.getProductById(id);
        if(tempProd!=null){
            tempProd=productService.updateProduct(prod,id);
            return new ResponseEntity<>(tempProd, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }





}
