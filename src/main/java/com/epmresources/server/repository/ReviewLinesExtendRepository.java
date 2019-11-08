package com.epmresources.server.repository;

import com.epmresources.server.domain.ReviewLines;

import java.util.List;

public interface ReviewLinesExtendRepository extends ReviewLinesRepository {
    List<ReviewLines> findAllByStockItemId(Long stockItemId);
}
