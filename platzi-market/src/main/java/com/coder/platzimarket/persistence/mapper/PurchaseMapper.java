package com.coder.platzimarket.persistence.mapper;

import com.coder.platzimarket.domain.Purchase;
import com.coder.platzimarket.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {


        @Mappings({
                @Mapping(source = "idCompra", target = "purchaseId"),
                @Mapping(source = "idCliente", target = "clienteId"),
                @Mapping(source = "fecha", target = "date"),
                @Mapping(source = "medioPago", target = "paymentMethod"),
                @Mapping(source = "comentario", target = "comment"),
                @Mapping(source = "estado", target = "state"),
                @Mapping(source = "productos", target = "items"),


        })
        Purchase toPurchases(Compra compra);
        List<Purchase> toPurchases(List<Compra> compras);


        @InheritInverseConfiguration
        @Mapping(target = "cliente", ignore = true)
        Compra toCompra(Purchase purchase);


}
