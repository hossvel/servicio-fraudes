package com.devhoss.app.serviciofraudes.service;

import com.devhoss.app.serviciofraudes.model.FraudCustomerCheck;
import com.devhoss.app.serviciofraudes.repository.IFraudesRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class FraudesServiceImplTest {


    @Mock
    IFraudesRepository iFraudesRepository;

    @InjectMocks
    FraudesServiceImpl fraudeServiceImpl;



    @DisplayName("Test para retornar una lista vacia")
   @Test
    void testListarColeccionFraudesVacia() {

       //given
       given(iFraudesRepository.findAll()).willReturn(Collections.emptyList());
       //when
       List<FraudCustomerCheck> fraudes = fraudeServiceImpl.findAll();

       //then
       assertThat(fraudes).isEmpty();
       assertThat(fraudes.size()).isEqualTo(0);
       assertEquals(0,fraudes.size());

       verify(iFraudesRepository).findAll();

    }
    @DisplayName("Test para listar fraudes")
    @Test
    void testListarFraudes(){
        //given
        FraudCustomerCheck fraude1 = FraudCustomerCheck.builder()
                .id(100L)
                .tipo("10")
                .valor("01")
                .clienteid("1001")
                .build();
        FraudCustomerCheck fraude2 = FraudCustomerCheck.builder()
                .id(200L)
                .tipo("20")
                .valor("01")
                .clienteid("2001")
                .build();
        given(iFraudesRepository.findAll()).willReturn(List.of(fraude1,fraude2));

        //when
        List<FraudCustomerCheck> fraudes = fraudeServiceImpl.findAll();

        //then
        assertThat(fraudes).isNotNull();
        assertThat(fraudes.size()).isEqualTo(2);

        verify(iFraudesRepository).findAll();
    }

}