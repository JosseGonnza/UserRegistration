package org.jossegonnza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}