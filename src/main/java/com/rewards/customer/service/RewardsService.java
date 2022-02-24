package com.rewards.customer.service;

import com.rewards.customer.model.RewardsPoints;

public interface RewardsService {
    public RewardsPoints getRewardsByCustomerId(Integer customerId);
}
