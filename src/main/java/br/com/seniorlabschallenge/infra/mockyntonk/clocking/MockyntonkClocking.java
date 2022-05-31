package br.com.seniorlabschallenge.infra.mockyntonk.clocking;

import br.com.seniorlabschallenge.domain.dto.ClockingDTO;
import br.com.seniorlabschallenge.domain.dto.response.ClockingResponse;
import br.com.seniorlabschallenge.infra.mockyntonk.configuration.MockyntonkApiConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "mockyntonk-clocking",url = "https://api.mockytonk.com/proxy/ab2198a3-cafd-49d5-8ace-baac64e72222",configuration = MockyntonkApiConfiguration.class)
public interface MockyntonkClocking {

    @PostMapping
    ResponseEntity<ClockingResponse> createClocking(@RequestBody @Valid ClockingDTO dto);

}
