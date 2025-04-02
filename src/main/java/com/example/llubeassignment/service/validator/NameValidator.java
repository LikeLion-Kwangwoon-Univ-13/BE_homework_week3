package com.example.llubeassignment.service.validator;

import org.springframework.stereotype.Component;

@Component
public class NameValidator {
    public boolean validate(String name) {
        if (name.length() <= 1 || name.contains(" ")) {
            return false;
        }
        return true;
    }
}
