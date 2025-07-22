package com.assignment.Dto;


public class ParcelDto {

    private String id;  

    private String trackingId;
    private String sender;
    private String recipient;
    private String address;
    private double weight;
    private String status;
    

	public ParcelDto() {
	}
	
	public ParcelDto(String id, String trackingId, String sender, String recipient, String address, double weight,
			String status) {
		this.id = id;
		this.trackingId = trackingId;
		this.sender = sender;
		this.recipient = recipient;
		this.address = address;
		this.weight = weight;
		this.status = status;
	}


	public ParcelDto(String trackingId, String sender, String recipient, String address, double weight, String status) {
		this.trackingId = trackingId;
		this.sender = sender;
		this.recipient = recipient;
		this.address = address;
		this.weight = weight;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



 
}
