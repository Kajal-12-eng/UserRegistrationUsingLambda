package com.bl;
import java.util.regex.Pattern;

    @FunctionalInterface
    interface ValidateUsersDetails {
    String validate(String input) throws UserValidationException;
    }
    public class UserValidation {
    /* Declaration of constants for regex pattern */

    // regex pattern for first name and last name
    private static final String NAME_PATTERN = "^[A-Z][a-z A-Z]{2,}$";
    // regex pattern for email
    private static final String EMAIL_PATTERN = "^[0-9A-Za-z]+(([._+-]?)[0-9A-Za-z]+)*" +
            "@[0-9A-Za-z]+.[a-z]{2,4}.([a-z]{2,3})*$";
    // regex pattern for mobile number
    private static final String MOBILE_PATTERN = "^[9][1]\\s[6-9][0-9]{9}$";
    // regex pattern for password
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*" +
            "[@#$%^&-+=()]).{8,}$";

    // validation of first name and last name by using lambda expression.
    ValidateUsersDetails validateName = name -> {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        try {
            if (name.length() == 0) {
                throw new UserValidationException("Please Entered the valid name");
            }
            if (pattern.matcher(name).matches()){
                return "Valid Name";
            } else {
                return "Invalid Name";
            }
        } catch (NullPointerException exception) {
            throw new UserValidationException("Please Entered Valid Name");
        }
    };

    // Validation of mobile number by using lambda expression
    ValidateUsersDetails validateMobileNumber = mobileNumber -> {
        Pattern pattern = Pattern.compile(MOBILE_PATTERN);
        try {
            if (pattern.matcher(mobileNumber).matches()) {
                return "Valid mobile number.";
            } else {
                throw new UserValidationException("Please entered the valid mobile number");
            }
        } catch (NullPointerException exception) {
            throw new UserValidationException("Please entered the valid mobile number address");
        }
    };

    // validation of Password by using lambda expression.
    ValidateUsersDetails validatePassword = password -> {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        try {
            if (!pattern.matcher(password).matches()) {
                throw new UserValidationException("Please enter the correct password");
            } else {
                return "Valid password.";
            }
        } catch (NullPointerException exception){
            throw new UserValidationException("Please enter the correct password");
        }
    };

    ValidateUsersDetails validateEmails = emails -> {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        try {
            if (pattern.matcher(emails).matches()) {
                throw new UserValidationException("Valid Email");
            } else {
                throw new UserValidationException("Please enter the correct email address");
            }
        } catch (NullPointerException exception) {
            throw new UserValidationException("Please enter the correct email address");
        }
    };
}