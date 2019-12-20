package com.epmresources.server.web.rest;

import com.epmresources.server.repository.PhotosExtendRepository;
import com.epmresources.server.service.PhotosExtendService;
import com.epmresources.server.service.PhotosService;
import com.epmresources.server.service.dto.PhotosDTO;
import io.github.jhipster.web.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * PhotosExtendResource controller
 */
@RestController
@RequestMapping("/api/photos-extend")
public class PhotosExtendResource {

    private final Logger log = LoggerFactory.getLogger(PhotosExtendResource.class);
    private final PhotosExtendService photosExtendService;
    private final PhotosService photosService;
    private final PhotosExtendRepository photosExtendRepository;
    private static final String ENTITY_NAME = "photos-extend";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public PhotosExtendResource(PhotosExtendService photosExtendService, PhotosService photosService, PhotosExtendRepository photosExtendRepository) {
        this.photosExtendService = photosExtendService;
        this.photosService = photosService;
        this.photosExtendRepository = photosExtendRepository;
    }

    @RequestMapping(value = "/stockitem/{id}/{handle}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPhotosByStockItem(@PathVariable Long id, @PathVariable String handle) {
        Optional<PhotosDTO> photos = photosExtendService.getOneByStockItem(id);
        byte[] photo;
        HttpHeaders header = new HttpHeaders();
        if(photos.isPresent()){
            switch (handle) {
                case "thumbnail":
                    header.setContentType(MediaType.valueOf(photos.get().getThumbnailPhotoBlobContentType()));
                    header.setContentLength(photos.get().getThumbnailPhotoBlob().length);
                    photo = photos.get().getThumbnailPhotoBlob();
                    break;
                case "original":
                    header.setContentType(MediaType.valueOf(photos.get().getOriginalPhotoBlobContentType()));
                    header.setContentLength(photos.get().getOriginalPhotoBlob().length);
                    photo = photos.get().getOriginalPhotoBlob();
                    break;
                default:
                    header.setContentType(MediaType.valueOf(photos.get().getThumbnailPhotoBlobContentType()));
                    header.setContentLength(photos.get().getThumbnailPhotoBlob().length);
                    photo = photos.get().getThumbnailPhotoBlob();
            }
            return new ResponseEntity<>(photo, header, HttpStatus.OK);
        }
//        header.set("Content-Disposition", "attachment; filename=" + stockitem.toString() + ".png");

        return new ResponseEntity<>(null, header, HttpStatus.OK);
    }

    @RequestMapping(value = "/download/{id}/{handle}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(@PathVariable Long id, @PathVariable String handle) {
        Optional<PhotosDTO> photos = photosService.findOne(id);
        byte[] photo;
        HttpHeaders header = new HttpHeaders();
        if(photos.isPresent()){
            switch (handle) {
                case "thumbnail":
                    header.setContentType(MediaType.valueOf(photos.get().getThumbnailPhotoBlobContentType()));
                    header.setContentLength(photos.get().getThumbnailPhotoBlob().length);
                    photo = photos.get().getThumbnailPhotoBlob();
                    break;
                case "original":
                    header.setContentType(MediaType.valueOf(photos.get().getOriginalPhotoBlobContentType()));
                    header.setContentLength(photos.get().getOriginalPhotoBlob().length);
                    photo = photos.get().getOriginalPhotoBlob();
                    break;
                default:
                    header.setContentType(MediaType.valueOf(photos.get().getThumbnailPhotoBlobContentType()));
                    header.setContentLength(photos.get().getThumbnailPhotoBlob().length);
                    photo = photos.get().getThumbnailPhotoBlob();
            }
            return new ResponseEntity<>(photo, header, HttpStatus.OK);
        }
//        header.set("Content-Disposition", "attachment; filename=" + stockitem.toString() + ".png");

        return new ResponseEntity<>(null, header, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/photos/{id}")
    public ResponseEntity<Void> deletePhotos(@PathVariable Long id) {
        photosExtendRepository.deletePhotos(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
