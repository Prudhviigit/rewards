package com.prudhvi.rewards.controller;

import com.prudhvi.rewards.dto.RewardResponse;
import com.prudhvi.rewards.service.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    private final RewardService service;

    public RewardsController(RewardService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<RewardResponse> getRewards(@PathVariable int customerId) {

        return service.getRewardsByCustomer(customerId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
