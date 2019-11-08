package com.epmresources.server.repository;
import com.epmresources.server.domain.WishlistProducts;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the WishlistProducts entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WishlistProductsRepository extends JpaRepository<WishlistProducts, Long>, JpaSpecificationExecutor<WishlistProducts> {

}
