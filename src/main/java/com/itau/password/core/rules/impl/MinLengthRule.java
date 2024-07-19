package com.itau.password.core.rules.impl;

import com.itau.password.core.rules.PasswordRule;

public class MinLengthRule implements PasswordRule {
    private final int MIN_LENGTH = 9;

    @Override
    public boolean validateRule(String password) {
        return password.length() >= MIN_LENGTH ;
    }
}
