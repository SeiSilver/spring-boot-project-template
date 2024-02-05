package com.spring.template.silver.app.entrypoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalController {

  @GetMapping({"", "/", "swagger-ui"})
  public String home() {
    return "redirect:/swagger-ui/index.html";
  }

}
