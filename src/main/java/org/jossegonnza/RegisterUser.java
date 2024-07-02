package org.jossegonnza;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class RegisterUser {

    List<String> emailsList = new ArrayList<>();

    public User register(String email, String password) {
        String userId = String.valueOf(UUID.randomUUID());

        userValidator(email, password);

        return new User(userId, email);
    }

    public boolean isValidPassword(String password) {
        if (password.length() > 8 && password.contains("_")) {
            return true;
        }
        throw new IllegalArgumentException("Password does not meet security requirements.");
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9-_.]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (pattern.matcher(email).matches()) {
            return true;
        }
        throw new IllegalArgumentException("Invalid email format.");
    }

    public boolean isUniqueEmail(String email) {
        emailsList.add(email);
        if (!emailsList.contains(email)) {
            return true;
        }
        throw new IllegalArgumentException("Email is already in use.");
    }

    public boolean userValidator(String email, String password) {
        if (isValidPassword(password) && isValidEmail(email) && isUniqueEmail(email)) {
            return true;
        }
        throw new IllegalArgumentException("Is not possible create user.");
    }
}
