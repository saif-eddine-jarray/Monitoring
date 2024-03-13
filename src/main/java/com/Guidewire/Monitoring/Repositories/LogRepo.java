package com.Guidewire.Monitoring.Repositories;

import com.Guidewire.Monitoring.Entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends JpaRepository<Log,String> {
}
