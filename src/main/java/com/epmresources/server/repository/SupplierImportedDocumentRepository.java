package com.epmresources.server.repository;
import com.epmresources.server.domain.SupplierImportedDocument;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SupplierImportedDocument entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SupplierImportedDocumentRepository extends JpaRepository<SupplierImportedDocument, Long>, JpaSpecificationExecutor<SupplierImportedDocument> {

}
