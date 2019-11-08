package com.epmresources.server.repository;
import com.epmresources.server.domain.StockItems;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the StockItems entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StockItemsRepository extends JpaRepository<StockItems, Long>, JpaSpecificationExecutor<StockItems> {

}
