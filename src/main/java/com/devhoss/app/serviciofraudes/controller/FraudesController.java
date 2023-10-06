package com.devhoss.app.serviciofraudes.controller;

import com.devhoss.app.serviciofraudes.model.FraudCheckResponse;
import com.devhoss.app.serviciofraudes.model.FraudCustomerCheck;
import com.devhoss.app.serviciofraudes.model.FraudRequest;
import com.devhoss.app.serviciofraudes.service.IFraudesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fraud-checks")
@Slf4j
public class FraudesController {
    @Autowired
    private IFraudesService iFraudesService;

    @PostMapping()
    public FraudCheckResponse checkCustomer(@RequestBody FraudRequest fraudRequest) {
        boolean isFraudulentCustomer = iFraudesService.fraudCheckingCustomer(fraudRequest);
        log.info("fraud check request for customer {}", isFraudulentCustomer);

        return new FraudCheckResponse(isFraudulentCustomer);
    }

    @GetMapping
    public List<FraudCustomerCheck> findAll(){
        return iFraudesService.findAll();
    }

    @GetMapping("/{id}")
    public FraudCheckResponse fraudCheckingCustomerById(@PathVariable String id){
        boolean isFraudulentCustomer = iFraudesService.fraudCheckingCustomerById(id);
        log.info("fraud check request for customer by ID: {} - {}",id , isFraudulentCustomer);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}
