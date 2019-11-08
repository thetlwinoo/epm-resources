package com.epmresources.server.repository;
import com.epmresources.server.domain.ProductDocument;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProductDocument entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductDocumentRepository extends JpaRepository<ProductDocument, Long>, JpaSpecificationExecutor<ProductDocument> {

}
