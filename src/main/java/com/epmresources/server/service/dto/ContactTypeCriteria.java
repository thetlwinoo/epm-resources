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
 * Criteria class for the {@link com.epmresources.server.domain.ContactType} entity. This class is used
 * in {@link com.epmresources.server.web.rest.ContactTypeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /contact-types?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ContactTypeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter contactTypeName;

    public ContactTypeCriteria(){
    }

    public ContactTypeCriteria(ContactTypeCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.contactTypeName = other.contactTypeName == null ? null : other.contactTypeName.copy();
    }

    @Override
    public ContactTypeCriteria copy() {
        return new ContactTypeCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getContactTypeName() {
        return contactTypeName;
    }

    public void setContactTypeName(StringFilter contactTypeName) {
        this.contactTypeName = contactTypeName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ContactTypeCriteria that = (ContactTypeCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(contactTypeName, that.contactTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        contactTypeName
        );
    }

    @Override
    public String toString() {
        return "ContactTypeCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (contactTypeName != null ? "contactTypeName=" + contactTypeName + ", " : "") +
            "}";
    }

}
