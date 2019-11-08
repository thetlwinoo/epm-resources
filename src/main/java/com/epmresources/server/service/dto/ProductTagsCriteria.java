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
 * Criteria class for the {@link com.epmresources.server.domain.ProductTags} entity. This class is used
 * in {@link com.epmresources.server.web.rest.ProductTagsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /product-tags?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ProductTagsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter tagName;

    private LongFilter productId;

    public ProductTagsCriteria(){
    }

    public ProductTagsCriteria(ProductTagsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.tagName = other.tagName == null ? null : other.tagName.copy();
        this.productId = other.productId == null ? null : other.productId.copy();
    }

    @Override
    public ProductTagsCriteria copy() {
        return new ProductTagsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getTagName() {
        return tagName;
    }

    public void setTagName(StringFilter tagName) {
        this.tagName = tagName;
    }

    public LongFilter getProductId() {
        return productId;
    }

    public void setProductId(LongFilter productId) {
        this.productId = productId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProductTagsCriteria that = (ProductTagsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(tagName, that.tagName) &&
            Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        tagName,
        productId
        );
    }

    @Override
    public String toString() {
        return "ProductTagsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (tagName != null ? "tagName=" + tagName + ", " : "") +
                (productId != null ? "productId=" + productId + ", " : "") +
            "}";
    }

}
