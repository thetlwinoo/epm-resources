package com.epmresources.server.repository;
import com.epmresources.server.domain.CurrencyRate;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CurrencyRate entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long>, JpaSpecificationExecutor<CurrencyRate> {

}
