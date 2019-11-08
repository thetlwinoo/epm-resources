package com.epmresources.server.service;

import com.epmresources.server.service.dto.SupplierImportedDocumentDTO;

import java.util.Optional;

public interface SupplierImportedDocumentExtendService {
    Optional<SupplierImportedDocumentDTO> getOneByUploadTransactionId(Long transactionId);
}
