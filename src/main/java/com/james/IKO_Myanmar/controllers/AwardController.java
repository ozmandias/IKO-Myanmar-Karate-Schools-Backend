package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.services.AwardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/awards")
@RequiredArgsConstructor
public class AwardController {
    private final AwardService awardService;
}