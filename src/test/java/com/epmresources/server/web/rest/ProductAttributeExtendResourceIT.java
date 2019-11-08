package com.epmresources.server.web.rest;

import com.epmresources.server.EpmresourcesApp;
import com.epmresources.server.service.ProductAttributeExtendService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the ProductAttributeExtendResource REST controller.
 *
 * @see ProductAttributeExtendResource
 */
@SpringBootTest(classes = EpmresourcesApp.class)
public class ProductAttributeExtendResourceIT {

    private MockMvc restMockMvc;
    private final ProductAttributeExtendService productAttributeExtendService;

    public ProductAttributeExtendResourceIT(ProductAttributeExtendService productAttributeExtendService) {
        this.productAttributeExtendService = productAttributeExtendService;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ProductAttributeExtendResource productAttributeExtendResource = new ProductAttributeExtendResource(productAttributeExtendService);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(productAttributeExtendResource)
            .build();
    }

    /**
     * Test defaultAction
     */
    @Test
    public void testDefaultAction() throws Exception {
        restMockMvc.perform(get("/api/product-attribute-extend/default-action"))
            .andExpect(status().isOk());
    }
}
