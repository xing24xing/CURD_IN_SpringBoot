package com.TableView.TableFetch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;  // Correct import for Model

import java.util.List;

import com.TableView.TableFetch.Entity.User;
import com.TableView.TableFetch.Entity.UserDto;
import com.TableView.TableFetch.Repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class UserController {
   @Autowired 
   private UserRepository ur;
   
   @GetMapping("/")
   public String index(Model model) {
       List<User> allUsers = ur.findAll(Sort.by(Sort.Direction.DESC, "id"));
       model.addAttribute("User", allUsers);
       return "index";
   }
   
   @GetMapping("/HomePage")
   public String newHome(Model model) {
      model.addAttribute("UserDto", new UserDto()); 
      return "home";
   }
   
   @PostMapping("/AddUser")
   public String addUser(
           @Valid @ModelAttribute("UserDto") UserDto userDto, BindingResult result) {
       if (result.hasErrors()) {
           return "home";
       }
       User existingUser = ur.findByEmail(userDto.getEmail());
       if (existingUser != null) {
           result.rejectValue("email", null, "There is already a user registered with this email. Please enter a new valid email!");
           return "home";
       }
       User user = new User();
       user.setName(userDto.getName());
       user.setEmail(userDto.getEmail());
       user.setPhone(userDto.getPhone());
       user.setAge(userDto.getAge());
       ur.save(user);
       return "redirect:/";
   }
   
   @GetMapping("/edit")
   public String getEdit(Model model, @RequestParam("id") int id) {
       User user = ur.findById(id).orElse(null);
       if (user == null) {
           return "redirect:/";
       }
       UserDto userDto = new UserDto();
       userDto.setName(user.getName());
       userDto.setEmail(user.getEmail());
       userDto.setPhone(user.getPhone());
       userDto.setAge(user.getAge());
       model.addAttribute("userdto", userDto);
       model.addAttribute("userId", user.getId());
       return "EditUser";
   }
   
   @PostMapping("/edit")
   public String editDone(@RequestParam("id") int id, @Valid @ModelAttribute("userdto") UserDto userDto, BindingResult result, Model model) {
       if (result.hasErrors()) {
           model.addAttribute("userId", id);
           return "EditUser";
       }
       User user = ur.findById(id).orElse(null);
       if (user == null) {
           return "redirect:/";
       }
       user.setName(userDto.getName());
       user.setEmail(userDto.getEmail());
       user.setPhone(userDto.getPhone());
       user.setAge(userDto.getAge());
       ur.save(user);
       return "redirect:/";
   }
   
   @GetMapping("/delete")
   public String delete(@RequestParam("id") int id, Model model) {
       User user = ur.findById(id).orElse(null);
       if (user != null) {
           ur.delete(user);
           System.out.println(user);
       }
       return "redirect:/";
   }
}
