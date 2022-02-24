package com.rewards.customer.controller;

import com.rewards.customer.dao.CustomerRewardPointsImpl;
import com.rewards.customer.model.Customer;
import com.rewards.customer.model.RewardsPoints;
import com.rewards.customer.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class RewardsController {

    @Autowired
    RewardsService rewardsService;

    @Autowired
    CustomerRewardPointsImpl customerRewardPointsImpl;

    @GetMapping(value = "/{customerId}/rewardpoints", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RewardsPoints> getRewardsPointsByCustomerId(@PathVariable("customerId") Integer customerId) {
        Customer customer = customerRewardPointsImpl.findByCustomerId(customerId);

        RewardsPoints customerRewards = rewardsService.getRewardsByCustomerId(customer.getCustomerId());
        return new ResponseEntity<>(customerRewards, HttpStatus.OK);
    }

}
