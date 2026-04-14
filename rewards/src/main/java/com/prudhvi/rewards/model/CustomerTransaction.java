package com.prudhvi.rewards.model;

import java.time.LocalDate;

public class CustomerTransaction {

        private int customerId;
        private double amount;
        private LocalDate date;

        public CustomerTransaction(int customerId, double amount, LocalDate date) {
            this.customerId = customerId;
            this.amount = amount;
            this.date = date;
        }

        public int getCustomerId() { return customerId; }
        public double getAmount() { return amount; }
        public LocalDate getDate() { return date; }
    }

