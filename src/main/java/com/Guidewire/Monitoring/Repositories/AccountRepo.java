package com.Guidewire.Monitoring.Repositories;

import com.Guidewire.Monitoring.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,String> {
}
