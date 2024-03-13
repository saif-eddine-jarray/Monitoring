package com.Guidewire.Monitoring.Services.Interfaces;

import com.Guidewire.Monitoring.Entities.Account;

import java.util.List;

public interface I_Account {
    Account createAccount(String id);

    List<Account> getAllAccounts();

    Account getAccountById(String id);
}
