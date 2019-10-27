package com.enigma.services;

import com.enigma.entities.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StoreService {

    public Store save(Store store);
    public Store getStoreById(String storeId);
    public Page<Store> getAllStore(Pageable pageable, String keyword);
    public void deleteStoreById(String storeId);
    public Store savedWithFckingProduct(Store store);
    public List<Store> getAll();


}
