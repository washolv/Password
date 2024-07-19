package com.itau.password.core.passwordrules;

import com.itau.password.core.ports.PasswordRule;

public class SpecialCharRule implements PasswordRule {
    private final String SPECIAL_CARACTERS = "!@#$%^&*()-+";

    @Override
    public boolean validateRule(String password) {
        for(Character c: password.toCharArray()) {
            if (SPECIAL_CARACTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
