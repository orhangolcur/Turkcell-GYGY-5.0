package com.turkcell.library_cqrs_app.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs_app.application.features.auth.command.login.LoginCommand;
import com.turkcell.library_cqrs_app.application.features.auth.command.login.LoginResponse;
import com.turkcell.library_cqrs_app.application.features.auth.command.register.RegisterCommand;
import com.turkcell.library_cqrs_app.application.features.auth.command.register.RegisterResponse;
import com.turkcell.library_cqrs_app.core.mediator.Mediator;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final Mediator mediator;

    public AuthController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterCommand command) {
        return mediator.send(command);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginCommand command) {
        return mediator.send(command);
    }
}
