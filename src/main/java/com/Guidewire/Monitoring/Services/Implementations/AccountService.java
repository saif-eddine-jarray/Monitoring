package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Account;
import com.Guidewire.Monitoring.Repositories.AccountRepo;
import com.Guidewire.Monitoring.Services.Interfaces.I_Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements I_Account {
    @Autowired
    AccountRepo accountRepo;

    @Override
    public Account createAccount(String id) {
        Account account = new Account();
        account.setId(id);
        return accountRepo.save(account);
    }

    //    @Override
//    public List<Account> getAllAccounts() {
//        return accountRepo.findAll();
//    }
    @Override
    public Page<Account> getAllAccounts(Pageable pageable) {
        return accountRepo.findAll(pageable);
    }

    @Override
    public Account getAccountById(String id) {
        Optional<Account> optionalAccount = accountRepo.findById(id);
        return optionalAccount.orElse(null);
    }
}
