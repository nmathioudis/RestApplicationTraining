package com.training.restapplicationtraining.controllers;

import com.training.restapplicationtraining.services.IncomingServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("customer")
@RestController
public class IncomingController {

    IncomingServices incomingServices;

    public IncomingController(IncomingServices incomingServices) {
        this.incomingServices = incomingServices;
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<String> fetchCustomer(@PathVariable(required = true) String id){
        try {
            log.info("Trying to save customer with id " + id);
            incomingServices.save(id);
            return new ResponseEntity<>("Customer " + id + " was added in cache memory", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("check/{id}")
    public ResponseEntity<?> checkCustomer(@PathVariable(required = true) String id){
        try {
            log.info("Checking if customer with id " + id + " exists in Cache memory");
            Boolean check = incomingServices.checkIfExists(id);
            return new ResponseEntity<>(check, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(required = true) String id){
        try {
            log.info("Trying to delete customer with id " + id + " from Cache memory");
            incomingServices.remove(id);
            return new ResponseEntity<>("Customer " + id + " was removed from cache memory", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
