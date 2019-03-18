package com.example.loginout.repository;

import com.example.loginout.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUsername(String username);
}
