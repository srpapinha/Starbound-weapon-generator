package com.starbound_api.api.controller;

import org.springframework.stereotype.Controller;

@Controller
public class WebPageController {
    public String home() {
        return "index.html";
    }
}
