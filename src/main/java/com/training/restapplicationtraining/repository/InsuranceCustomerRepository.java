package com.training.restapplicationtraining.repository;

import com.training.restapplicationtraining.models.InsuranceCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceCustomerRepository extends CrudRepository<InsuranceCustomer, String> {
//    InsuranceCustomer findByInsuranceId(String insuranceId);
}
