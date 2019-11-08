package com.epmresources.server.service.impl;

import com.epmresources.server.domain.Addresses;
import com.epmresources.server.domain.People;
import com.epmresources.server.domain.User;
import com.epmresources.server.repository.AddressesExtendRepository;
import com.epmresources.server.repository.PeopleExtendRepository;
import com.epmresources.server.repository.UserRepository;
import com.epmresources.server.service.AddressesExtendService;
import com.epmresources.server.service.AddressesService;
import com.epmresources.server.service.dto.AddressesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressesExtendServiceImpl implements AddressesExtendService {

    private final Logger log = LoggerFactory.getLogger(AddressesExtendServiceImpl.class);
    private final PeopleExtendRepository peopleExtendRepository;
    private final AddressesExtendRepository addressesExtendRepository;
    private final AddressesService addressesService;
    private final UserRepository userRepository;

    public AddressesExtendServiceImpl(PeopleExtendRepository peopleExtendRepository, AddressesExtendRepository addressesExtendRepository, AddressesService addressesService, UserRepository userRepository) {
        this.peopleExtendRepository = peopleExtendRepository;
        this.addressesExtendRepository = addressesExtendRepository;
        this.addressesService = addressesService;
        this.userRepository = userRepository;
    }

    @Override
    public List<Addresses> fetchAddresses(Principal principal) {
        People people = getUserFromPrinciple(principal);
        return addressesExtendRepository.findAllByPersonId(people.getId());
    }

    @Override
    public void clearDefaultAddress(Principal principal) {
        People people = getUserFromPrinciple(principal);
        List<Addresses> addressesList = addressesExtendRepository.findAllByPersonId(people.getId());

        for (Addresses addresses : addressesList) {
            addresses.setDefaultInd(false);
            addressesExtendRepository.save(addresses);
        }
    }

    @Override
    public void setDefaultAddress(Principal principal, Long addressId) {
        People people = getUserFromPrinciple(principal);
        List<Addresses> addressesList = addressesExtendRepository.findAllByPersonId(people.getId());

        for (Addresses addresses : addressesList) {
            if (addresses.getId().equals(addressId)) {
                addresses.setDefaultInd(true);
            } else {
                addresses.setDefaultInd(false);
            }

            addressesExtendRepository.save(addresses);
        }
    }

    @Override
    public AddressesDTO crateAddresses(AddressesDTO addressesDTO, Principal principal) {
        People people = getUserFromPrinciple(principal);
        if (addressesDTO.isDefaultInd()) {
            this.clearDefaultAddress(principal);
        }

        addressesDTO.setPersonId(people.getId());
        AddressesDTO result = addressesService.save(addressesDTO);

        return result;
    }

    @Override
    public AddressesDTO updateAddresses(AddressesDTO addressesDTO, Principal principal) {
        if (addressesDTO.isDefaultInd()) {
            this.clearDefaultAddress(principal);
        }
        AddressesDTO result = addressesService.save(addressesDTO);

        return result;
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
