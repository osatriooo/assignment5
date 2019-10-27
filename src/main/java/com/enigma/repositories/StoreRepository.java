package com.enigma.repositories;

import com.enigma.entities.Product;
import com.enigma.entities.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,String> {
    public Page<Store> findAllByAddressContainsOrStoreNameContainsOrDescriptionContainsOrPhoneNumberContains(String address, String store, String desc, String phoneNumber, Pageable pageable);
}
