package com.example.iotparking.dto;

import com.example.iotparking.entity.ParkingRecord;
import lombok.*;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class EnterUserResponseDTO {
        private String user;
        private LocalDateTime time;
        private String enter;

        public static EnterUserResponseDTO toEnterUserResponseDTO(ParkingRecord parkingRecord) {
            return EnterUserResponseDTO.builder()
                    .user(parkingRecord.getUsername())
                    .time(parkingRecord.getTime())
                    .enter(parkingRecord.getEnter())
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class EnterUserResponseListDTO {
        private List<EnterUserResponseDTO> items;
        public static EnterUserResponseListDTO toEnterUserResponseListDTO(Page<ParkingRecord> parkingRecords) {
            return EnterUserResponseListDTO.builder()
                    .items(parkingRecords.getContent().stream().map(EnterUserResponseDTO::toEnterUserResponseDTO).toList())
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class LightResponseDTO {
        private String position;
        private boolean isParked;

        public static LightResponseDTO toLightResponseDTO(String position, boolean isParked) {
            return LightResponseDTO.builder()
                    .position(position)
                    .isParked(isParked)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class FireResponseDTO {
        private boolean isFire;

        public static FireResponseDTO toFireResponseDTO(boolean isFire) {
            return FireResponseDTO.builder()
                    .isFire(isFire)
                    .build();
        }
    }
}
