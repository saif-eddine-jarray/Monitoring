package com.Guidewire.Monitoring.Repositories;

import com.Guidewire.Monitoring.Entities.Rms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RmsRepo extends JpaRepository<Rms,String> {
}
