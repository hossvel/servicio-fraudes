package com.devhoss.app.serviciofraudes.repository;

import com.devhoss.app.serviciofraudes.model.FraudCustomerCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFraudesRepository extends JpaRepository<FraudCustomerCheck, Long> {

   Optional<FraudCustomerCheck> findAllByTipoAndValor(String tipo, String valor);

   Optional<FraudCustomerCheck> findByClienteid(String clienteId);
}

