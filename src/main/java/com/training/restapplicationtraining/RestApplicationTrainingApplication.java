package com.training.restapplicationtraining;

import com.training.restapplicationtraining.models.InsuranceCustomer;
import com.training.restapplicationtraining.repository.InsuranceCustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RestApplicationTrainingApplication implements CommandLineRunner {

    InsuranceCustomerRepository insuranceCustomerRepository;

    public RestApplicationTrainingApplication(InsuranceCustomerRepository insuranceCustomerRepository) {
        this.insuranceCustomerRepository = insuranceCustomerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestApplicationTrainingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        InsuranceCustomer customer1 = new InsuranceCustomer("123456789");
        insuranceCustomerRepository.save(customer1);
        InsuranceCustomer retrievedCustomer = insuranceCustomerRepository.findById("123456789").get();
        System.out.println("retrieved client " + retrievedCustomer.getId());
    }
}
