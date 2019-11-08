package com.epmresources.server.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.epmresources.server.domain.ProductSet} entity.
 */
public class ProductSetDTO implements Serializable {

    private Long id;

    @NotNull
    private String productSetName;

    @NotNull
    private Integer noOfPerson;

    private Boolean isExclusive;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductSetName() {
        return productSetName;
    }

    public void setProductSetName(String productSetName) {
        this.productSetName = productSetName;
    }

    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public Boolean isIsExclusive() {
        return isExclusive;
    }

    public void setIsExclusive(Boolean isExclusive) {
        this.isExclusive = isExclusive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductSetDTO productSetDTO = (ProductSetDTO) o;
        if (productSetDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productSetDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductSetDTO{" +
            "id=" + getId() +
            ", productSetName='" + getProductSetName() + "'" +
            ", noOfPerson=" + getNoOfPerson() +
            ", isExclusive='" + isIsExclusive() + "'" +
            "}";
    }
}
