package com.epmresources.server.repository;

import com.epmresources.server.domain.UploadTransactions;

import java.util.List;

public interface UploadTransactionsExtendRepository extends UploadTransactionsRepository {
    List<UploadTransactions> findAllBySupplierId(Long supplierId);
}
