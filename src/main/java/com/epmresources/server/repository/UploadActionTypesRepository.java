package com.epmresources.server.repository;
import com.epmresources.server.domain.UploadActionTypes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the UploadActionTypes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UploadActionTypesRepository extends JpaRepository<UploadActionTypes, Long>, JpaSpecificationExecutor<UploadActionTypes> {

}
