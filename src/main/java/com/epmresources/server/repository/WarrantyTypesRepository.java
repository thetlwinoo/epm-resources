package com.epmresources.server.repository;
import com.epmresources.server.domain.WarrantyTypes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the WarrantyTypes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WarrantyTypesRepository extends JpaRepository<WarrantyTypes, Long>, JpaSpecificationExecutor<WarrantyTypes> {

}
