package com.epmresources.server.repository;
import com.epmresources.server.domain.CompareProducts;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CompareProducts entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompareProductsRepository extends JpaRepository<CompareProducts, Long>, JpaSpecificationExecutor<CompareProducts> {

}
