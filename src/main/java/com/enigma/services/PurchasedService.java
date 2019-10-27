package com.enigma.services;
import com.enigma.entities.PurchaseDetail;
import com.enigma.entities.Purchased;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurchasedService {

    public Purchased save(Purchased purchased);
    public Purchased getPurchaseDataById(String purchaseId);
    public List<Purchased> getAllPurchaseData();
    public void deletePurchaseDataById(String purchaseId);
   // public Page<Purchased> searchSpesific(Purchased searchForm, Pageable pageable);
}
