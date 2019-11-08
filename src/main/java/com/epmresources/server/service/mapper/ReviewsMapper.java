package com.epmresources.server.service.mapper;

import com.epmresources.server.domain.*;
import com.epmresources.server.service.dto.ReviewsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Reviews} and its DTO {@link ReviewsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReviewsMapper extends EntityMapper<ReviewsDTO, Reviews> {


    @Mapping(target = "reviewLineLists", ignore = true)
    @Mapping(target = "removeReviewLineList", ignore = true)
    @Mapping(target = "order", ignore = true)
    Reviews toEntity(ReviewsDTO reviewsDTO);

    default Reviews fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reviews reviews = new Reviews();
        reviews.setId(id);
        return reviews;
    }
}
