package com.enigma.services;

import com.enigma.entities.Product;
import com.enigma.entities.Store;
import com.enigma.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getStoreById(String storeId) {
        return storeRepository.findById(storeId).get();
    }

    @Override
    public Page<Store> getAllStore(Pageable pageable, String keyword)
    {
        return storeRepository.findAllByAddressContainsOrStoreNameContainsOrDescriptionContainsOrPhoneNumberContains(keyword,keyword,keyword,keyword, pageable);

    }
    @Override
    public void deleteStoreById(String storeId) {
        storeRepository.deleteById(storeId);
    }

    @Override
    public Store savedWithFckingProduct(Store store) {
        for (Product products : store.getProducts()) {
                products.setStore(store);

        }
        return storeRepository.save(store);
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }
}
