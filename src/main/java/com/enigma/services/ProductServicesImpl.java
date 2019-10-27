package com.enigma.services;

import com.enigma.entities.Product;
import com.enigma.entities.Store;
import com.enigma.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServicesImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreService storeService;


    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {

        Page<Product> products = productRepository.findAll(pageable);

        return products;
    }

    @Override
    public void deleteProductById(String productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void deductQuantity(String productId,Integer quantity) {
        productRepository.findById(productId).get().deduct(quantity);
    }

    @Override
    public Product saving(String productId, Product product) {
        Store store = storeService.getStoreById(productId);
        product.setStore(store);
        return productRepository.save(product);
    }

    @Override
    public BigDecimal getProductPriceById(String id) {
        return getProductById(id).getPrice();
    }

}
