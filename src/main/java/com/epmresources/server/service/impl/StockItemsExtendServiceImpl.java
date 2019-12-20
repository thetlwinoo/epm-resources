package com.epmresources.server.service.impl;

import com.epmresources.server.domain.Photos;
import com.epmresources.server.domain.Products;
import com.epmresources.server.domain.StockItems;
import com.epmresources.server.repository.PhotosRepository;
import com.epmresources.server.repository.ProductsRepository;
import com.epmresources.server.repository.StockItemsRepository;
import com.epmresources.server.service.StockItemsExtendService;
import com.epmresources.server.service.dto.PhotosDTO;
import com.epmresources.server.service.dto.StockItemsDTO;
import com.epmresources.server.service.mapper.StockItemsMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class StockItemsExtendServiceImpl implements StockItemsExtendService {

    private final Logger log = LoggerFactory.getLogger(StockItemsExtendServiceImpl.class);
    private final StockItemsRepository stockItemsRepository;
    private final StockItemsMapper stockItemsMapper;
    private final ProductsRepository productsRepository;
    private final PhotosRepository photosRepository;

    public StockItemsExtendServiceImpl(StockItemsRepository stockItemsRepository, StockItemsMapper stockItemsMapper, ProductsRepository productsRepository, PhotosRepository photosRepository) {
        this.stockItemsRepository = stockItemsRepository;
        this.stockItemsMapper = stockItemsMapper;
        this.productsRepository = productsRepository;
        this.photosRepository = photosRepository;
    }

    @Override
    public PhotosDTO addPhotos(PhotosDTO photosDTO,String baseUrl) {
        try {
            StockItems stockItems = stockItemsRepository.getOne(photosDTO.getStockItemId());
            Photos photos = new Photos();
            photos.setStockItem(stockItems);
            photos.setId(photosDTO.getId());
            photos.setOriginalPhotoBlob(photosDTO.getOriginalPhotoBlob());
            photos.setOriginalPhotoBlobContentType(photosDTO.getOriginalPhotoBlobContentType());
            photos.setThumbnailPhotoBlob(photosDTO.getThumbnailPhotoBlob());
            photos.setThumbnailPhotoBlobContentType(photosDTO.getThumbnailPhotoBlobContentType());

//            String thumbnailUrl = baseUrl + "/photos-extend/download/" + stockItems.getId() + "/thumbnail";
            stockItems.getPhotoLists().add(photos);
            stockItemsRepository.save(stockItems);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }

        return photosDTO;
    }

    @Override
    public PhotosDTO updatePhotos(PhotosDTO photosDTO,String baseUrl) {
        try {
            StockItems stockItems = stockItemsRepository.getOne(photosDTO.getStockItemId());
            for (Photos photo : stockItems.getPhotoLists()) {
                if (photo.getId().equals(photosDTO.getId())) {
                    photo.setOriginalPhotoBlob(photosDTO.getOriginalPhotoBlob());
                    photo.setOriginalPhotoBlobContentType(photosDTO.getOriginalPhotoBlobContentType());
                    photo.setThumbnailPhotoBlob(photosDTO.getThumbnailPhotoBlob());
                    photo.setThumbnailPhotoBlobContentType(photosDTO.getThumbnailPhotoBlobContentType());
                    break;
                }
            }
            stockItemsRepository.save(stockItems);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }

        return photosDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<StockItemsDTO> findAllByProductId(Long productId) {
        log.debug("Request to get all stockItems where filtered by product id");
        return StreamSupport
            .stream(stockItemsRepository.findAll().spliterator(), false)
            .filter(stockItems -> stockItems.getProduct().getId().equals(productId))
            .map(stockItemsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }
}
