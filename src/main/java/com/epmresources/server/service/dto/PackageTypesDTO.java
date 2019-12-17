package com.epmresources.server.service.dto;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.epmresources.server.domain.PackageTypes} entity.
 */
public class PackageTypesDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Instant validFrom;

    @NotNull
    private Instant validTo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Instant validFrom) {
        this.validFrom = validFrom;
    }

    public Instant getValidTo() {
        return validTo;
    }

    public void setValidTo(Instant validTo) {
        this.validTo = validTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PackageTypesDTO packageTypesDTO = (PackageTypesDTO) o;
        if (packageTypesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), packageTypesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PackageTypesDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", validFrom='" + getValidFrom() + "'" +
            ", validTo='" + getValidTo() + "'" +
            "}";
    }
}
