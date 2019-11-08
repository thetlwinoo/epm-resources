package com.epmresources.server.service.mapper;

import com.epmresources.server.domain.*;
import com.epmresources.server.service.dto.MaterialsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Materials} and its DTO {@link MaterialsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MaterialsMapper extends EntityMapper<MaterialsDTO, Materials> {



    default Materials fromId(Long id) {
        if (id == null) {
            return null;
        }
        Materials materials = new Materials();
        materials.setId(id);
        return materials;
    }
}
