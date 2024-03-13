package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Account;
import com.Guidewire.Monitoring.Repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepo accountRepo;
    public Account createAccount(String id){
        Account account = new Account();
        account.setId(id);
        return accountRepo.save(account);
    }
}
