package com.epmresources.server.repository;

import com.epmresources.server.domain.Customers;

public interface CustomersExtendRepository extends CustomersRepository {
    Customers findCustomersByUserId(Long userId);
}
