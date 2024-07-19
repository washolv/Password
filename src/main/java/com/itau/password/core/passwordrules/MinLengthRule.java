package com.itau.password.core.passwordrules;

import com.itau.password.core.ports.PasswordRule;

public class MinLengthRule implements PasswordRule {
    private final int MIN_LENGTH = 9;

    @Override
    public boolean validateRule(String password) {
        return password.length() >= MIN_LENGTH ;
    }
}
