package com.epmresources.server.repository;

import com.epmresources.server.domain.People;

import java.util.Optional;

public interface PeopleExtendRepository extends PeopleRepository {
    Optional<People> findPeopleByEmailAddress(String email);
}
