package org.jossegonnza;

import java.util.UUID;

public class RegisterUser {

    public User register(String email, String password) {
        String userId = String.valueOf(UUID.randomUUID());

        isValidPassword(password);

        return new User(userId, email);
    }

    public boolean isValidPassword(String password) {
        if (password.length() > 8 && password.contains("_")) {
            return true;
        }
        return false;
    }


}
