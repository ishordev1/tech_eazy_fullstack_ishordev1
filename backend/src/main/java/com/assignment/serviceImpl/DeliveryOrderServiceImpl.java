package com.assignment.serviceImpl;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Dto.DeliveryOrderDto;
import com.assignment.Repository.DeliveryOrderRepository;
import com.assignment.entity.DeliveryOrder;
import com.assignment.service.DeliveryOrderService;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

    @Autowired
    private DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DeliveryOrderDto createDeliveryOrder(DeliveryOrder deliveryOrder) {
        DeliveryOrder savedOrder = deliveryOrderRepository.save(deliveryOrder);
        return modelMapper.map(savedOrder, DeliveryOrderDto.class);
    }

    @Override
    public List<DeliveryOrderDto> getAllDeliveryOrders() {
        return deliveryOrderRepository.findAll()
                .stream()
                .map(order -> modelMapper.map(order, DeliveryOrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryOrderDto getDeliveryOrderById(String id) {
        DeliveryOrder order = deliveryOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery Order not found with id: " + id));
        return modelMapper.map(order, DeliveryOrderDto.class);
    }

    @Override
    public DeliveryOrderDto updateDeliveryOrderById(String id, DeliveryOrder updatedOrder) {
        DeliveryOrder existingOrder = deliveryOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery Order not found with id: " + id));

        existingOrder.setVendorName(updatedOrder.getVendorName());
        existingOrder.setDeleverDate(updatedOrder.getDeleverDate());
        existingOrder.setSubscription(updatedOrder.getSubscription());
        existingOrder.setParcels(updatedOrder.getParcels());

        DeliveryOrder savedOrder = deliveryOrderRepository.save(existingOrder);
        return modelMapper.map(savedOrder, DeliveryOrderDto.class);
    }

    @Override
    public void deleteDeliveryOrder(String id) {
        deliveryOrderRepository.deleteById(id);
    }

    @Override
    public List<DeliveryOrderDto> getOrdersByVendorAndDate(String vendorName, Date date) {
        return deliveryOrderRepository.findAll()
                .stream()
                .filter(order -> order.getVendorName().equalsIgnoreCase(vendorName)
                        && removeTime(order.getDeleverDate()).equals(removeTime(date)))
                .map(order -> modelMapper.map(order, DeliveryOrderDto.class))
                .collect(Collectors.toList());
    }

    private Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
