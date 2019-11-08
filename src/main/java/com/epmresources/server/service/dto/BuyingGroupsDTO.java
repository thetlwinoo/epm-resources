package com.epmresources.server.service.dto;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.epmresources.server.domain.BuyingGroups} entity.
 */
public class BuyingGroupsDTO implements Serializable {

    private Long id;

    private String buyingGroupName;

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

    public String getBuyingGroupName() {
        return buyingGroupName;
    }

    public void setBuyingGroupName(String buyingGroupName) {
        this.buyingGroupName = buyingGroupName;
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

        BuyingGroupsDTO buyingGroupsDTO = (BuyingGroupsDTO) o;
        if (buyingGroupsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), buyingGroupsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BuyingGroupsDTO{" +
            "id=" + getId() +
            ", buyingGroupName='" + getBuyingGroupName() + "'" +
            ", validFrom='" + getValidFrom() + "'" +
            ", validTo='" + getValidTo() + "'" +
            "}";
    }
}
