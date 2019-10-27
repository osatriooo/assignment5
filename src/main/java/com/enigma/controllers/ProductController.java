package com.enigma.controllers;

import com.enigma.entities.Product;
import com.enigma.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
    @GetMapping("product/{productId}")
    public Product getProduct(@PathVariable String productId){
        return productService.getProductById(productId);
    }
    @GetMapping("/products")
    public Page<Product> getListOfProduct(@RequestParam Integer size, @RequestParam Integer page){
        Pageable pageable = PageRequest.of(page,size);
        return productService.getAllProduct(pageable);
    }
    @PostMapping("/product-save")
    public Product getProductStoreById(@RequestBody Product product){
        return productService.saving(product.getPasangStoreId(),product);
    }
    @DeleteMapping("products/{productId}")
    public void deleteProduct(@PathVariable String productId){
        productService.deleteProductById(productId);
    }
}
