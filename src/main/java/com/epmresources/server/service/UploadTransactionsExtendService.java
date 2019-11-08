package com.epmresources.server.service;

import com.epmresources.server.service.dto.UploadTransactionsDTO;

import java.security.Principal;
import java.util.List;

public interface UploadTransactionsExtendService {
    void clearStockItemTemp(Long transactionId);

    List<UploadTransactionsDTO> findAll(Principal principal);
}
