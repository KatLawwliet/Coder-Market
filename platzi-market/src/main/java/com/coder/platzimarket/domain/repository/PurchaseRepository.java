package com.coder.platzimarket.domain.repository;

import com.coder.platzimarket.domain.Purchase;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PurchaseRepository {

    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String clienteId);

    Purchase save(Purchase purchase);

}
