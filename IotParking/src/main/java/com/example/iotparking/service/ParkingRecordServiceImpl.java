package com.example.iotparking.service;

import com.example.iotparking.entity.ParkingRecord;
import com.example.iotparking.repository.ParkingRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingRecordServiceImpl implements ParkingRecordService {

    private final ParkingRecordRepository parkingRecordRepository;

    @Override
    public ParkingRecord save(String username, String enter) {
        return parkingRecordRepository.save(
                ParkingRecord.builder()
                        .username(username)
                        .enter(enter)
                        .build()
        );
    }

    @Override
    public Page<ParkingRecord> getParkingRecord(int page, int offset) {
        Pageable pageable = PageRequest.of(page, offset);
        return parkingRecordRepository.findAllByOrderByTime(pageable);
    }
}
