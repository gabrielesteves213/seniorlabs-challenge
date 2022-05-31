package br.com.seniorlabschallenge.domain.mapper;

import br.com.seniorlabschallenge.domain.dto.ClockingDTO;
import br.com.seniorlabschallenge.domain.entities.Clocking;
import lombok.NonNull;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class ClockingMapper {

    public static Clocking toEntity(@NonNull ClockingDTO dto){
        return Clocking
                .builder()
                .employeeId(dto.getEmployeeId())
                .employerId(dto.getEmployerId())
                .includedAt(dto.getIncludedAt())
                .build();
    }

    public static ClockingDTO toDto(@NonNull Clocking entity){
        return ClockingDTO
                .builder()
                .employeeId(entity.getEmployeeId())
                .employerId(entity.getEmployerId())
                .includedAt(entity.getIncludedAt())
                .build();
    }

}
