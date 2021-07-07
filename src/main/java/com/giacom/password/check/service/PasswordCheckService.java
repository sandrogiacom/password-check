package com.giacom.password.check.service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.giacom.password.check.config.PasswordPolicyConfig;

@Service
public class PasswordCheckService {

    private PolicyRegex policyRegex;
    private PasswordPolicyConfig config;

    public PasswordCheckService(PolicyRegex policyRegex, PasswordPolicyConfig config) {
        this.policyRegex = policyRegex;
        this.config = config;
    }

    public boolean checkPassword(String password) {
        if (hasBlankChars(password) || hasDuplicateChars(password)) {
            return false;
        }
        String regex = policyRegex.getPolicyRegex();
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(password).matches();
    }

    private boolean hasBlankChars(String password) {
        return password == null || password.isEmpty() || password.contains("\u0020");
    }

    private boolean hasDuplicateChars(String password) {
        Set<Character> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < password.length(); i++) {
            linkedHashSet.add(password.charAt(i));
        }
        return linkedHashSet.size() < password.length();
    }

}
