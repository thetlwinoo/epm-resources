package com.epmresources.server.repository;

import com.epmresources.server.domain.ProductCategory;

import java.util.List;

public interface ProductCategoryExtendRepository extends ProductCategoryRepository {
    List<ProductCategory> findAllByParentIdIsNull();
    List<ProductCategory> findAllByParentId(Long parentId);
    ProductCategory findProductCategoryByNameContaining(String categoryName);
}
