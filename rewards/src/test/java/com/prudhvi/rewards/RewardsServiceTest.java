package com.prudhvi.rewards;

import com.prudhvi.rewards.dto.RewardResponse;
import com.prudhvi.rewards.repository.RewardsRepository;
import com.prudhvi.rewards.service.RewardService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class RewardsServiceTest {

    private final RewardService service =
            new RewardService(new RewardsRepository());

    // Test: valid customer
    @Test
    void testValidCustomerRewards() {

        Optional<RewardResponse> result = service.getRewardsByCustomer(101);

        assertTrue(result.isPresent(), "Customer should exist");
        assertEquals(101, result.get().getCustomerId());

        // basic sanity check
        assertTrue(result.get().getTotalPoints() >= 0);
        assertNotNull(result.get().getMonthlyRewards());
        assertFalse(result.get().getMonthlyRewards().isEmpty());
    }


    // Test: invalid customer
    @Test
    void testInvalidCustomer() {

        Optional<RewardResponse> result = service.getRewardsByCustomer(999);

        assertTrue(result.isEmpty(), "Customer should not exist");
    }


    // Test: reward calculation logic (direct validation via known dataset)
    @Test
    void testRewardCalculationConsistency() {

        Optional<RewardResponse> result = service.getRewardsByCustomer(101);

        assertTrue(result.isPresent());

        RewardResponse response = result.get();

        // Based on your sample data, total should always be positive
        assertTrue(response.getTotalPoints() > 0);

        // Ensure monthly grouping exists
        assertTrue(response.getMonthlyRewards().size() > 0);
    }
}
