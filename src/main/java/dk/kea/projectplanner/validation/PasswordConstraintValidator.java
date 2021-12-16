/*
Author He
29.11.2021
 */

package dk.kea.projectplanner.validation;

import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
            new LengthRule(8, 30),

            new CharacterRule(EnglishCharacterData.UpperCase, 1),

            new CharacterRule(EnglishCharacterData.LowerCase, 1),

            new CharacterRule(EnglishCharacterData.Digit, 1),

            new CharacterRule(EnglishCharacterData.Special, 1),

            new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),

            new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false)

        ));
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        List<String> messages = validator.getMessages(result);

        String messageTemplate = messages.stream()
                .collect(Collectors.joining(","));
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}

// https://stackabuse.com/spring-custom-password-validation/