package com.rewards.customer.model;

import java.util.List;

public class RewardsPoints {
    private long customerId;
    private List<Double> lastMonthAmounts;
    private long lastMonthRewardPoints;
    private List<Double> lastSecondMonthAmounts;
    private long lastSecondMonthRewardPoints;
    private List<Double> lastThirdMonthAmounts;
    private long lastThirdMonthRewardPoints;
    private long totalRewards;

    public long getCustomerId() {
        return customerId;
    }

    public long getLastMonthRewardPoints() {
        return lastMonthRewardPoints;
    }

    public void setLastMonthRewardPoints(long lastMonthRewardPoints) {
        this.lastMonthRewardPoints = lastMonthRewardPoints;
    }

    public long getLastSecondMonthRewardPoints() {
        return lastSecondMonthRewardPoints;
    }

    public void setLastSecondMonthRewardPoints(long lastSecondMonthRewardPoints) {
        this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
    }

    public long getLastThirdMonthRewardPoints() {
        return lastThirdMonthRewardPoints;
    }

    public void setLastThirdMonthRewardPoints(long lastThirdMonthRewardPoints) {
        this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(long totalRewards) {
        this.totalRewards = totalRewards;
    }

    public List<Double> getLastMonthAmounts() {
        return lastMonthAmounts;
    }

    public void setLastMonthAmounts(List<Double> lastMonthAmounts) {
        this.lastMonthAmounts = lastMonthAmounts;
    }

    public List<Double> getLastSecondMonthAmounts() {
        return lastSecondMonthAmounts;
    }

    public void setLastSecondMonthAmounts(List<Double> lastSecondMonthAmounts) {
        this.lastSecondMonthAmounts = lastSecondMonthAmounts;
    }

    public List<Double> getLastThirdMonthAmounts() {
        return lastThirdMonthAmounts;
    }

    public void setLastThirdMonthAmounts(List<Double> lastThirdMonthAmounts) {
        this.lastThirdMonthAmounts = lastThirdMonthAmounts;
    }
}
