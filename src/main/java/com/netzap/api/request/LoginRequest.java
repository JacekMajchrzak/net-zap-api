package com.netzap.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {
    private String login;
    private String pass;

    @JsonCreator
    public LoginRequest(@JsonProperty("login") String login,@JsonProperty("pass") String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}
