package com.epmresources.server.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A ProductSet.
 */
@Entity
@Table(name = "product_set")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProductSet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "product_set_name", nullable = false)
    private String productSetName;

    @NotNull
    @Column(name = "no_of_person", nullable = false)
    private Integer noOfPerson;

    @Column(name = "is_exclusive")
    private Boolean isExclusive;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductSetName() {
        return productSetName;
    }

    public ProductSet productSetName(String productSetName) {
        this.productSetName = productSetName;
        return this;
    }

    public void setProductSetName(String productSetName) {
        this.productSetName = productSetName;
    }

    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public ProductSet noOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
        return this;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public Boolean isIsExclusive() {
        return isExclusive;
    }

    public ProductSet isExclusive(Boolean isExclusive) {
        this.isExclusive = isExclusive;
        return this;
    }

    public void setIsExclusive(Boolean isExclusive) {
        this.isExclusive = isExclusive;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductSet)) {
            return false;
        }
        return id != null && id.equals(((ProductSet) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ProductSet{" +
            "id=" + getId() +
            ", productSetName='" + getProductSetName() + "'" +
            ", noOfPerson=" + getNoOfPerson() +
            ", isExclusive='" + isIsExclusive() + "'" +
            "}";
    }
}
