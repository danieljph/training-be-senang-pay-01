package com.doku.my.trainingbesenangpay01.module.intermediate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Controller
public class WelcomeController
{
    @GetMapping("/welcome")
    public String welcome(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("message", "[WelcomeController] Hi " + name + "!");
        return "welcome"; // This resolves to /WEB-INF/jsp/welcome.jsp
    }
}
