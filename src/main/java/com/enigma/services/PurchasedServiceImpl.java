package com.enigma.services;

import com.enigma.entities.Product;
import com.enigma.entities.PurchaseDetail;
import com.enigma.entities.Purchased;
import com.enigma.entities.Users;
import com.enigma.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class PurchasedServiceImpl implements PurchasedService {
    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ProductService productService;

    @Autowired
    UserServices userServices;


    @Override
    public Purchased save(Purchased purchased) {
        Users users =userServices.getUserById(purchased.getUserId());
        purchased.setUsers(users);
        BigDecimal sum = new BigDecimal (0);
        for (PurchaseDetail purchaseDetail: purchased.getPurchaseDetailList()) {
            Product product = productService.getProductById(purchaseDetail.getProductId());
            purchaseDetail.setPurchased(purchased);
            purchaseDetail.setProduct(product);
            productService.deductQuantity(purchaseDetail.getProductId(),purchaseDetail.getQuantity());
            purchaseDetail.setPurchasePrice(productService.getProductPriceById(purchaseDetail.getProductId()));
            sum = sum.add(purchaseDetail.getSubTotalPrice());
        }
        purchased.setTotalPrice(sum);
        return purchaseRepository.save(purchased);
    }

    @Override
    public Purchased getPurchaseDataById(String purchaseId) {
        return purchaseRepository.findById(purchaseId).get();
    }

    @Override
    public List<Purchased> getAllPurchaseData() {
        return purchaseRepository.findAll();
    }

    @Override
    public void deletePurchaseDataById(String purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }


}
