package com.Form.MyForm.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Form.MyForm.entity.UserDetails;
import com.Form.MyForm.repository.UserRepository;
import com.Form.MyForm.service.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

    @Autowired
    private UserRepository ur;

    @Autowired
    private UserServices us;

    @GetMapping("/")
    public String home() {
        return "index";  // This should correspond to your index view
    }

    @PostMapping("/registers")
    public String registers(@ModelAttribute UserDetails ud, HttpSession session) {
        // Save the user details including full name and email
        ur.save(ud);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new UserDetails());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserDetails user, HttpSession session) {
        // Check username and password
        UserDetails oauthUser = us.login(user.getUsername(), user.getPassword());

        if (Objects.nonNull(oauthUser)) {
            // Store necessary details in the session
            session.setAttribute("user", oauthUser);
            session.setAttribute("username", oauthUser.getUsername());
            session.setAttribute("fullName", oauthUser.getFullName());
            session.setAttribute("email", oauthUser.getEmail());
            // Redirect to the home page after successful login
            return "redirect:/home";
        } else {
            // Return to the login page if login fails
            return "login";
        }
    }

    @GetMapping("/home")
    public ModelAndView homePage(HttpSession session) {
        ModelAndView mav = new ModelAndView("home");
        // Retrieve user details from the session
        String username = (String) session.getAttribute("username");
        String fullName = (String) session.getAttribute("fullName");
        String email = (String) session.getAttribute("email");
        // Add these details to the ModelAndView object
        mav.addObject("username", username);
        mav.addObject("fullName", fullName);
        mav.addObject("email", email);
        return mav;
    }
}
