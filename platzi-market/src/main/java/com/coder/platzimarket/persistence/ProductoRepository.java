package com.coder.platzimarket.persistence;

import com.coder.platzimarket.domain.Product;
import com.coder.platzimarket.domain.repository.ProductRepository;
import com.coder.platzimarket.persistence.crud.ProductoCrudRepository;
import com.coder.platzimarket.persistence.entity.Producto;
import com.coder.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
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
    public Optional<List<Product>> getProduct(int productId) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
