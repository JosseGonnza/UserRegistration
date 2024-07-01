package org.jossegonnza;

import java.util.UUID;
import java.util.regex.Pattern;

public class RegisterUser {

    public User register(String email, String password) {
        String userId = String.valueOf(UUID.randomUUID());

        isValidPassword(password);
        isValidEmail(email);

        return new User(userId, email);
    }

    public boolean isValidPassword(String password) {
        if (password.length() > 8 && password.contains("_")) {
            return true;
        }
        return false;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9-_.]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
