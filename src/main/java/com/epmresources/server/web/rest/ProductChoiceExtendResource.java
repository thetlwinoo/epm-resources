package com.epmresources.server.web.rest;

import com.epmresources.server.service.ProductChoiceExtendService;
import com.epmresources.server.service.dto.ProductChoiceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProductChoiceExtendResource controller
 */
@RestController
@RequestMapping("/api/product-choice-extend")
public class ProductChoiceExtendResource {

    private final Logger log = LoggerFactory.getLogger(ProductChoiceExtendResource.class);
    private final ProductChoiceExtendService productChoiceExtendService;

    public ProductChoiceExtendResource(ProductChoiceExtendService productChoiceExtendService) {
        this.productChoiceExtendService = productChoiceExtendService;
    }

    @GetMapping("/product-choice-extend")
    public List<ProductChoiceDTO> getAllProductChoice(@RequestParam(value = "categoryId", required = false) Long categoryId) {
        log.debug("REST request to get all ProductAttributes");
        return productChoiceExtendService.getAllProductChoice(categoryId);
    }
}
