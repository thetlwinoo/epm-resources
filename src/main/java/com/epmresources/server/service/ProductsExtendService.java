package com.epmresources.server.service;

import com.epmresources.server.domain.Products;
import com.epmresources.server.service.dto.ProductCategoryDTO;
import com.epmresources.server.service.dto.ProductsDTO;
import com.epmresources.server.service.dto.ProductsExtendDTO;
import com.epmresources.server.service.dto.StockItemsDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductsExtendService {
    List<ProductsExtendDTO> findAllByProductCategory(Pageable pageable, Long productSubCategoryId);

    List<ProductsExtendDTO> findTop18ByOrderByLastEditedWhenDesc();

    List<ProductsExtendDTO> findTop12ByOrderBySellCountDesc();

    List<ProductsExtendDTO> findTop12ByOrderBySellCountDescCacheRefresh();

    List<ProductsExtendDTO> getRelatedProducts(Long productSubCategoryId, Long id);

    List<ProductsExtendDTO> searchProducts(String keyword, Integer page, Integer size);

    List<ProductsExtendDTO> searchProductsAll(String keyword);

    List<Long> getSubCategoryList(Long categoryId);

    List<ProductCategoryDTO> getRelatedCategories(String keyword, Long category);

    List<String> getRelatedColors(String keyword, Long category);

    Object getRelatedPriceRange(String keyword, Long category);

    List<String> getRelatedBrands(String keyword, Long category);

    ProductsDTO save(Products products, String serverUrl);

    List<Long> getProductIdsBySupplier(Long supplierId);
}
