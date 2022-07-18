package com.coder.platzimarket.persistence.mapper;

import com.coder.platzimarket.domain.Category;
import com.coder.platzimarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel= "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source ="idCategoria", target ="categoryId"),
            @Mapping(source ="descripcion", target ="category"),
            @Mapping(source ="estado", target ="active"),
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target= "productos", ignore = true)
    Categoria toCategory(Category category);


}
