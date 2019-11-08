package com.epmresources.server.service.mapper;

import com.epmresources.server.domain.*;
import com.epmresources.server.service.dto.ProductSetDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProductSetDetails} and its DTO {@link ProductSetDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProductSetDetailsMapper extends EntityMapper<ProductSetDetailsDTO, ProductSetDetails> {



    default ProductSetDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProductSetDetails productSetDetails = new ProductSetDetails();
        productSetDetails.setId(id);
        return productSetDetails;
    }
}
