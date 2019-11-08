package com.epmresources.server.repository;
import com.epmresources.server.domain.TransactionTypes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TransactionTypes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransactionTypesRepository extends JpaRepository<TransactionTypes, Long>, JpaSpecificationExecutor<TransactionTypes> {

}
