package com.stockie.serviceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stockie.bean.CustomerBean;
import com.stockie.bean.OrderBean;
import com.stockie.bean.OrderItemBean;
import com.stockie.bean.ProductBean;
import com.stockie.dao.OrderDao;
import com.stockie.model.Order;
import com.stockie.model.OrderItem;
import com.stockie.service.CustomerService;
import com.stockie.service.OrderService;
import com.stockie.service.ProductService;
import com.stockie.util.DateUtil;

@Service("orderService")
@Transactional(propagation = Propagation.SUPPORTS)
public class OrderServiceImpl implements OrderService {

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;

	@Autowired
	OrderDao orderDao;

	@Override
	public void addOrder(OrderBean orderBean) {
		Order order = prepareOrderModel(orderBean);
		this.orderDao.addOrder(order);
		orderBean.setOrderId(order.getOrderId());
		// logger.info("OrderId " + orderBean.getOrderId());
	}

	@Override
	public List<OrderBean> listOrders() {
		return prepareOrdListBean(orderDao.listOrders());
	}

	@Override
	public OrderBean getOrder(Long orderId) {
		return prepareOrderBean(orderDao.getOrder(orderId));
	}

	@Override
	public void deleteOrder(Long orderId) {
		orderDao.deleteOrder(orderId);
	}

	private List<OrderBean> prepareOrdListBean(List<Order> orders) {
		List<OrderBean> beans = null;
		if (orders != null && !orders.isEmpty()) {
			beans = new ArrayList<OrderBean>();
			for (Order order : orders) {
				beans.add(prepareOrderBean(order));
			}
		}
		return beans;
	}

	private Order prepareOrderModel(OrderBean orderBean) {
		Order order = new Order();
		order.setOrderId(orderBean.getOrderId());

		CustomerBean customerBean = customerService.getCustomer(orderBean.getCustomerId());
		order.setCustomer(customerService.prepareModel(customerBean));
		customerBean.setCustId(orderBean.getCustomerId());

		order.setOrderDate(orderBean.getOrderDate());
		order.setDiscount(orderBean.getDiscount());
		order.setSubTotal(orderBean.getSubTotal());
		order.setStatus(orderBean.getStatus());
		order.setTax(orderBean.getTax());
		order.setOldBalance(orderBean.getOldBalance());
		order.setNetAmount(orderBean.getNetAmount());
		order.setOrderItems(prepareOrdItemListModel(orderBean.getOrderItems()));

		return order;
	}

	private List<OrderItem> prepareOrdItemListModel(List<OrderItemBean> orderItems) {
		List<OrderItem> items = null;
		if (((orderItems != null ? 1 : 0) & (orderItems.isEmpty() ? 0 : 1)) != 0) {
			items = new ArrayList();
			for (OrderItemBean orderItemBean : orderItems) {
				if (orderItemBean.getProductId() != null) {
					items.add(prepareOrderItemModel(orderItemBean));
				}
			}
		}
		return items;
	}

	private OrderItem prepareOrderItemModel(OrderItemBean orderItemBean) {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(orderItemBean.getId());
		// orderItem.setOrder(prepareOrderModel(orderItemBean.getOrderBean()));

		ProductBean productBean = productService.getProduct(orderItemBean.getProductId());
		productBean.setProdId(orderItemBean.getProductId());
		orderItem.setProduct(productService.prepareModel(productBean));
		orderItem.setQuantity(orderItemBean.getQuantity());
		orderItemBean.setAmount(Float.valueOf(
				(float) orderItemBean.getQuantity().longValue() * Float.parseFloat(orderItemBean.getUnitCost())));
		orderItem.setAmount(orderItemBean.getAmount());
		return orderItem;
	}

	private List<OrderItemBean> prepareOrdItemListBean(List<OrderItem> list) {
		List<OrderItemBean> beans = null;
		if (list != null && !list.isEmpty()) {
			beans = new ArrayList<OrderItemBean>();
			for (OrderItem orderItem : list) {
				beans.add(prepareOrderItemBean(orderItem));
			}
		}
		return beans;
	}

	private OrderBean prepareOrderBean(Order order) {
		OrderBean orderBean = new OrderBean();
		orderBean.setOrderId(order.getOrderId());
		String formattedDate = order.getOrderDate();
		try {
			formattedDate = DateUtil.getFormattedDate(formattedDate);
		} catch (ParseException e) {
			e.printStackTrace();
			formattedDate = order.getOrderDate();
		}
		orderBean.setOrderDate(formattedDate);
		orderBean.setCustomerBean(this.customerService.prepareBean(order.getCustomer()));
		orderBean.setCustomerId(order.getCustomer().getCustId());
		orderBean.setTax(order.getTax());
		orderBean.setDiscount(order.getDiscount());
		orderBean.setSubTotal(order.getSubTotal());
		orderBean.setStatus(order.getStatus());
		orderBean.setOldBalance(order.getOldBalance());
		orderBean.setNetAmount(order.getNetAmount());
		orderBean.setOrderItems(prepareOrdItemListBean(order.getOrderItems()));
		return orderBean;
	}

	private OrderItemBean prepareOrderItemBean(OrderItem orderItem) {
		OrderItemBean bean = new OrderItemBean();
		bean.setId(orderItem.getId());
		// bean.setOrderBean(prepareOrderBean(orderItem.getOrder()));
		bean.setProductBean(productService.prepareBean(orderItem.getProduct()));
		bean.setQuantity(orderItem.getQuantity());
		bean.setAmount(orderItem.getAmount());
		return bean;
	}

}
