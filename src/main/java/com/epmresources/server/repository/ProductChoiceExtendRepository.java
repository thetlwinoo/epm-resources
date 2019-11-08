package com.epmresources.server.repository;

import com.epmresources.server.domain.ProductChoice;

import java.util.List;

public interface ProductChoiceExtendRepository extends ProductChoiceRepository {
    List<ProductChoice> findAllByProductCategoryId(Long categoryId);
}
