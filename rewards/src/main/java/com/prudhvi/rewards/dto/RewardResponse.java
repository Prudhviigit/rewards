package com.prudhvi.rewards.dto;

import java.util.List;

public class RewardResponse {
    private int customerId;
    private List<MonthlyReward> monthlyRewards;
    private int totalPoints;

    public RewardResponse(int customerId, List<MonthlyReward> monthlyRewards, int totalPoints) {
        this.customerId = customerId;
        this.monthlyRewards = monthlyRewards;
        this.totalPoints = totalPoints;
    }

    public int getCustomerId() { return customerId; }
    public List<MonthlyReward> getMonthlyRewards() { return monthlyRewards; }
    public int getTotalPoints() { return totalPoints; }
}
