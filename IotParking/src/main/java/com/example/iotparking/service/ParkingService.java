package com.example.iotparking.service;

import com.example.iotparking.dto.ParkingRequestDTO;
import com.example.iotparking.entity.ParkingRecord;
import org.springframework.data.domain.Page;

public interface ParkingService {
    void enterParking(ParkingRequestDTO dto);
    void changeLight(ParkingRequestDTO dto);
    void setFire(ParkingRequestDTO dto);
    void addRecord(ParkingRequestDTO dto);
    Page<ParkingRecord> getParkingRecord();
}
