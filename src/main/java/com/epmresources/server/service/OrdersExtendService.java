package com.epmresources.server.service;

import com.epmresources.server.service.dto.OrdersDTO;

import java.security.Principal;

public interface OrdersExtendService {
    Integer getAllOrdersCount(Principal principal);

    OrdersDTO postOrder(Principal principal, OrdersDTO ordersDTO);
}
