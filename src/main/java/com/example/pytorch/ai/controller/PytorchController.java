package com.example.pytorch.ai.controller;

import com.example.pytorch.ai.service.PytorchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PytorchController {
    private final PytorchService pytorchService;

//    @GetMapping("/pytorch")
//    public float[] get() {
//
//    }
}
