package com.epmresources.server.repository;
import com.epmresources.server.domain.ProductChoice;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProductChoice entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductChoiceRepository extends JpaRepository<ProductChoice, Long>, JpaSpecificationExecutor<ProductChoice> {

}
