package com.assignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelDto {
	    private String customerName;
	    private String deliveryAddress;
	    private String trackingId;
}
