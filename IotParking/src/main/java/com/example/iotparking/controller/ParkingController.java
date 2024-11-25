package com.example.iotparking.controller;

import com.example.iotparking.dto.ParkingRequestDTO;
import com.example.iotparking.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @PostMapping("/setUser")
    public ResponseEntity<String> enterParking(@RequestBody ParkingRequestDTO dto) {
        parkingService.enterParking(dto);
        return ResponseEntity.ok().body(null);
    }

    @PostMapping("/setLight")
    public ResponseEntity<String> changeLight(@RequestBody ParkingRequestDTO dto) {
        parkingService.changeLight(dto);
        return ResponseEntity.ok().body(null);
    }

    @PostMapping("setFire")
    public ResponseEntity<String> setFire(@RequestBody ParkingRequestDTO dto) {
        parkingService.setFire(dto);
        return ResponseEntity.ok().body(null);
    }
}
