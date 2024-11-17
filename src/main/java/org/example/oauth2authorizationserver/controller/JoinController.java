package org.example.oauth2authorizationserver.controller;

import lombok.RequiredArgsConstructor;
import org.example.oauth2authorizationserver.dto.UserDTO;
import org.example.oauth2authorizationserver.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final UserService userService;

    @GetMapping("/join")
    public String joinPage() {
        return "joinPage";
    }

    @PostMapping("/join")
    @ResponseBody
    public String join(UserDTO userDTO) {
        userService.join(userDTO);
        return "ok";
    }
}
