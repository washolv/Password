package com.itau.password.core.rules.impl;

import com.itau.password.core.rules.PasswordRule;

import java.util.ArrayList;
import java.util.List;

public class DuplicateCharRule implements PasswordRule {
    @Override
    public boolean validateRule(String password) {
        List<Character> characterList = new ArrayList<>();
        for(Character c: password.toCharArray()){
            if(characterList.contains(c)){
                return false;
            }
            characterList.add(c);
        }
        return true;
    }
}
