package com.coder.platzimarket.persistence;

import com.coder.platzimarket.domain.Purchase;
import com.coder.platzimarket.domain.repository.PurchaseRepository;
import com.coder.platzimarket.persistence.crud.CompraCrudRepository;
import com.coder.platzimarket.persistence.entity.Compra;
import com.coder.platzimarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ComprasRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return (Purchase) mapper.toPurchases(Collections.singletonList(compraCrudRepository.save(compra)));
    }
}
