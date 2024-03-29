package com.epmresources.server.repository;
import com.epmresources.server.domain.ProductSetDetails;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProductSetDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductSetDetailsRepository extends JpaRepository<ProductSetDetails, Long>, JpaSpecificationExecutor<ProductSetDetails> {

}
