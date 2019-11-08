package com.epmresources.server.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.epmresources.server.domain.AddressTypes} entity. This class is used
 * in {@link com.epmresources.server.web.rest.AddressTypesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /address-types?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AddressTypesCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter addressTypeName;

    private StringFilter refer;

    public AddressTypesCriteria(){
    }

    public AddressTypesCriteria(AddressTypesCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.addressTypeName = other.addressTypeName == null ? null : other.addressTypeName.copy();
        this.refer = other.refer == null ? null : other.refer.copy();
    }

    @Override
    public AddressTypesCriteria copy() {
        return new AddressTypesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getAddressTypeName() {
        return addressTypeName;
    }

    public void setAddressTypeName(StringFilter addressTypeName) {
        this.addressTypeName = addressTypeName;
    }

    public StringFilter getRefer() {
        return refer;
    }

    public void setRefer(StringFilter refer) {
        this.refer = refer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AddressTypesCriteria that = (AddressTypesCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(addressTypeName, that.addressTypeName) &&
            Objects.equals(refer, that.refer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        addressTypeName,
        refer
        );
    }

    @Override
    public String toString() {
        return "AddressTypesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (addressTypeName != null ? "addressTypeName=" + addressTypeName + ", " : "") +
                (refer != null ? "refer=" + refer + ", " : "") +
            "}";
    }

}
