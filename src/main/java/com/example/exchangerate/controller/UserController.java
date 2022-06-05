package com.example.exchangerate.controller;

import com.example.exchangerate.service.ExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class UserController {

    private final ExchangeService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currencies", service.getCurrencies());
        return "index";
    }
}
