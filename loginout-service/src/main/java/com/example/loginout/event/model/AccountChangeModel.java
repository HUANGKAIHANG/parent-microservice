package com.example.loginout.event.model;

import com.example.loginout.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountChangeModel {

    private String username;
    private String password;
    private AccountType accountType;

}
