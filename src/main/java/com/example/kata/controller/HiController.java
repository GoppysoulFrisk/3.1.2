package com.example.kata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HiController {
    @GetMapping("/")
    public String makeHi() {return "hiPage";}
}