package com.epmresources.server.service.mapper;

import com.epmresources.server.domain.*;
import com.epmresources.server.service.dto.BuyingGroupsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BuyingGroups} and its DTO {@link BuyingGroupsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BuyingGroupsMapper extends EntityMapper<BuyingGroupsDTO, BuyingGroups> {



    default BuyingGroups fromId(Long id) {
        if (id == null) {
            return null;
        }
        BuyingGroups buyingGroups = new BuyingGroups();
        buyingGroups.setId(id);
        return buyingGroups;
    }
}
