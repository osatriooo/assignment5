package com.enigma.services;

import com.enigma.entities.Product;
import com.enigma.entities.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    public Product save(Product product);
    public Product getProductById(String productId);
//    public List<Product> getAllProduct();
    public Page<Product> getAllProduct(Pageable pageable);
    public void deleteProductById(String productId);
    public void deductQuantity(String productId,Integer quantity);
    public Product saving(String productId,Product product);
    public BigDecimal getProductPriceById(String id);
}
