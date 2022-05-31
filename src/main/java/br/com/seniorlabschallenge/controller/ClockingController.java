package br.com.seniorlabschallenge.controller;

import br.com.seniorlabschallenge.domain.dto.ClockingDTO;
import br.com.seniorlabschallenge.service.ClockingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/v1/clocking")
public class ClockingController {

    @Autowired
    private ClockingService clockingService;

    @GetMapping("/{employeeId}")
    private ResponseEntity<List<ClockingDTO>> getAllClockingByEmployeerId(@PathVariable("employeeId") Long employeeId ){
        return ResponseEntity.ok(this.clockingService.getAllClockingByEmployeerId(employeeId));
    }

    @PostMapping
    private ResponseEntity<ClockingDTO> createClocking(@RequestBody @Valid ClockingDTO dto){
        return ResponseEntity.ok(this.clockingService.createClocking(dto));
    }


}
