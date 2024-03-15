package com.Guidewire.Monitoring.Services.Interfaces;

import com.Guidewire.Monitoring.Entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface I_Account {
    Account createAccount(String id);


    //    @Override
    //    public List<Account> getAllAccounts() {
    //        return accountRepo.findAll();
    //    }
    Page<Account> getAllAccounts(Pageable pageable);

    Account getAccountById(String id);
}
