package com.example.adminloginout.service;

import com.example.adminloginout.model.AdminAccount;
import com.example.adminloginout.repository.AdminAccountRepository;
import com.example.adminloginout.tools.CipherText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAccountService {

    @Autowired
    private AdminAccountRepository adminAccountRepository;

    public boolean validAdminAccount(String username, String password) {
        AdminAccount adminAccount = adminAccountRepository.findByUsername(username);
        if (adminAccount == null)
            return false;
        return adminAccount.getUsername().equals(username) &&
                adminAccount.getPassword().equals(CipherText.getCipherText(password));
    }
}
