package com.example.iotparking.service;

import com.example.iotparking.dto.ParkingRequestDTO;
import com.example.iotparking.dto.ParkingResponseDTO;
import com.example.iotparking.entity.ParkingRecord;
import com.example.iotparking.repository.ParkingRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private static final String LIGHT_VALUE = "2000";
    private static final String FIRE_VALUE = "80";
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ParkingRecordService parkingRecordService;
    private static Set<String> session = new HashSet<>();

    @Override
    public void enterParking(ParkingRequestDTO dto) {
        String name = dto.getValue();
        ParkingResponseDTO.EnterUserResponseDTO response;
        ParkingRecord latest = parkingRecordService.getParkingRecord(0, 1).getContent().get(0);
        if (latest.getUsername().equals(dto.getValue()) && latest.getTime().isAfter(LocalDateTime.now().minusSeconds(5))) {
            return;
        }
        if (session.contains(name)) {
            response = ParkingResponseDTO.EnterUserResponseDTO.toEnterUserResponseDTO(
                    parkingRecordService.save(name, "out")
            );
            session.remove(name);
        }
        else {
            response = ParkingResponseDTO.EnterUserResponseDTO.toEnterUserResponseDTO(
                    parkingRecordService.save(name, "in")
            );
            session.add(name);
        }
        log.info("Enter User: {}", name);
        simpMessagingTemplate.convertAndSend("/sensors/user", response);
    }

    @Override
    public void changeLight(ParkingRequestDTO dto) {
        String[] values = dto.getValue().split(" ");
        List<ParkingResponseDTO.LightResponseDTO> responses = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            responses.add(ParkingResponseDTO.LightResponseDTO.toLightResponseDTO(String.valueOf(i + 1), values[i].compareTo(LIGHT_VALUE) < 0));
        }
        log.info("Light value: {}", Arrays.toString(values));
        simpMessagingTemplate.convertAndSend("/sensors/light", responses);
    }

    @Override
    public void setFire(ParkingRequestDTO dto) {
        String value = dto.getValue();
        log.info("Fire value: {}", value);
        simpMessagingTemplate.convertAndSend("/sensors/fire", ParkingResponseDTO.FireResponseDTO.toFireResponseDTO(value.compareTo(FIRE_VALUE) > 0));
    }

    @Override
    public void addRecord(ParkingRequestDTO dto) {

    }

    @Override
    public Page<ParkingRecord> getParkingRecord() {
        return parkingRecordService.getParkingRecord(0, 10);
    }
}
