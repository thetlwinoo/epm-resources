package com.epmresources.server.service.impl;

import com.epmresources.server.domain.ShoppingCartItems;
import com.epmresources.server.domain.ShoppingCarts;
import com.epmresources.server.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
@Transactional
public class PriceServiceImpl implements PriceService {

    private final Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);

    @Override
    public ShoppingCarts calculatePrice(ShoppingCarts cart) {

        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal totalCargoPrice = BigDecimal.ZERO;

        for (ShoppingCartItems i : cart.getCartItemLists()) {
            System.out.println("amount " + i.getQuantity());
            totalPrice = ((i.getStockItem().getUnitPrice().add(i.getStockItem().getRecommendedRetailPrice())).multiply(BigDecimal.valueOf(i.getQuantity()))).add(totalCargoPrice).add(totalPrice);
            totalCargoPrice = (i.getStockItem().getRecommendedRetailPrice().multiply(BigDecimal.valueOf(i.getQuantity())));
        }

        //Applying discount percent if exists
        if (cart.getSpecialDeals() != null) {
            totalPrice = totalPrice.subtract((totalPrice.multiply(cart.getSpecialDeals().getDiscountPercentage())).divide(BigDecimal.valueOf(100)));
        }

        cart.setTotalPrice(totalPrice.setScale(2, RoundingMode.CEILING));
        cart.setTotalCargoPrice(totalCargoPrice.setScale(2,RoundingMode.CEILING));
        return cart;
    }
}
