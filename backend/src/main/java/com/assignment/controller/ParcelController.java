package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.Dto.ApiResponse;
import com.assignment.Dto.ParcelDto;
import com.assignment.entity.Parcel;
import com.assignment.service.ParcelService;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @GetMapping
    public ResponseEntity<List<ParcelDto>> getAllParcels() {
        return new ResponseEntity<List<ParcelDto>>(parcelService.getAllParcels(),HttpStatus.OK);
    }

    @GetMapping("/tracking/{trackingId}")
    public ResponseEntity<ParcelDto> getParcelByTrackingId(@PathVariable String trackingId) {
        return new ResponseEntity<ParcelDto>(parcelService.getParcelByTrackingId(trackingId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity< ParcelDto> createParcel(@RequestBody Parcel parcel) {
        return new ResponseEntity<ParcelDto>(parcelService.createParcel(parcel),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParcelDto> updateParcel(@PathVariable String id, @RequestBody Parcel parcel) {
        return new ResponseEntity<ParcelDto>(parcelService.updateParcel(id, parcel),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteParcel(@PathVariable String id) {
    	parcelService.deleteParcel(id);
    	ApiResponse apiResponse=new ApiResponse("parcel delete successfully");
    	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
}
