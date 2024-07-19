package com.itau.password.core.passwordrules;

import com.itau.password.core.ports.PasswordRule;

public class SmallLetterRule implements PasswordRule {
    @Override
    public boolean validateRule(String password) {
        for (Character c: password.toCharArray()){
            if(Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }
}
