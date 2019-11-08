package com.epmresources.server.service;

import com.epmresources.server.service.dto.SuppliersDTO;

import java.security.Principal;
import java.util.Optional;

public interface SuppliersExtendService {
    Optional<SuppliersDTO> getSupplierByPrincipal(Principal principal);
}
