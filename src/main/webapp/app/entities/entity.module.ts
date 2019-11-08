import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'address-types',
        loadChildren: () => import('./address-types/address-types.module').then(m => m.EpmresourcesAddressTypesModule)
      },
      {
        path: 'culture',
        loadChildren: () => import('./culture/culture.module').then(m => m.EpmresourcesCultureModule)
      },
      {
        path: 'addresses',
        loadChildren: () => import('./addresses/addresses.module').then(m => m.EpmresourcesAddressesModule)
      },
      {
        path: 'business-entity-address',
        loadChildren: () =>
          import('./business-entity-address/business-entity-address.module').then(m => m.EpmresourcesBusinessEntityAddressModule)
      },
      {
        path: 'ship-method',
        loadChildren: () => import('./ship-method/ship-method.module').then(m => m.EpmresourcesShipMethodModule)
      },
      {
        path: 'person-email-address',
        loadChildren: () => import('./person-email-address/person-email-address.module').then(m => m.EpmresourcesPersonEmailAddressModule)
      },
      {
        path: 'person-phone',
        loadChildren: () => import('./person-phone/person-phone.module').then(m => m.EpmresourcesPersonPhoneModule)
      },
      {
        path: 'phone-number-type',
        loadChildren: () => import('./phone-number-type/phone-number-type.module').then(m => m.EpmresourcesPhoneNumberTypeModule)
      },
      {
        path: 'contact-type',
        loadChildren: () => import('./contact-type/contact-type.module').then(m => m.EpmresourcesContactTypeModule)
      },
      {
        path: 'business-entity-contact',
        loadChildren: () =>
          import('./business-entity-contact/business-entity-contact.module').then(m => m.EpmresourcesBusinessEntityContactModule)
      },
      {
        path: 'countries',
        loadChildren: () => import('./countries/countries.module').then(m => m.EpmresourcesCountriesModule)
      },
      {
        path: 'state-provinces',
        loadChildren: () => import('./state-provinces/state-provinces.module').then(m => m.EpmresourcesStateProvincesModule)
      },
      {
        path: 'cities',
        loadChildren: () => import('./cities/cities.module').then(m => m.EpmresourcesCitiesModule)
      },
      {
        path: 'system-parameters',
        loadChildren: () => import('./system-parameters/system-parameters.module').then(m => m.EpmresourcesSystemParametersModule)
      },
      {
        path: 'transaction-types',
        loadChildren: () => import('./transaction-types/transaction-types.module').then(m => m.EpmresourcesTransactionTypesModule)
      },
      {
        path: 'people',
        loadChildren: () => import('./people/people.module').then(m => m.EpmresourcesPeopleModule)
      },
      {
        path: 'delivery-methods',
        loadChildren: () => import('./delivery-methods/delivery-methods.module').then(m => m.EpmresourcesDeliveryMethodsModule)
      },
      {
        path: 'supplier-categories',
        loadChildren: () => import('./supplier-categories/supplier-categories.module').then(m => m.EpmresourcesSupplierCategoriesModule)
      },
      {
        path: 'suppliers',
        loadChildren: () => import('./suppliers/suppliers.module').then(m => m.EpmresourcesSuppliersModule)
      },
      {
        path: 'supplier-transactions',
        loadChildren: () =>
          import('./supplier-transactions/supplier-transactions.module').then(m => m.EpmresourcesSupplierTransactionsModule)
      },
      {
        path: 'currency-rate',
        loadChildren: () => import('./currency-rate/currency-rate.module').then(m => m.EpmresourcesCurrencyRateModule)
      },
      {
        path: 'purchase-orders',
        loadChildren: () => import('./purchase-orders/purchase-orders.module').then(m => m.EpmresourcesPurchaseOrdersModule)
      },
      {
        path: 'purchase-order-lines',
        loadChildren: () => import('./purchase-order-lines/purchase-order-lines.module').then(m => m.EpmresourcesPurchaseOrderLinesModule)
      },
      {
        path: 'buying-groups',
        loadChildren: () => import('./buying-groups/buying-groups.module').then(m => m.EpmresourcesBuyingGroupsModule)
      },
      {
        path: 'customer-categories',
        loadChildren: () => import('./customer-categories/customer-categories.module').then(m => m.EpmresourcesCustomerCategoriesModule)
      },
      {
        path: 'customers',
        loadChildren: () => import('./customers/customers.module').then(m => m.EpmresourcesCustomersModule)
      },
      {
        path: 'customer-transactions',
        loadChildren: () =>
          import('./customer-transactions/customer-transactions.module').then(m => m.EpmresourcesCustomerTransactionsModule)
      },
      {
        path: 'payment-transactions',
        loadChildren: () => import('./payment-transactions/payment-transactions.module').then(m => m.EpmresourcesPaymentTransactionsModule)
      },
      {
        path: 'invoice-lines',
        loadChildren: () => import('./invoice-lines/invoice-lines.module').then(m => m.EpmresourcesInvoiceLinesModule)
      },
      {
        path: 'invoices',
        loadChildren: () => import('./invoices/invoices.module').then(m => m.EpmresourcesInvoicesModule)
      },
      {
        path: 'order-lines',
        loadChildren: () => import('./order-lines/order-lines.module').then(m => m.EpmresourcesOrderLinesModule)
      },
      {
        path: 'orders',
        loadChildren: () => import('./orders/orders.module').then(m => m.EpmresourcesOrdersModule)
      },
      {
        path: 'special-deals',
        loadChildren: () => import('./special-deals/special-deals.module').then(m => m.EpmresourcesSpecialDealsModule)
      },
      {
        path: 'cold-room-temperatures',
        loadChildren: () =>
          import('./cold-room-temperatures/cold-room-temperatures.module').then(m => m.EpmresourcesColdRoomTemperaturesModule)
      },
      {
        path: 'package-types',
        loadChildren: () => import('./package-types/package-types.module').then(m => m.EpmresourcesPackageTypesModule)
      },
      {
        path: 'products',
        loadChildren: () => import('./products/products.module').then(m => m.EpmresourcesProductsModule)
      },
      {
        path: 'barcode-types',
        loadChildren: () => import('./barcode-types/barcode-types.module').then(m => m.EpmresourcesBarcodeTypesModule)
      },
      {
        path: 'stock-items',
        loadChildren: () => import('./stock-items/stock-items.module').then(m => m.EpmresourcesStockItemsModule)
      },
      {
        path: 'stock-item-temp',
        loadChildren: () => import('./stock-item-temp/stock-item-temp.module').then(m => m.EpmresourcesStockItemTempModule)
      },
      {
        path: 'upload-transactions',
        loadChildren: () => import('./upload-transactions/upload-transactions.module').then(m => m.EpmresourcesUploadTransactionsModule)
      },
      {
        path: 'upload-action-types',
        loadChildren: () => import('./upload-action-types/upload-action-types.module').then(m => m.EpmresourcesUploadActionTypesModule)
      },
      {
        path: 'stock-item-transactions',
        loadChildren: () =>
          import('./stock-item-transactions/stock-item-transactions.module').then(m => m.EpmresourcesStockItemTransactionsModule)
      },
      {
        path: 'stock-item-holdings',
        loadChildren: () => import('./stock-item-holdings/stock-item-holdings.module').then(m => m.EpmresourcesStockItemHoldingsModule)
      },
      {
        path: 'warranty-types',
        loadChildren: () => import('./warranty-types/warranty-types.module').then(m => m.EpmresourcesWarrantyTypesModule)
      },
      {
        path: 'product-attribute',
        loadChildren: () => import('./product-attribute/product-attribute.module').then(m => m.EpmresourcesProductAttributeModule)
      },
      {
        path: 'product-attribute-set',
        loadChildren: () =>
          import('./product-attribute-set/product-attribute-set.module').then(m => m.EpmresourcesProductAttributeSetModule)
      },
      {
        path: 'product-option',
        loadChildren: () => import('./product-option/product-option.module').then(m => m.EpmresourcesProductOptionModule)
      },
      {
        path: 'product-option-set',
        loadChildren: () => import('./product-option-set/product-option-set.module').then(m => m.EpmresourcesProductOptionSetModule)
      },
      {
        path: 'product-choice',
        loadChildren: () => import('./product-choice/product-choice.module').then(m => m.EpmresourcesProductChoiceModule)
      },
      {
        path: 'product-set',
        loadChildren: () => import('./product-set/product-set.module').then(m => m.EpmresourcesProductSetModule)
      },
      {
        path: 'product-set-details',
        loadChildren: () => import('./product-set-details/product-set-details.module').then(m => m.EpmresourcesProductSetDetailsModule)
      },
      {
        path: 'product-document',
        loadChildren: () => import('./product-document/product-document.module').then(m => m.EpmresourcesProductDocumentModule)
      },
      {
        path: 'materials',
        loadChildren: () => import('./materials/materials.module').then(m => m.EpmresourcesMaterialsModule)
      },
      {
        path: 'dangerous-goods',
        loadChildren: () => import('./dangerous-goods/dangerous-goods.module').then(m => m.EpmresourcesDangerousGoodsModule)
      },
      {
        path: 'product-brand',
        loadChildren: () => import('./product-brand/product-brand.module').then(m => m.EpmresourcesProductBrandModule)
      },
      {
        path: 'product-category',
        loadChildren: () => import('./product-category/product-category.module').then(m => m.EpmresourcesProductCategoryModule)
      },
      {
        path: 'product-catalog',
        loadChildren: () => import('./product-catalog/product-catalog.module').then(m => m.EpmresourcesProductCatalogModule)
      },
      {
        path: 'currency',
        loadChildren: () => import('./currency/currency.module').then(m => m.EpmresourcesCurrencyModule)
      },
      {
        path: 'photos',
        loadChildren: () => import('./photos/photos.module').then(m => m.EpmresourcesPhotosModule)
      },
      {
        path: 'unit-measure',
        loadChildren: () => import('./unit-measure/unit-measure.module').then(m => m.EpmresourcesUnitMeasureModule)
      },
      {
        path: 'vehicle-temperatures',
        loadChildren: () => import('./vehicle-temperatures/vehicle-temperatures.module').then(m => m.EpmresourcesVehicleTemperaturesModule)
      },
      {
        path: 'shopping-carts',
        loadChildren: () => import('./shopping-carts/shopping-carts.module').then(m => m.EpmresourcesShoppingCartsModule)
      },
      {
        path: 'shopping-cart-items',
        loadChildren: () => import('./shopping-cart-items/shopping-cart-items.module').then(m => m.EpmresourcesShoppingCartItemsModule)
      },
      {
        path: 'wishlists',
        loadChildren: () => import('./wishlists/wishlists.module').then(m => m.EpmresourcesWishlistsModule)
      },
      {
        path: 'wishlist-products',
        loadChildren: () => import('./wishlist-products/wishlist-products.module').then(m => m.EpmresourcesWishlistProductsModule)
      },
      {
        path: 'compares',
        loadChildren: () => import('./compares/compares.module').then(m => m.EpmresourcesComparesModule)
      },
      {
        path: 'compare-products',
        loadChildren: () => import('./compare-products/compare-products.module').then(m => m.EpmresourcesCompareProductsModule)
      },
      {
        path: 'reviews',
        loadChildren: () => import('./reviews/reviews.module').then(m => m.EpmresourcesReviewsModule)
      },
      {
        path: 'review-lines',
        loadChildren: () => import('./review-lines/review-lines.module').then(m => m.EpmresourcesReviewLinesModule)
      },
      {
        path: 'product-tags',
        loadChildren: () => import('./product-tags/product-tags.module').then(m => m.EpmresourcesProductTagsModule)
      },
      {
        path: 'supplier-imported-document',
        loadChildren: () =>
          import('./supplier-imported-document/supplier-imported-document.module').then(m => m.EpmresourcesSupplierImportedDocumentModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class EpmresourcesEntityModule {}
