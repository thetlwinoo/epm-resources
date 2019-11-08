package com.epmresources.server.service.mapper;

import com.epmresources.server.domain.*;
import com.epmresources.server.service.dto.ProductBrandDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProductBrand} and its DTO {@link ProductBrandDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProductBrandMapper extends EntityMapper<ProductBrandDTO, ProductBrand> {



    default ProductBrand fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProductBrand productBrand = new ProductBrand();
        productBrand.setId(id);
        return productBrand;
    }
}
