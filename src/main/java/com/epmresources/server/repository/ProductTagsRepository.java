package com.epmresources.server.repository;
import com.epmresources.server.domain.ProductTags;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ProductTags entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductTagsRepository extends JpaRepository<ProductTags, Long>, JpaSpecificationExecutor<ProductTags> {

}
