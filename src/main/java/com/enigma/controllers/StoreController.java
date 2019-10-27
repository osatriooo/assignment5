package com.enigma.controllers;

import com.enigma.entities.Store;
import com.enigma.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    StoreService storeService;



    @PostMapping("/store")
    public Store saveStore(@RequestBody Store store){
        return storeService.save(store);
    }

    @GetMapping("/store/{storeId}")
    public Store getStoreById(@PathVariable String storeId){
        return storeService.getStoreById(storeId);
    }

    @CrossOrigin
    @GetMapping("/list")
    public List<Store> getAll(){
        return storeService.getAll();
    }

    @GetMapping("/stores")
    public Page<Store> getPaginationOfStore(@RequestParam Integer size, @RequestParam Integer page, @RequestParam String keyword){
        Pageable pageable = PageRequest.of(page,size);
        return storeService.getAllStore(pageable,keyword);
    }
    @PostMapping("/store-product")
    public Store saveStoreWithProduct(@RequestBody Store store){
        return storeService.savedWithFckingProduct(store);
    }


    @DeleteMapping("/stores/{storeId}")
    public void deleteStoreById(@PathVariable String storeId){

        storeService.deleteStoreById(storeId);
    }
}

