package com.shibata.user.controller.request;

import jakarta.validation.constraints.NotNull;

public class UserRequest {
    @NotNull
    private String name;

    @NotNull
    private String email;

    public UserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
