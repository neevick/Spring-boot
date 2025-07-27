package com.summer.library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/aboutUs")
    public String showAboutUs() {
        return "aboutus";
    }

    @GetMapping("/contact")
    public String showContact() {
        return "contact";
    }

    @GetMapping("/service")
    public String showService() {
        return "service";
    }
    @GetMapping("/pricing")
    public String showPricing() {
        return "pricing";
    }


}