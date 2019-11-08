package com.epmresources.server.repository;

import com.epmresources.server.domain.SupplierImportedDocument;

import java.util.Optional;

public interface SupplierImportedDocumentExtendRepository extends SupplierImportedDocumentRepository {
    Optional<SupplierImportedDocument> findFirstByUploadTransactionId(Long id);
}
