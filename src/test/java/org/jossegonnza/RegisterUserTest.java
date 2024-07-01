package org.jossegonnza;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RegisterUserTest {

    @Test
    public void should_return_a_new_user() {
        //Given
        String email = "test@example.com";
        String password = "Password_test";
        RegisterUser registerUser = new RegisterUser();

        //When
        User user = registerUser.register(email, password);

        //Then
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(email).isEqualTo(user.getEmail());
        Assertions.assertThat(user.getId()).isNotNull();
        Assertions.assertThat(user.getId()).isNotEmpty();
    }

    @Test
    public void should_contained_at_least_8_characters() {
        //Given
        RegisterUser registerUser = new RegisterUser();
        String password = "Pass";
        String email = "test@example.com";

        //When
        User user = registerUser.register(email, password);

        //Then
        Assertions.assertThat(registerUser.isValidPassword(password)).isEqualTo(false);
    }

    @Test
    public void should_be_contained_an_underscore() {
        //Given
        RegisterUser registerUser = new RegisterUser();
        String password = "Password_";
        String email = "test@example.com";

        //When
        User user = registerUser.register(email, password);

        //Then
        Assertions.assertThat(registerUser.isValidPassword(password)).isEqualTo(true);
    }
}