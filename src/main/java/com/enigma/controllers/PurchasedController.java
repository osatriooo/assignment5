package com.enigma.controllers;

import com.enigma.entities.Purchased;
import com.enigma.services.PurchasedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchasedController {

    @Autowired
    PurchasedService purchasedService;

    @PostMapping("/purchase")
    public Purchased saveData(@RequestBody Purchased purchased){
        return purchasedService.save(purchased);
    }

    @GetMapping("/purchase/{purchaseId}")
    public Purchased getDataPurchased(@PathVariable String purchaseId){
        return purchasedService.getPurchaseDataById(purchaseId);
    }
    @GetMapping("/purchases")
    public List<Purchased> getAllPurchased(){
        return purchasedService.getAllPurchaseData();
    }
    @DeleteMapping("/purchases/{purchaseId}")
    public void deletePurchased(@PathVariable String purchaseId){
        purchasedService.deletePurchaseDataById(purchaseId);

    }

}
