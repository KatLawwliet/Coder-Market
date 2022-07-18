package com.coder.platzimarket.domain.repository;

import com.coder.platzimarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getCarseProducts(int quiantity);
    Optional<List<Product>> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
