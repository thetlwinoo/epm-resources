package com.epmresources.server.service.impl;

import com.epmresources.server.domain.People;
import com.epmresources.server.domain.User;
import com.epmresources.server.repository.PeopleExtendRepository;
import com.epmresources.server.repository.SuppliersExtendRepository;
import com.epmresources.server.repository.UserRepository;
import com.epmresources.server.service.SuppliersExtendService;
import com.epmresources.server.service.dto.SuppliersDTO;
import com.epmresources.server.service.mapper.SuppliersMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;

@Service
@Transactional
public class SuppliersExtendServiceImpl implements SuppliersExtendService {

    private final Logger log = LoggerFactory.getLogger(SuppliersExtendServiceImpl.class);
    private final PeopleExtendRepository peopleExtendRepository;
    private final SuppliersExtendRepository suppliersExtendRepository;
    private final SuppliersMapper suppliersMapper;
    private final UserRepository userRepository;

    public SuppliersExtendServiceImpl(PeopleExtendRepository peopleExtendRepository, SuppliersExtendRepository suppliersExtendRepository, SuppliersMapper suppliersMapper, UserRepository userRepository) {
        this.peopleExtendRepository = peopleExtendRepository;
        this.suppliersExtendRepository = suppliersExtendRepository;
        this.suppliersMapper = suppliersMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<SuppliersDTO> getSupplierByPrincipal(Principal principal) {
        Optional<User> userOptional = userRepository.findOneByLogin(principal.getName());
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        return suppliersExtendRepository.findSuppliersByUserId(userOptional.get().getId())
            .map(suppliersMapper::toDto);
    }

    private People getUserFromPrinciple(Principal principal) {
        if (principal == null || principal.getName() == null) {
            throw new IllegalArgumentException("Invalid access");
        }
        Optional<User> userOptional = userRepository.findOneByLogin(principal.getName());
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        Optional<People> people = peopleExtendRepository.findPeopleByEmailAddress(userOptional.get().getEmail());
        if (!people.isPresent()) {
            throw new IllegalArgumentException("People not found");
        }
        return people.get();
    }
}
