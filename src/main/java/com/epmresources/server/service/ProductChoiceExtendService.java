package com.epmresources.server.service;

import com.epmresources.server.service.dto.ProductChoiceDTO;

import java.util.List;

public interface ProductChoiceExtendService {
    List<ProductChoiceDTO> getAllProductChoice(Long categoryId);
}
