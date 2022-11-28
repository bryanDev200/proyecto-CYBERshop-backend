package com.backend.cybershop.service.interfaces;

import com.backend.cybershop.dto.OrderRegisterDTO;
import com.backend.cybershop.entity.Order;

public interface IOrderService {
	public Order saveOrder(OrderRegisterDTO bean);
}