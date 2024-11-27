package com.example.iotparking.repository;

import com.example.iotparking.entity.ParkingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRecordRepository extends JpaRepository<ParkingRecord, Long> {
}
