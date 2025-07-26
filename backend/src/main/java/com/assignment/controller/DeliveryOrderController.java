package com.assignment.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.assignment.Dto.DeliveryOrderDto;
import com.assignment.entity.DeliveryOrder;
import com.assignment.service.DeliveryOrderService;

@RestController
@RequestMapping("/delivery-orders")
public class DeliveryOrderController {

    @Autowired
    private DeliveryOrderService deliveryOrderService;

    @PostMapping
    public DeliveryOrderDto createDeliveryOrder(@RequestBody DeliveryOrder deliveryOrder) {
        return deliveryOrderService.createDeliveryOrder(deliveryOrder);
    }

    @GetMapping
    public List<DeliveryOrderDto> getAllDeliveryOrders() {
        return deliveryOrderService.getAllDeliveryOrders();
    }

    @GetMapping("/{id}")
    public DeliveryOrderDto getDeliveryOrderById(@PathVariable String id) {
        return deliveryOrderService.getDeliveryOrderById(id);
    }

    @PutMapping("/{id}")
    public DeliveryOrderDto updateDeliveryOrderById(
            @PathVariable String id,
            @RequestBody DeliveryOrder updatedOrder) {
        return deliveryOrderService.updateDeliveryOrderById(id, updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteDeliveryOrder(@PathVariable String id) {
        deliveryOrderService.deleteDeliveryOrder(id);
    }

    @GetMapping("/filter")
    public List<DeliveryOrderDto> getOrdersByVendorAndDate(
            @RequestParam String vendorName,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return deliveryOrderService.getOrdersByVendorAndDate(vendorName, date);
    }
}
