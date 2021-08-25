package com.bl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserValidationTest {
    UserValidation validation;
    @BeforeEach
    public void setup() {
        validation = new UserValidation();
    }
    @Test
    public void givenFirstName_LastNameWhenProperShouldReturnValidName() throws UserValidationException {
        String fNameResult = validation.validateName.validate("Chandradip");
        String lNameResult = validation.validateName.validate("Shivankar");
        Assertions.assertEquals("Valid Name",fNameResult);
        Assertions.assertEquals("Valid Name",lNameResult);
    }

    @DisplayName("given fist name when proper should return Valid name and when incorrect should throw an exception.")
    @Test
    public void givenFirstName_LastNameWhenShouldThrowAnException() {
        UserValidation userValidation = new UserValidation();
        try {
            String fName = validation.validateName.validate(null);
            Assertions.assertEquals("Valid Name", fName);
        } catch (Exception | UserValidationException exception) {
            System.out.println(exception);
        }
    }

    @Test
    public void givenMobileNumberWhenProperShouldReturnValidMobileNumber () throws UserValidationException {
        String mobileNumber = validation.validateMobileNumber.validate("91 9145388092");
        Assertions.assertEquals("Valid mobile number.", mobileNumber);
    }
    @DisplayName("given mobile number when proper should return Valid mobile number and when incorrect should throw an exception.")
    @Test
    public void givenMobileNumberShouldThrowAnException () {
        try {
            String mobileNumber = validation.validateMobileNumber.validate("544943569");
            Assertions.assertEquals("Valid mobile number.", mobileNumber);
        } catch (Exception | UserValidationException exception) {
            System.out.println(exception);
        }
    }

    @Test
    public void givenPasswordShouldReturnValidPassword () throws UserValidationException {
        String userPass = validation.validatePassword.validate("Dipak@124");
        Assertions.assertEquals(userPass, "Valid password.");
    }
    @Test
    public void givenPasswordShouldReturnPleaseEnteredValidPassword () {
        String userPass;
        try {
            userPass = validation.validatePassword.validate("5646j");
            Assertions.assertEquals(userPass, "Please entered valid password");
        } catch (Exception | UserValidationException exception) {
            System.out.println(exception);
        }
    }


    public void givenEmailWhenProperShouldReturnValidEmail (String email) {
        try {
            String emailAddress = validation.validateEmails.validate(email);
            Assertions.assertEquals(emailAddress, "Valid Email");
        } catch (Exception | UserValidationException exception) {
            System.out.println(exception);
        }
    }
}