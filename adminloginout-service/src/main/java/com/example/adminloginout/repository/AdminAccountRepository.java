package com.example.adminloginout.repository;

import com.example.adminloginout.model.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccount,Long> {
    AdminAccount findByUsername(String username);
}
