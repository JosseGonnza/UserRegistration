package org.jossegonnza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserTest {

    @Test
    public void test_register_user() {
        //Arrange
        String email = "test@example.com";
        String password = "Password_test";
        RegisterUser registerUser = new RegisterUser();

        //Act
        User user = registerUser.register(email, password);

        //Assert
        Assertions.assertNotNull(user);
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertTrue(user.getId() != null && !user.getId().isEmpty());
    }

    @Test
    public void register_with_short_password() {
        //Arrange
        RegisterUser registerUser = new RegisterUser();
        String password = "Pass";
        String email = "test@example.com";

        //Act
        User user = registerUser.register(email, password);

        //Assert
        Assertions.assertFalse(registerUser.isValidPassword(password));
    }

}