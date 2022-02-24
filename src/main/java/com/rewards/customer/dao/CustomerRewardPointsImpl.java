package com.rewards.customer.dao;

import com.rewards.customer.datasetup.TransactionData;
import com.rewards.customer.model.Customer;
import com.rewards.customer.model.Transaction;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerRewardPointsImpl {
    public Customer findByCustomerId(Integer customerId) {
        List<Customer> customers = TransactionData.getCustomers();

        Optional<Customer> customerData = customers.stream().
                filter(customer -> customer.getCustomerId().equals(customerId)).
                findFirst();
        if (customerData.isEmpty()) {
            throw new RuntimeException("Invalid / Missing customer Id ");
        }
        return customerData.get();
    }

    public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Integer customerId, Timestamp from, Timestamp to) {
        List<Transaction> transactionData = TransactionData.getTransactionData();
        return transactionData.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .filter(dates -> dates.getTransactionDate().after(from) && dates.getTransactionDate().before(to))
                .collect(Collectors.toList());

    }
}
