package com.example.iotparking.service;

import com.example.iotparking.dto.ParkingRequestDTO;

public interface ParkingService {
    void enterParking(ParkingRequestDTO dto);
    void changeLight(ParkingRequestDTO dto);
    void setFire(ParkingRequestDTO dto);
    void addRecord(ParkingRequestDTO dto);
}
