package com.assignment.service;

import java.util.List;

import com.assignment.Dto.ParcelDto;
import com.assignment.entity.Parcel;

public interface ParcelService {
    List<ParcelDto> getAllParcels();
    ParcelDto getParcelByTrackingId(String trackingId);
    ParcelDto createParcel(Parcel dto);
    ParcelDto updateParcel(String id, Parcel dto);
    void deleteParcel(String id);
}
