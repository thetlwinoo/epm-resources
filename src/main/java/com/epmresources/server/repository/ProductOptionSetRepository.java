package com.epmresources.server.repository;
import com.epmresources.server.domain.ProductOptionSet;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProductOptionSet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductOptionSetRepository extends JpaRepository<ProductOptionSet, Long>, JpaSpecificationExecutor<ProductOptionSet> {

}
