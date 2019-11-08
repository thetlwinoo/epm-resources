package com.epmresources.server.repository;
import com.epmresources.server.domain.SupplierTransactions;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SupplierTransactions entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SupplierTransactionsRepository extends JpaRepository<SupplierTransactions, Long>, JpaSpecificationExecutor<SupplierTransactions> {

}
