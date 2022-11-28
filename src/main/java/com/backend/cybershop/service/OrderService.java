package com.backend.cybershop.service;

	import java.util.Date;
	import java.util.List;
	import java.util.stream.Collectors;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

	import com.backend.cybershop.dto.OrderRegisterDTO;
	import com.backend.cybershop.entity.Order;
	import com.backend.cybershop.entity.OrderDetail;
	import com.backend.cybershop.entity.Payment;
	import com.backend.cybershop.entity.Product;
	import com.backend.cybershop.entity.Shoop;
	import com.backend.cybershop.entity.User;
	import com.backend.cybershop.repository.OrderDAO;
	import com.backend.cybershop.repository.OrderDetailDAO;
	import com.backend.cybershop.service.interfaces.IOrderService;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderDAO orderRepo;
	@Autowired
	private OrderDetailDAO detailDAO;
	
	@Transactional
	@Override
	public Order saveOrder(OrderRegisterDTO bean) {
		Order order = new Order();
		
		order.setFinalAmount(bean.getFinalAmount());
		order.setPayment(new Payment(bean.getPaymentId()));
		order.setShoop(new Shoop(bean.getShoopId()));
		order.setUser(new User(bean.getUserId()));
		order.setOrderState("A");
		order.setOrderDate(new Date());
		
		Order orderSaved = orderRepo.save(order);
		
		List<OrderDetail> data = bean.getDetails().stream()
				.map((detail) -> new OrderDetail(new Order(orderSaved.getOrderId()),
						new Product(detail.getProductId()), detail.getQuantity(), detail.getPrice()))
				.collect(Collectors.toList());
		
		List<OrderDetail> response = detailDAO.saveAll(data);
		
		Order lastOrder = orderRepo.findById(orderSaved.getOrderId()).orElse(null);
		
		return lastOrder;
	}

}