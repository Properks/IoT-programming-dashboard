package com.example.iotparking.repository;

import com.example.iotparking.entity.ParkingRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRecordRepository extends JpaRepository<ParkingRecord, Long> {
    Page<ParkingRecord> findAllByOrderByTimeAsc(Pageable pageable);
}
