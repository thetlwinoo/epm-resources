package com.epmresources.server.web.rest;

import com.epmresources.server.service.SuppliersExtendService;
import com.epmresources.server.service.dto.SuppliersDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

/**
 * SuppliersExtendResource controller
 */
@RestController
@RequestMapping("/api/suppliers-extend")
public class SuppliersExtendResource {

    private final Logger log = LoggerFactory.getLogger(SuppliersExtendResource.class);
    private final SuppliersExtendService suppliersExtendService;

    public SuppliersExtendResource(SuppliersExtendService suppliersExtendService) {
        this.suppliersExtendService = suppliersExtendService;
    }

    @GetMapping("/suppliers-extend/principal")
    public ResponseEntity<SuppliersDTO> getOneByPrincipal(Principal principal) {
        Optional<SuppliersDTO> suppliersDTOOptional = suppliersExtendService.getSupplierByPrincipal(principal);
        return ResponseUtil.wrapOrNotFound(suppliersDTOOptional);
    }
}
