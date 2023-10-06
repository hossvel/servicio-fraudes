package com.devhoss.app.serviciofraudes.service;

import com.devhoss.app.serviciofraudes.model.FraudCustomerCheck;
import com.devhoss.app.serviciofraudes.model.FraudRequest;

import java.util.List;

public interface IFraudesService {
    public boolean fraudCheckingCustomer(FraudRequest fraudRequest);

    public List<FraudCustomerCheck> findAll();

    public boolean fraudCheckingCustomerById(String customerid);
}
