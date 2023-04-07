package com.huawei.ibooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class TestController {
    @RequestMapping(value = {"/test"})
    public String index(Model model) {
        model.addAttribute("message","<h1>wocao</h1>");
        model.addAttribute("users", Arrays.asList("gcx","wocao"));
        return "test";
    }
}
