package com.epmresources.server.service;

import com.epmresources.server.service.dto.PhotosDTO;

public interface StockItemsExtendService {
    PhotosDTO addPhotos(PhotosDTO photosDTO);
    PhotosDTO updatePhotos(PhotosDTO photosDTO);
}
