package org.example.oauth2authorizationserver.controller;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.example.oauth2authorizationserver.dto.RegisterDTO;
import org.example.oauth2authorizationserver.entity.RegisterEntity;
import org.example.oauth2authorizationserver.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public RegisterEntity register(RegisterDTO registerDTO) {
        return registerService.register(registerDTO);
    }
}
