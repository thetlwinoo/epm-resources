package com.epmresources.server.service.impl;

import com.epmresources.server.domain.UploadTransactions;
import com.epmresources.server.repository.UploadTransactionsExtendRepository;
import com.epmresources.server.service.SuppliersExtendService;
import com.epmresources.server.service.UploadTransactionsExtendService;
import com.epmresources.server.service.dto.SuppliersDTO;
import com.epmresources.server.service.dto.UploadTransactionsDTO;
import com.epmresources.server.service.mapper.UploadTransactionsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UploadTransactionsExtendServiceImpl implements UploadTransactionsExtendService {

    private final Logger log = LoggerFactory.getLogger(UploadTransactionsExtendServiceImpl.class);
    private final UploadTransactionsExtendRepository uploadTransactionsExtendRepository;
    private final SuppliersExtendService suppliersExtendService;
    private final UploadTransactionsMapper uploadTransactionsMapper;


    public UploadTransactionsExtendServiceImpl(UploadTransactionsExtendRepository uploadTransactionsExtendRepository, SuppliersExtendService suppliersExtendService, UploadTransactionsMapper uploadTransactionsMapper) {
        this.uploadTransactionsExtendRepository = uploadTransactionsExtendRepository;
        this.suppliersExtendService = suppliersExtendService;
        this.uploadTransactionsMapper = uploadTransactionsMapper;
    }

    @Override
    public void clearStockItemTemp(Long transactionId) {
        UploadTransactions uploadTransactions = uploadTransactionsExtendRepository.getOne(transactionId);
        uploadTransactions.setStockItemTempLists(null);
        uploadTransactionsExtendRepository.save(uploadTransactions);
    }

    @Override
    public List<UploadTransactionsDTO> findAll(Principal principal) {
        Optional<SuppliersDTO> suppliersDTOOptional = suppliersExtendService.getSupplierByPrincipal(principal);
        return uploadTransactionsExtendRepository.findAllBySupplierId(suppliersDTOOptional.get().getId()).stream()
            .map(uploadTransactionsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }
}
