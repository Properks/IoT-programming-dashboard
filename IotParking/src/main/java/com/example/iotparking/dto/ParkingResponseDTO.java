package com.example.iotparking.dto;

import lombok.*;

import java.time.LocalDateTime;

public class ParkingResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class EnterUserResponseDTO {
        private String user;
        private LocalDateTime time;
        private String enter;

        public static EnterUserResponseDTO toEnterUserResponseDTO(String user, LocalDateTime time, String enter) {
            return EnterUserResponseDTO.builder()
                    .user(user)
                    .time(time)
                    .enter(enter)
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
