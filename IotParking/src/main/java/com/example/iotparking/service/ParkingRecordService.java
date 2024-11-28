package com.example.iotparking.service;

import com.example.iotparking.entity.ParkingRecord;
import org.springframework.data.domain.Page;

public interface ParkingRecordService {
    ParkingRecord save(String username, String enter);
    Page<ParkingRecord> getParkingRecord(int page, int offset);
}
