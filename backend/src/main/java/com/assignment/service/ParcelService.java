package com.assignment.service;

import java.util.List;

import com.assignment.Dto.ParcelDto;

public interface ParcelService {
    List<ParcelDto> getAllParcels();
    ParcelDto getParcelByTrackingId(String trackingId);
    ParcelDto createParcel(ParcelDto dto);
    ParcelDto updateParcel(String id, ParcelDto dto);
    void deleteParcel(String id);
}
