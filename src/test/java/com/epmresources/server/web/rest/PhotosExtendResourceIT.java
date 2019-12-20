package com.epmresources.server.web.rest;

import com.epmresources.server.EpmresourcesApp;
import com.epmresources.server.repository.PhotosExtendRepository;
import com.epmresources.server.service.PhotosExtendService;
import com.epmresources.server.service.PhotosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the PhotosExtendResource REST controller.
 *
 * @see PhotosExtendResource
 */
@SpringBootTest(classes = EpmresourcesApp.class)
public class PhotosExtendResourceIT {

    private MockMvc restMockMvc;
    private final PhotosExtendService photosExtendService;
    private final PhotosExtendRepository photosExtendRepository;
    private final PhotosService photosService;

    public PhotosExtendResourceIT(PhotosExtendService photosExtendService, PhotosExtendRepository photosExtendRepository, PhotosService photosService) {
        this.photosExtendService = photosExtendService;
        this.photosExtendRepository = photosExtendRepository;
        this.photosService = photosService;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        PhotosExtendResource photosExtendResource = new PhotosExtendResource(photosExtendService, photosService, photosExtendRepository);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(photosExtendResource)
            .build();
    }

    /**
     * Test defaultAction
     */
    @Test
    public void testDefaultAction() throws Exception {
        restMockMvc.perform(get("/api/photos-extend/default-action"))
            .andExpect(status().isOk());
    }
}
