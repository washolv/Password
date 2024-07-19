package com.itau.password.core.passwordrules;

import com.itau.password.core.ports.PasswordRule;

public class CapitalLetterRule implements PasswordRule {
    @Override
    public boolean validateRule(String password) {
        for (Character c: password.toCharArray()){
            if(Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }
}
