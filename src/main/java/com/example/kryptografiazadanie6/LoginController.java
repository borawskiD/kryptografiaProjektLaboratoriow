package com.example.kryptografiazadanie6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    UserRepository userRepository;
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String login(String loginInput, String passwordInput, Model model){
        if(loginInput == null || passwordInput == null){
            model.addAttribute("LoginError", "Nieprawidlowy login i/lub haslo");
            return "index";
        }
        if (loginInput.equals("admin") && passwordInput.equals("slodkipiesek112")){
            return "catchMe";
        }

        UserEntity userEntity = userRepository.findByLogin(loginInput);
        if(userEntity == null){
            model.addAttribute("LoginError", "Nieprawidlowy login i/lub haslo");
            return "index";
        }

        if(!userEntity.getPassword().equals(passwordInput)){
            model.addAttribute("LoginError", "Nieprawidlowy login i/lub haslo");
            return "index";
        }
        return "userPanel";
    }
}
