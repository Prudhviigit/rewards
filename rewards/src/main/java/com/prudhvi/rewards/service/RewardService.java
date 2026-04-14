package com.prudhvi.rewards.service;

import com.prudhvi.rewards.dto.MonthlyReward;
import com.prudhvi.rewards.dto.RewardResponse;
import com.prudhvi.rewards.model.CustomerTransaction;
import com.prudhvi.rewards.repository.RewardsRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RewardService {

    private final RewardsRepository repository;

    public RewardService(RewardsRepository repository) {
        this.repository = repository;
    }

    public Optional<RewardResponse> getRewardsByCustomer(int customerId) {

        List<CustomerTransaction> transactions = repository.getAllTransactions()
                .stream()
                .filter(t -> t.getCustomerId() == customerId)
                .toList();

        if (transactions.isEmpty()) {
            return Optional.empty();
        }

        Map<Month, Integer> monthlyPoints = new HashMap<>();
        int totalPoints = 0;

        for (CustomerTransaction t : transactions) {
            int points = calculatePoints(t.getAmount());
            Month month = t.getDate().getMonth();

            monthlyPoints.put(month,
                    monthlyPoints.getOrDefault(month, 0) + points);

            totalPoints += points;
        }

        List<MonthlyReward> monthlyRewards = monthlyPoints.entrySet()
                .stream()
                .map(entry -> new MonthlyReward(
                        entry.getKey().toString(),
                        entry.getValue()))
                .collect(Collectors.toList());

        return Optional.of(new RewardResponse(customerId, monthlyRewards, totalPoints));
    }

    private int calculatePoints(double amount) {

        int points = 0;

        if (amount > 100) {
            points += (int)((amount - 100) * 2);
            points += 50;
        } else if (amount > 50) {
            points += (int)(amount - 50);
        }

        return points;
    }
}
