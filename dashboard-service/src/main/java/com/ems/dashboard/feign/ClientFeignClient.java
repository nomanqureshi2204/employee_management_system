package com.ems.dashboard.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.dashboard.dto.ClientResponseDto;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientFeignClient {

    @GetMapping("/clients/count")
    Long getTotalClients();
    
    @GetMapping("/clients/email/{email}")
    ClientResponseDto getClientByEmail(@PathVariable("email") String email);

}