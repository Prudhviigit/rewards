package com.prudhvi.rewards;

import com.prudhvi.rewards.repository.RewardsRepository;
import com.prudhvi.rewards.service.RewardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RewardsServiceTest {

    private final RewardService service = new RewardService(new RewardsRepository());

    @Test
    public void testValidCustomer() {
        var response = service.getRewardsByCustomer(101);
        assertTrue(response.isPresent());
        assertTrue(response.get().getTotalPoints() > 0);
    }

    @Test
    public void testInvalidCustomer() {
        var response = service.getRewardsByCustomer(999);
        assertTrue(response.isEmpty());
    }

    @Test
    public void testCalculationLogic() throws Exception {
        var method = RewardService.class.getDeclaredMethod("calculatePoints", double.class);
        method.setAccessible(true);

        assertEquals(90, method.invoke(service, 120));
        assertEquals(25, method.invoke(service, 75));
        assertEquals(0, method.invoke(service, 50));
    }
}
