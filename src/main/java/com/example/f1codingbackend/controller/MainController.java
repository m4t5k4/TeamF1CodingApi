package com.example.f1codingbackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.f1codingbackend.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.GregorianCalendar;

@RestController
public class MainController {

    @GetMapping("/start")
    public String test() {
        return "test";
    }
}
