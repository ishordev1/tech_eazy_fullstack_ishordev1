package com.assignment.service;

import java.util.Date;
import java.util.List;

import com.assignment.Dto.DeliveryOrderDto;
import com.assignment.entity.DeliveryOrder;

public interface DeliveryOrderService {
	  DeliveryOrderDto createDeliveryOrder(DeliveryOrder deliveryOrder);
	    List<DeliveryOrderDto> getAllDeliveryOrders();
	    DeliveryOrderDto getDeliveryOrderById(String id);
	    DeliveryOrderDto updateDeliveryOrderById(String id,DeliveryOrder deleveryOrder);
	    void deleteDeliveryOrder(String id);
	    List<DeliveryOrderDto> getOrdersByVendorAndDate(String vendorName, Date date);  
}
