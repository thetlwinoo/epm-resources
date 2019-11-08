package com.epmresources.server.repository;
import com.epmresources.server.domain.PersonEmailAddress;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the PersonEmailAddress entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PersonEmailAddressRepository extends JpaRepository<PersonEmailAddress, Long>, JpaSpecificationExecutor<PersonEmailAddress> {

}
