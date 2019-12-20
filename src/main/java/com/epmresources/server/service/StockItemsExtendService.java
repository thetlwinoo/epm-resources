package com.epmresources.server.service;

import com.epmresources.server.service.dto.PhotosDTO;
import com.epmresources.server.service.dto.StockItemsDTO;

import java.util.List;

public interface StockItemsExtendService {
    PhotosDTO addPhotos(PhotosDTO photosDTO, String baseUrl);

    PhotosDTO updatePhotos(PhotosDTO photosDTO, String baseUrl);

    List<StockItemsDTO> findAllByProductId(Long productId);
}
