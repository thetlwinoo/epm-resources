package com.epmresources.server.service.dto;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.epmresources.server.domain.PurchaseOrderLines} entity.
 */
public class PurchaseOrderLinesDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer ordersOuters;

    private String description;

    private Integer receivedOuters;

    private BigDecimal expectedUnitPricePerOuter;

    private Instant lastReceiptDate;

    private Boolean isOrderLineFinalized;

    private String lastEditedBy;

    private Instant lastEditedWhen;


    private Long packageTypeId;

    private String packageTypePackageTypeName;

    private Long stockItemId;

    private String stockItemStockItemName;

    private Long purchaseOrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrdersOuters() {
        return ordersOuters;
    }

    public void setOrdersOuters(Integer ordersOuters) {
        this.ordersOuters = ordersOuters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReceivedOuters() {
        return receivedOuters;
    }

    public void setReceivedOuters(Integer receivedOuters) {
        this.receivedOuters = receivedOuters;
    }

    public BigDecimal getExpectedUnitPricePerOuter() {
        return expectedUnitPricePerOuter;
    }

    public void setExpectedUnitPricePerOuter(BigDecimal expectedUnitPricePerOuter) {
        this.expectedUnitPricePerOuter = expectedUnitPricePerOuter;
    }

    public Instant getLastReceiptDate() {
        return lastReceiptDate;
    }

    public void setLastReceiptDate(Instant lastReceiptDate) {
        this.lastReceiptDate = lastReceiptDate;
    }

    public Boolean isIsOrderLineFinalized() {
        return isOrderLineFinalized;
    }

    public void setIsOrderLineFinalized(Boolean isOrderLineFinalized) {
        this.isOrderLineFinalized = isOrderLineFinalized;
    }

    public String getLastEditedBy() {
        return lastEditedBy;
    }

    public void setLastEditedBy(String lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
    }

    public Instant getLastEditedWhen() {
        return lastEditedWhen;
    }

    public void setLastEditedWhen(Instant lastEditedWhen) {
        this.lastEditedWhen = lastEditedWhen;
    }

    public Long getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(Long packageTypesId) {
        this.packageTypeId = packageTypesId;
    }

    public String getPackageTypePackageTypeName() {
        return packageTypePackageTypeName;
    }

    public void setPackageTypePackageTypeName(String packageTypesPackageTypeName) {
        this.packageTypePackageTypeName = packageTypesPackageTypeName;
    }

    public Long getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Long stockItemsId) {
        this.stockItemId = stockItemsId;
    }

    public String getStockItemStockItemName() {
        return stockItemStockItemName;
    }

    public void setStockItemStockItemName(String stockItemsStockItemName) {
        this.stockItemStockItemName = stockItemsStockItemName;
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrdersId) {
        this.purchaseOrderId = purchaseOrdersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PurchaseOrderLinesDTO purchaseOrderLinesDTO = (PurchaseOrderLinesDTO) o;
        if (purchaseOrderLinesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), purchaseOrderLinesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PurchaseOrderLinesDTO{" +
            "id=" + getId() +
            ", ordersOuters=" + getOrdersOuters() +
            ", description='" + getDescription() + "'" +
            ", receivedOuters=" + getReceivedOuters() +
            ", expectedUnitPricePerOuter=" + getExpectedUnitPricePerOuter() +
            ", lastReceiptDate='" + getLastReceiptDate() + "'" +
            ", isOrderLineFinalized='" + isIsOrderLineFinalized() + "'" +
            ", lastEditedBy='" + getLastEditedBy() + "'" +
            ", lastEditedWhen='" + getLastEditedWhen() + "'" +
            ", packageType=" + getPackageTypeId() +
            ", packageType='" + getPackageTypePackageTypeName() + "'" +
            ", stockItem=" + getStockItemId() +
            ", stockItem='" + getStockItemStockItemName() + "'" +
            ", purchaseOrder=" + getPurchaseOrderId() +
            "}";
    }
}
