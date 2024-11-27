package com.example.iotparking.service;

import com.example.iotparking.entity.ParkingRecord;

public interface ParkingRecordService {
    ParkingRecord save(String username, String enter);
}
