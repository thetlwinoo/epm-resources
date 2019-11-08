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
 * Criteria class for the {@link com.epmresources.server.domain.CompareProducts} entity. This class is used
 * in {@link com.epmresources.server.web.rest.CompareProductsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /compare-products?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CompareProductsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter productId;

    private LongFilter compareId;

    public CompareProductsCriteria(){
    }

    public CompareProductsCriteria(CompareProductsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.productId = other.productId == null ? null : other.productId.copy();
        this.compareId = other.compareId == null ? null : other.compareId.copy();
    }

    @Override
    public CompareProductsCriteria copy() {
        return new CompareProductsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LongFilter getProductId() {
        return productId;
    }

    public void setProductId(LongFilter productId) {
        this.productId = productId;
    }

    public LongFilter getCompareId() {
        return compareId;
    }

    public void setCompareId(LongFilter compareId) {
        this.compareId = compareId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CompareProductsCriteria that = (CompareProductsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(productId, that.productId) &&
            Objects.equals(compareId, that.compareId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        productId,
        compareId
        );
    }

    @Override
    public String toString() {
        return "CompareProductsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (productId != null ? "productId=" + productId + ", " : "") +
                (compareId != null ? "compareId=" + compareId + ", " : "") +
            "}";
    }

}
