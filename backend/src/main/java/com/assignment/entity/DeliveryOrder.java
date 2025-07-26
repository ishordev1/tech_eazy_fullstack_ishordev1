package com.assignment.entity;

import java.util.Date;
import java.util.List;

import com.assignment.Enum.Subscription;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
private String id;
private String vendorName;
private Date deleverDate;
private Subscription subscription;

@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
@JoinColumn(name = "delivery_order_id")
private List<Parcel> parcels;
}
