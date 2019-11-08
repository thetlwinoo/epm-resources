package com.epmresources.server.repository;
import com.epmresources.server.domain.InvoiceLines;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the InvoiceLines entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InvoiceLinesRepository extends JpaRepository<InvoiceLines, Long>, JpaSpecificationExecutor<InvoiceLines> {

}
