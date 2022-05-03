package com.training.restapplicationtraining.services;

import com.training.restapplicationtraining.models.InsuranceCustomer;
import com.training.restapplicationtraining.repository.InsuranceCustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class IncomingServices {

    InsuranceCustomerRepository insuranceCustomerRepository;

    public IncomingServices(InsuranceCustomerRepository insuranceCustomerRepository) {
        this.insuranceCustomerRepository = insuranceCustomerRepository;
    }

    public void save(String id){
        insuranceCustomerRepository.save(new InsuranceCustomer(id));
    }

    public void remove(String id){
        insuranceCustomerRepository.deleteById(id);
    }

    public boolean checkIfExists(String id){
        return insuranceCustomerRepository.existsById(id);
    }
}
