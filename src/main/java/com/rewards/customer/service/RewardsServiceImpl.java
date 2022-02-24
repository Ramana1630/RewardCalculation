package com.rewards.customer.service;

import com.rewards.customer.constants.Constants;
import com.rewards.customer.dao.CustomerRewardPointsImpl;
import com.rewards.customer.model.RewardsPoints;
import com.rewards.customer.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RewardsServiceImpl implements RewardsService {

    @Autowired
    CustomerRewardPointsImpl customerRewardPointsImpl;

    public RewardsPoints getRewardsByCustomerId(Integer customerId) {

        Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(Constants.DAYS_IN_MONTH);
        Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2 * Constants.DAYS_IN_MONTH);
        Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3 * Constants.DAYS_IN_MONTH);

        List<Transaction> lastMonthTransactions = customerRewardPointsImpl.findAllByCustomerIdAndTransactionDateBetween(
                customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
        List<Transaction> lastSecondMonthTransactions = customerRewardPointsImpl
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
        List<Transaction> lastThirdMonthTransactions = customerRewardPointsImpl
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastThirdMonthTimestamp,
                        lastSecondMonthTimestamp);
        List<Double> lastMonthTotal = getAmountPerMonth(lastMonthTransactions);
        Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
        List<Double> lastSecondMonthTotal = getAmountPerMonth(lastSecondMonthTransactions);
        Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
        List<Double> lastThirdMonthTotal = getAmountPerMonth(lastThirdMonthTransactions);
        Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

        RewardsPoints customerRewards = new RewardsPoints();
        customerRewards.setCustomerId(customerId);
        customerRewards.setLastMonthAmounts(lastMonthTotal);
        customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
        customerRewards.setLastSecondMonthAmounts(lastSecondMonthTotal);
        customerRewards.setLastThirdMonthAmounts(lastThirdMonthTotal);
        customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
        customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
        customerRewards.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

        return customerRewards;

    }

    private Long getRewardsPerMonth(List<Transaction> transactions) {
        return transactions.stream().map(transaction -> calculateRewardsPoints(transaction))
                .collect(Collectors.summingLong(r -> r.longValue()));
    }

    private List<Double> getAmountPerMonth(List<Transaction> transactions) {
        return transactions.stream().map(transaction -> transaction.getTransactionAmount())
                .collect(Collectors.toList());
    }

    private Long calculateRewardsPoints(Transaction transaction) {
        if (transaction.getTransactionAmount() > Constants.FIRST_REWARD_LIMIT && transaction.getTransactionAmount() <= Constants.SECOND_REWARD_LIMIT) {
            return Math.round(transaction.getTransactionAmount() - Constants.FIRST_REWARD_LIMIT);
        } else if (transaction.getTransactionAmount() > Constants.SECOND_REWARD_LIMIT) {
            return Math.round(transaction.getTransactionAmount() - Constants.SECOND_REWARD_LIMIT) * 2
                    + (Constants.SECOND_REWARD_LIMIT - Constants.FIRST_REWARD_LIMIT);
        } else
            return 0l;

    }

    public Timestamp getDateBasedOnOffSetDays(int days) {
        return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
    }

}
