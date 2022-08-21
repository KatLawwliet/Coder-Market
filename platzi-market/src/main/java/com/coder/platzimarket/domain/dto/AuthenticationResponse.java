package com.coder.platzimarket.domain.dto;

public class AuthenticationResponse {

    private String jwt;

    public AuthenticationResponse(String jwt)
            {this.jwt = jwt;}


    // Getters and Setters

    public String getJwt() {return jwt;}
    public void setJwt(String jwt) {this.jwt = jwt;}


}
