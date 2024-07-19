package com.itau.password.core.usecases;

import com.itau.password.core.ports.Password;
import com.itau.password.core.rules.PasswordRule;
import com.itau.password.core.rules.impl.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PasswordUseCase implements Password {
    @Override
    public boolean validatePassword(String password) {
        List<PasswordRule> rules = Arrays.asList(
                new MinLengthRule(),
                new SmallLetterRule(),
                new DuplicateCharRule(),
                new CapitalLetterRule(),
                new SpecialCharRule());
        return rules.stream().allMatch((rule) -> rule.validateRule(password));
    }
}
