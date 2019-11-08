package com.epmresources.server.service;

import com.epmresources.server.domain.Orders;
import com.epmresources.server.service.dto.ReviewLinesDTO;
import com.epmresources.server.service.dto.ReviewsDTO;

import java.security.Principal;
import java.util.List;

public interface ReviewsExtendService {
    ReviewsDTO save(Principal principal, ReviewsDTO reviewsDTO, Long orderId);

    List<Orders> findAllOrderedProducts(Principal principal);

    List<ReviewLinesDTO> findReviewLinesByStockItemId(Long stockItemId);

    ReviewsDTO completedReview(Long orderId);
}
