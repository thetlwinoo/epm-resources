package com.epmresources.server.repository;
import com.epmresources.server.domain.PhoneNumberType;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the PhoneNumberType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PhoneNumberTypeRepository extends JpaRepository<PhoneNumberType, Long>, JpaSpecificationExecutor<PhoneNumberType> {

}
