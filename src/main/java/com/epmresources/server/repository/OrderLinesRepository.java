package com.epmresources.server.repository;
import com.epmresources.server.domain.OrderLines;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the OrderLines entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderLinesRepository extends JpaRepository<OrderLines, Long>, JpaSpecificationExecutor<OrderLines> {

}
