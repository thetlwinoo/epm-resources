package com.epmresources.server.service;

import com.epmresources.server.domain.ShoppingCarts;

public interface PriceService {
    ShoppingCarts calculatePrice(ShoppingCarts cart);
}
