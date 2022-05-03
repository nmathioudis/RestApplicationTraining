package com.training.restapplicationtraining.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("InsuranceCustomer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCustomer implements Serializable {
    private String id;
//    private String insuranceId;
}
