package com.epmresources.server.config;

import java.time.Duration;

import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import org.hibernate.cache.jcache.ConfigSettings;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, com.epmresources.server.repository.UserRepository.USERS_BY_LOGIN_CACHE);
            createCache(cm, com.epmresources.server.repository.UserRepository.USERS_BY_EMAIL_CACHE);
            createCache(cm, com.epmresources.server.domain.User.class.getName());
            createCache(cm, com.epmresources.server.domain.Authority.class.getName());
            createCache(cm, com.epmresources.server.domain.User.class.getName() + ".authorities");
            createCache(cm, com.epmresources.server.domain.AddressTypes.class.getName());
            createCache(cm, com.epmresources.server.domain.Culture.class.getName());
            createCache(cm, com.epmresources.server.domain.Addresses.class.getName());
            createCache(cm, com.epmresources.server.domain.BusinessEntityAddress.class.getName());
            createCache(cm, com.epmresources.server.domain.ShipMethod.class.getName());
            createCache(cm, com.epmresources.server.domain.PersonEmailAddress.class.getName());
            createCache(cm, com.epmresources.server.domain.PersonPhone.class.getName());
            createCache(cm, com.epmresources.server.domain.PhoneNumberType.class.getName());
            createCache(cm, com.epmresources.server.domain.ContactType.class.getName());
            createCache(cm, com.epmresources.server.domain.BusinessEntityContact.class.getName());
            createCache(cm, com.epmresources.server.domain.Countries.class.getName());
            createCache(cm, com.epmresources.server.domain.StateProvinces.class.getName());
            createCache(cm, com.epmresources.server.domain.Cities.class.getName());
            createCache(cm, com.epmresources.server.domain.SystemParameters.class.getName());
            createCache(cm, com.epmresources.server.domain.TransactionTypes.class.getName());
            createCache(cm, com.epmresources.server.domain.People.class.getName());
            createCache(cm, com.epmresources.server.domain.DeliveryMethods.class.getName());
            createCache(cm, com.epmresources.server.domain.SupplierCategories.class.getName());
            createCache(cm, com.epmresources.server.domain.Suppliers.class.getName());
            createCache(cm, com.epmresources.server.domain.SupplierTransactions.class.getName());
            createCache(cm, com.epmresources.server.domain.CurrencyRate.class.getName());
            createCache(cm, com.epmresources.server.domain.PurchaseOrders.class.getName());
            createCache(cm, com.epmresources.server.domain.PurchaseOrders.class.getName() + ".purchaseOrderLineLists");
            createCache(cm, com.epmresources.server.domain.PurchaseOrderLines.class.getName());
            createCache(cm, com.epmresources.server.domain.BuyingGroups.class.getName());
            createCache(cm, com.epmresources.server.domain.CustomerCategories.class.getName());
            createCache(cm, com.epmresources.server.domain.Customers.class.getName());
            createCache(cm, com.epmresources.server.domain.CustomerTransactions.class.getName());
            createCache(cm, com.epmresources.server.domain.PaymentTransactions.class.getName());
            createCache(cm, com.epmresources.server.domain.InvoiceLines.class.getName());
            createCache(cm, com.epmresources.server.domain.Invoices.class.getName());
            createCache(cm, com.epmresources.server.domain.Invoices.class.getName() + ".invoiceLineLists");
            createCache(cm, com.epmresources.server.domain.OrderLines.class.getName());
            createCache(cm, com.epmresources.server.domain.Orders.class.getName());
            createCache(cm, com.epmresources.server.domain.Orders.class.getName() + ".orderLineLists");
            createCache(cm, com.epmresources.server.domain.SpecialDeals.class.getName());
            createCache(cm, com.epmresources.server.domain.SpecialDeals.class.getName() + ".cartDiscounts");
            createCache(cm, com.epmresources.server.domain.SpecialDeals.class.getName() + ".orderDiscounts");
            createCache(cm, com.epmresources.server.domain.ColdRoomTemperatures.class.getName());
            createCache(cm, com.epmresources.server.domain.PackageTypes.class.getName());
            createCache(cm, com.epmresources.server.domain.Products.class.getName());
            createCache(cm, com.epmresources.server.domain.Products.class.getName() + ".stockItemLists");
            createCache(cm, com.epmresources.server.domain.BarcodeTypes.class.getName());
            createCache(cm, com.epmresources.server.domain.StockItems.class.getName());
            createCache(cm, com.epmresources.server.domain.StockItems.class.getName() + ".photoLists");
            createCache(cm, com.epmresources.server.domain.StockItems.class.getName() + ".dangerousGoodLists");
            createCache(cm, com.epmresources.server.domain.StockItems.class.getName() + ".specialDiscounts");
            createCache(cm, com.epmresources.server.domain.StockItemTemp.class.getName());
            createCache(cm, com.epmresources.server.domain.UploadTransactions.class.getName());
            createCache(cm, com.epmresources.server.domain.UploadTransactions.class.getName() + ".importDocumentLists");
            createCache(cm, com.epmresources.server.domain.UploadTransactions.class.getName() + ".stockItemTempLists");
            createCache(cm, com.epmresources.server.domain.UploadActionTypes.class.getName());
            createCache(cm, com.epmresources.server.domain.StockItemTransactions.class.getName());
            createCache(cm, com.epmresources.server.domain.StockItemHoldings.class.getName());
            createCache(cm, com.epmresources.server.domain.WarrantyTypes.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductAttribute.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductAttributeSet.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductOption.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductOptionSet.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductChoice.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductSet.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductSetDetails.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductDocument.class.getName());
            createCache(cm, com.epmresources.server.domain.Materials.class.getName());
            createCache(cm, com.epmresources.server.domain.DangerousGoods.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductBrand.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductCategory.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductCatalog.class.getName());
            createCache(cm, com.epmresources.server.domain.Currency.class.getName());
            createCache(cm, com.epmresources.server.domain.Photos.class.getName());
            createCache(cm, com.epmresources.server.domain.UnitMeasure.class.getName());
            createCache(cm, com.epmresources.server.domain.VehicleTemperatures.class.getName());
            createCache(cm, com.epmresources.server.domain.ShoppingCarts.class.getName());
            createCache(cm, com.epmresources.server.domain.ShoppingCarts.class.getName() + ".cartItemLists");
            createCache(cm, com.epmresources.server.domain.ShoppingCartItems.class.getName());
            createCache(cm, com.epmresources.server.domain.Wishlists.class.getName());
            createCache(cm, com.epmresources.server.domain.Wishlists.class.getName() + ".wishlistLists");
            createCache(cm, com.epmresources.server.domain.WishlistProducts.class.getName());
            createCache(cm, com.epmresources.server.domain.Compares.class.getName());
            createCache(cm, com.epmresources.server.domain.Compares.class.getName() + ".compareLists");
            createCache(cm, com.epmresources.server.domain.CompareProducts.class.getName());
            createCache(cm, com.epmresources.server.domain.Reviews.class.getName());
            createCache(cm, com.epmresources.server.domain.Reviews.class.getName() + ".reviewLineLists");
            createCache(cm, com.epmresources.server.domain.ReviewLines.class.getName());
            createCache(cm, com.epmresources.server.domain.ProductTags.class.getName());
            createCache(cm, com.epmresources.server.domain.SupplierImportedDocument.class.getName());
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache != null) {
            cm.destroyCache(cacheName);
        }
        cm.createCache(cacheName, jcacheConfiguration);
    }

}
