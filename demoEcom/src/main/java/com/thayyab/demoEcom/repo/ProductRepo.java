package com.thayyab.demoEcom.repo;

import com.thayyab.demoEcom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{
}
