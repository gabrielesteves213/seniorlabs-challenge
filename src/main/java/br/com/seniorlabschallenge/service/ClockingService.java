package br.com.seniorlabschallenge.service;

import br.com.seniorlabschallenge.domain.dto.ClockingDTO;
import br.com.seniorlabschallenge.domain.dto.response.ClockingResponse;
import br.com.seniorlabschallenge.domain.mapper.ClockingMapper;
import br.com.seniorlabschallenge.domain.repositories.ClockingRepository;
import br.com.seniorlabschallenge.infra.mockyntonk.clocking.MockyntonkClocking;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ClockingService {

    @Autowired
    private ClockingRepository clockingRepository;

    @Autowired
    private MockyntonkClocking mockyntonkClocking;

    public List<ClockingDTO> getAllClockingByEmployeerId(@NonNull Long employeeId) {
        return this.clockingRepository.findAll(ClockingRepository.byEmployeerId(employeeId))
                .stream().map(ClockingMapper::toDto).collect(Collectors.toList());
    }

    public ClockingDTO createClocking(@NonNull ClockingDTO dto){
        if(Objects.isNull(dto.getIncludedAt())){
            dto.setIncludedAt(Timestamp.from(Instant.from(Instant.now().atZone(ZoneId.of("-3")))));
        }
        ResponseEntity<ClockingResponse> response = this.mockyntonkClocking.createClocking(dto);
        if(response.getStatusCode().is2xxSuccessful()){
                if(Objects.equals(response.getBody().getMessage(),"success")&&Objects.equals(response.getBody().getSystem(),"legacy")){
                return ClockingMapper.toDto(this.clockingRepository.save(ClockingMapper.toEntity(dto)));
            }
        }
        throw new RuntimeException("Erro ao bater o ponto na API ");
    }
}
