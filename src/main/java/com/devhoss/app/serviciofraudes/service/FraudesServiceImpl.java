package com.devhoss.app.serviciofraudes.service;

import com.devhoss.app.serviciofraudes.model.FraudCustomerCheck;
import com.devhoss.app.serviciofraudes.model.FraudRequest;
import com.devhoss.app.serviciofraudes.repository.IFraudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FraudesServiceImpl implements IFraudesService {
    @Autowired
    private IFraudesRepository iFraudesRepository;


    @Transactional(readOnly = true)
    public List<FraudCustomerCheck> findAll() {
        return (List<FraudCustomerCheck>) iFraudesRepository.findAll();
    }

    @Override
    public boolean fraudCheckingCustomerById(String customerid) {
        Optional<FraudCustomerCheck> fraudCustomerCheck = iFraudesRepository
                .findByClienteid(customerid);
        //.findByClienteid("1001");
        if(fraudCustomerCheck.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public boolean fraudCheckingCustomer(FraudRequest fraudRequest) {
        Optional<FraudCustomerCheck> fraudCustomerCheck = iFraudesRepository
                .findByClienteid(fraudRequest.idType()+fraudRequest.idValue());
                //.findByClienteid("1001");
        if(fraudCustomerCheck.isPresent()){
            return true;
        }
        iFraudesRepository.save(
                FraudCustomerCheck.builder()
                        .clienteid(fraudRequest.idType()+fraudRequest.idValue())
                        .tipo(fraudRequest.idType())
                        .valor(fraudRequest.idValue())
                        //.created(LocalDateTime.now())
                        .build()
        );
        return false;

    }
}
