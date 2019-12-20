package com.epmresources.server.service.dto;

import com.epmresources.server.domain.StockItems;

import java.util.List;

public class ProductsExtendDTO extends ProductsDTO {
    private List<StockItemsDTO> stockItemsDTOList;

    public List<StockItemsDTO> getStockItemsDTOList() {
        return stockItemsDTOList;
    }

    public void setStockItemsDTOList(List<StockItemsDTO> stockItemsDTOList) {
        this.stockItemsDTOList = stockItemsDTOList;
    }
}
