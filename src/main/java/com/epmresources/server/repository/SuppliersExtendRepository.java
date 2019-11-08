package com.epmresources.server.repository;

import com.epmresources.server.domain.Suppliers;

import java.util.Optional;

public interface SuppliersExtendRepository extends SuppliersRepository  {
    Optional<Suppliers> findSuppliersByUserId(Long userId);
}
