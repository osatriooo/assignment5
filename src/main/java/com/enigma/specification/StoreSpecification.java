package com.enigma.specification;

import com.enigma.entities.Store;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class StoreSpecification {

    public static Specification<Store> findByCriterias(Store store){
        return new Specification<Store>() {
            @Override
            public Predicate toPredicate(Root<Store> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                final Collection<Predicate> predicates = new ArrayList<>();

                if(!StringUtils.isEmpty(store.getStoreName())){
                    final Predicate storeNamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("storeName")),"%"+store.getStoreName()+"%");
                    predicates.add(storeNamePredicate);
                }
                if(!StringUtils.isEmpty(store.getAddress())){
                    final Predicate addressPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("address")),"%"+store.getAddress()+"%");
                    predicates.add(addressPredicate);
                }


                return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }


}
