package com.prudhvi.rewards.repository;

import com.prudhvi.rewards.model.CustomerTransaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public class RewardsRepository  {

    public List<CustomerTransaction> getAllTransactions() {
        return Arrays.asList(
                new CustomerTransaction(101, 120, LocalDate.of(2026, 1, 10)),
                new CustomerTransaction(101, 75, LocalDate.of(2026, 1, 15)),
                new CustomerTransaction(101, 200, LocalDate.of(2026, 2, 5)),
                new CustomerTransaction(101, 90, LocalDate.of(2026, 3, 12)),

                new CustomerTransaction(102, 50, LocalDate.of(2026, 1, 10)),
                new CustomerTransaction(102, 110, LocalDate.of(2026, 2, 15)),
                new CustomerTransaction(102, 40, LocalDate.of(2026, 3, 20))
        );
    }
}
