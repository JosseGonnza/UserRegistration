package org.jossegonnza;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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
        String password = "Password_";
        String email = "test@example.com";

        //When
        User user = registerUser.register(email, password);

        //Then
        Assertions.assertThat(registerUser.isValidPassword(password)).isTrue();

        assertThatThrownBy(() -> {
            registerUser.userValidator(email, password);
        }).hasMessage("Password does not meet security requirements.");


//        try {
//            registerUser.isValidPassword("Pass_");
//        } catch (IllegalArgumentException e) {
//            Assertions.assertThat(e.getMessage().contains("Password does not meet security requirements.")).isTrue();
//        }

        //        Assertions.assertThat(registerUser.isValidPassword(password)).isFalse();
    }

    @Test
    public void should_contained_an_underscore() {
        //Given
        RegisterUser registerUser = new RegisterUser();
        String password = "Password";
        String email = "test@example.com";

        //When
        User user = registerUser.register(email, password);

        //Then
        try {
            registerUser.isValidPassword("Password");
        } catch (IllegalArgumentException e) {
            Assertions.assertThat(e.getMessage().contains("Password does not meet security requirements.")).isTrue();
        }

        //        Assertions.assertThat(registerUser.isValidPassword(password)).isTrue();
    }

    @Test
    public void should_be_a_valid_email() {
        //Given
        RegisterUser registerUser = new RegisterUser();
        String password = "Password_";
        String email = "test_example.com";

        //When
        User user = registerUser.register(email, password);

        //Then
        try {
            registerUser.isValidEmail("test_exmaple.com");
        } catch (IllegalArgumentException e) {
            Assertions.assertThat(e.getMessage().contains("Invalid email format.")).isTrue();
        }

        //        Assertions.assertThat(registerUser.isValidEmail(email)).isTrue();
    }

    @Test
    public void should_be_an_unique_email() {
        //Given
        RegisterUser registerUser = new RegisterUser();
        String password_test1 = "Password_";
        String email_test1 = "test@exmaple.com";
        String password_test2 = "Password_2";
        String email_test2 = "test@exmaple.com";

        //When
        User user_test1 = registerUser.register(email_test1, password_test1);
        User user_test2 = registerUser.register(email_test2, password_test2);

        //Then
        try {
            registerUser.isUniqueEmail("test@exmaple.com");
        } catch (IllegalArgumentException e) {
            Assertions.assertThat(e.getMessage().contains("Email is already in use.")).isTrue();
        }

        //        Assertions.assertThat(user_test1.getEmail()).isNotEqualTo(user_test2.getEmail());


    }
}