package com.wearables.wearables.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SubscriberForm {

    @NotBlank(message = "Please enter your email address.")
    @Email(message = "Please enter a valid email address.")
    private String email;

    public SubscriberForm() {
    }

    public SubscriberForm(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
