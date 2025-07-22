package com.assignment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entity.Parcel;

public interface ParcelRepository extends JpaRepository<Parcel, String> {
	  Optional<Parcel> findByTrackingId(String trackingId);
}
