package com.assignment.Dto;

import java.util.Date;
import java.util.List;

import com.assignment.Enum.Subscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrderDto {
	private String id;
	private String vendorName;
	private Date deleverDate;
	private Subscription subscription;
	private List<ParcelDto> parcels;
}
