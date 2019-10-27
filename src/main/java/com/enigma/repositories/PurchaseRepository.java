package com.enigma.repositories;

        import com.enigma.entities.Purchased;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchased, String> {
}
