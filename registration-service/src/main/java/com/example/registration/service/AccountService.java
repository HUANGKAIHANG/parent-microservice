package com.example.registration.service;

import com.example.registration.model.Account;
import com.example.registration.model.AccountType;
import com.example.registration.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean usernameExists(String username) {
        Account account = accountRepository.findByUsername(username);
        if (account != null)
            return true;
        return false;
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public AccountType getAccountType(String accountType) {

        AccountType type = null;

        switch (accountType) {
            case "1":
                type = AccountType.BUYER;
                break;
            case "2":
                type = AccountType.SELLER;
                break;
            case "3":
                type = AccountType.ADMINISTRATOR;
                break;
        }
        return type;
    }
}
