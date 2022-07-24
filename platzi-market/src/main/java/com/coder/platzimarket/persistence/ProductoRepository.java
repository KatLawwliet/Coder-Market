package com.coder.platzimarket.persistence;

import com.coder.platzimarket.domain.Product;
import com.coder.platzimarket.domain.repository.ProductRepository;
import com.coder.platzimarket.persistence.crud.ProductoCrudRepository;
import com.coder.platzimarket.persistence.entity.Producto;
import com.coder.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;
    public List<Product> getAll(){
        List<Producto> productos =(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getCarseProducts(int quiantity) {
         Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quiantity,true);
        return productos.map(prods ->mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
