package com.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entity.DeliveryOrder;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, String> {

}
