package com.assignment.serviceImpl;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ParcelDto createParcel(Parcel parcel) {
    	String trackingId=UUID.randomUUID().toString();
    	parcel.setTrackingId(trackingId);

        Parcel saved = parcelRepository.save(parcel);
        return this.modelMapper.map(saved, ParcelDto.class);
    }
    
    @Override
    public List<ParcelDto> getAllParcels() {
        return parcelRepository.findAll().stream()
                .map(parcel -> this.modelMapper.map(parcel, ParcelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ParcelDto getParcelByTrackingId(String trackingId) {
        Parcel parcel = parcelRepository.findByTrackingId(trackingId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found with trackingId: " + trackingId));
        return this.modelMapper.map(parcel, ParcelDto.class);
    }

 

    @Override
    public ParcelDto updateParcel(String id, Parcel parcel) {
        Parcel dbParcel = parcelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found with id: " + id));
parcel.setId(dbParcel.getId());
parcel.setTrackingId(dbParcel.getTrackingId());
       
        Parcel updated = parcelRepository.save(parcel);
        return this.modelMapper.map(updated, ParcelDto.class);
    }

    @Override
    public void deleteParcel(String id) {
        parcelRepository.deleteById(id);
    }

    
}
