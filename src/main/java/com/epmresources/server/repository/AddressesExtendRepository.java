package com.epmresources.server.repository;

import com.epmresources.server.domain.Addresses;

import java.util.List;

public interface AddressesExtendRepository extends AddressesRepository {
    List<Addresses> findAllByPersonId(Long id);
}
