package com.Guidewire.Monitoring.Repositories;

import com.Guidewire.Monitoring.Entities.Log.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends JpaRepository<Document,String> {
}
