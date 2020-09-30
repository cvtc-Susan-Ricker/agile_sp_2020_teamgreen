package edu.cvtc.agile2020.greentime.financetracker.financetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/signup", method = RequestMethod.POST)
public class SignUpController {

    @GetMapping("signup")
    public String logon(){
        return "signup";
    }

}
