package com.epmresources.server.repository;
import com.epmresources.server.domain.BusinessEntityAddress;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BusinessEntityAddress entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BusinessEntityAddressRepository extends JpaRepository<BusinessEntityAddress, Long>, JpaSpecificationExecutor<BusinessEntityAddress> {

}
