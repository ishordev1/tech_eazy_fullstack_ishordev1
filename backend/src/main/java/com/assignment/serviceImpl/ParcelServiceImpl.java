package com.assignment.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Dto.ParcelDto;
import com.assignment.Exception.ResourceNotFoundException;
import com.assignment.Repository.ParcelRepository;
import com.assignment.entity.Parcel;
import com.assignment.service.ParcelService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParcelServiceImpl implements ParcelService {
    @Autowired
    private ParcelRepository parcelRepository;

    @Override
    public ParcelDto createParcel(ParcelDto dto) {
    	String trackingId=UUID.randomUUID().toString();
    	dto.setTrackingId(trackingId);
        Parcel parcel = dtoToParcel(dto);
        
        Parcel saved = parcelRepository.save(parcel);
        return parcelToDto(saved);
    }
    
    @Override
    public List<ParcelDto> getAllParcels() {
        return parcelRepository.findAll().stream()
                .map(parcel -> parcelToDto(parcel))
                .collect(Collectors.toList());
    }

    @Override
    public ParcelDto getParcelByTrackingId(String trackingId) {
        Parcel parcel = parcelRepository.findByTrackingId(trackingId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found with trackingId: " + trackingId));
        return parcelToDto(parcel);
    }

 

    @Override
    public ParcelDto updateParcel(String id, ParcelDto dto) {
        Parcel parcel = parcelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found with id: " + id));

        parcel.setTrackingId(dto.getTrackingId());
        parcel.setSender(dto.getSender());
        parcel.setRecipient(dto.getRecipient());
        parcel.setAddress(dto.getAddress());
        parcel.setWeight(dto.getWeight());
        parcel.setStatus(dto.getStatus());

        Parcel updated = parcelRepository.save(parcel);
        return parcelToDto(updated);
    }

    @Override
    public void deleteParcel(String id) {
        parcelRepository.deleteById(id);
    }

    private ParcelDto parcelToDto(Parcel parcel) {
        ParcelDto dto = new ParcelDto();
        dto.setId(parcel.getId());
        dto.setTrackingId(parcel.getTrackingId());
        dto.setSender(parcel.getSender());
        dto.setRecipient(parcel.getRecipient());
        dto.setAddress(parcel.getAddress());
        dto.setWeight(parcel.getWeight());
        dto.setStatus(parcel.getStatus());
        return dto;
    }
    

    private Parcel dtoToParcel(ParcelDto dto) {
        Parcel parcel = new Parcel();
        parcel.setId(dto.getId());
        parcel.setTrackingId(dto.getTrackingId());
        parcel.setSender(dto.getSender());
        parcel.setRecipient(dto.getRecipient());
        parcel.setAddress(dto.getAddress());
        parcel.setWeight(dto.getWeight());
        parcel.setStatus(dto.getStatus());
        return parcel;
    }
}
