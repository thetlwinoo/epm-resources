package com.epmresources.server.repository;

import com.epmresources.server.domain.ProductAttribute;

import java.util.List;

public interface ProductAttributeExtendRepository extends ProductAttributeRepository {
    List<ProductAttribute> findAllByProductAttributeSetIdAndSupplierId(Long attributeSetId, Long supplierId);
}
