package edu.cvtc.agile2020.greentime.financetracker.financetracker.controller;

import edu.cvtc.agile2020.greentime.financetracker.financetracker.model.Authority;
import edu.cvtc.agile2020.greentime.financetracker.financetracker.model.AuthorityRepository;
import edu.cvtc.agile2020.greentime.financetracker.financetracker.model.User;
import edu.cvtc.agile2020.greentime.financetracker.financetracker.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/", method = RequestMethod.GET)
//TODO: Currently using GET instead of POST because POST is not working for unknown reason
public class SignUpController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @GetMapping("/signup")
    public String logon(){
        System.out.println("Signup Page");
        return "signup";
    }

    @GetMapping("/addUserSubmit")
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("AddUser");
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        ModelAndView mav = new ModelAndView("login");
        if(username.isEmpty() || password.isEmpty()) {
            //TODO: Show error message to user saying to fill all fields
        } else {
            userRepository.save(new User(username, password, 1));
            authorityRepository.save(new Authority(username, "ROLE_USER"));
            //TODO: Show success message saying user was added successfully
        }
        return mav;
    }

}
