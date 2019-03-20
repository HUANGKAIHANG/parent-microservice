package com.example.loginout.service;

import com.example.loginout.model.Account;
import com.example.loginout.model.AccountType;
import com.example.loginout.repository.AccountRepository;
import com.example.loginout.tools.CipherText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean usernameExists(String username) {
        Account account = accountRepository.findByUsername(username);
        return account != null;
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
        }
        return type;
    }

    public boolean validAccount(String username, String password, String accountType) {
        Account account = accountRepository.findByUsername(username);
        return (account.getPassword().equals(CipherText.getCipherText(password))
                && account.getAccountType() == this.getAccountType(accountType));
    }
}
