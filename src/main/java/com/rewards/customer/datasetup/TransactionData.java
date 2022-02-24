package com.rewards.customer.datasetup;


import com.rewards.customer.model.Customer;
import com.rewards.customer.model.Transaction;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionData {

    public static List<Transaction> getTransactionData() {

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1001, 101, Timestamp.valueOf("2021-12-12 18:48:05.123"), 85));
        transactions.add(new Transaction(1002, 101, Timestamp.valueOf("2021-12-19 18:48:05.123"), 160));
        transactions.add(new Transaction(1003, 101, Timestamp.valueOf("2021-12-25 18:48:05.123"), 170));
        transactions.add(new Transaction(1004, 101, Timestamp.valueOf("2021-12-30 18:48:05.123"), 220));
        transactions.add(new Transaction(1005, 101, Timestamp.valueOf("2022-01-01 18:48:05.123"), 160));
        transactions.add(new Transaction(1006, 101, Timestamp.valueOf("2022-01-02 18:48:05.123"), 110));
        transactions.add(new Transaction(1007, 101, Timestamp.valueOf("2022-01-02 18:48:05.123"), 150));
        transactions.add(new Transaction(1008, 102, Timestamp.valueOf("2021-12-28 18:48:05.123"), 160));
        transactions.add(new Transaction(1009, 102, Timestamp.valueOf("2022-01-02 18:48:05.123"), 90));
        transactions.add(new Transaction(10010, 102, Timestamp.valueOf("2022-01-12 18:48:05.123"), 78));
        transactions.add(new Transaction(10011, 102, Timestamp.valueOf("2022-01-22 18:48:05.123"), 86));
        transactions.add(new Transaction(10012, 102, Timestamp.valueOf("2022-02-13 18:48:05.123"), 178));
        transactions.add(new Transaction(10013, 102, Timestamp.valueOf("2022-02-20 18:48:05.123"), 194));
        transactions.add(new Transaction(10014, 103, Timestamp.valueOf("2021-12-12 18:48:05.123"), 101));
        transactions.add(new Transaction(10015, 103, Timestamp.valueOf("2021-12-17 18:48:05.123"), 120));
        transactions.add(new Transaction(10016, 103, Timestamp.valueOf("2021-12-28 18:48:05.123"), 600));
        transactions.add(new Transaction(10017, 103, Timestamp.valueOf("2022-01-02 18:48:05.123"), 320));
        transactions.add(new Transaction(10018, 103, Timestamp.valueOf("2022-01-12 18:48:05.123"), 268));
        transactions.add(new Transaction(10011, 103, Timestamp.valueOf("2022-01-22 18:48:05.123"), 280));
        transactions.add(new Transaction(10012, 103, Timestamp.valueOf("2022-02-13 18:48:05.123"), 143));
        transactions.add(new Transaction(1009, 104, Timestamp.valueOf("2022-01-02 18:48:05.123"), 245));
        transactions.add(new Transaction(10010, 104, Timestamp.valueOf("2022-01-12 18:48:05.123"), 220));
        transactions.add(new Transaction(10011, 104, Timestamp.valueOf("2022-01-22 18:48:05.123"), 178));
        transactions.add(new Transaction(10012, 104, Timestamp.valueOf("2022-02-13 18:48:05.123"), 189));

        return transactions;
    }

    public static List<Customer> getCustomers() {
        List customers = new ArrayList();

        customers.add(new Customer(101, "Ramana"));
        customers.add(new Customer(102, "Terry"));
        customers.add(new Customer(103, "Nathan"));
        customers.add(new Customer(104, "Neha"));

        return customers;
    }
}
