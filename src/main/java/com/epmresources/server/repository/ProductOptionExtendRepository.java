package com.epmresources.server.repository;

import com.epmresources.server.domain.ProductOption;

import java.util.List;

public interface ProductOptionExtendRepository extends ProductOptionRepository {
    List<ProductOption> findAllByProductOptionSetIdAndSupplierId(Long attributeSetId, Long supplierId);
}
