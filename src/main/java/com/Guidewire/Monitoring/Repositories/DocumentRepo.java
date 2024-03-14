package com.Guidewire.Monitoring.Repositories;

import com.Guidewire.Monitoring.Entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.Date;
import java.util.List;

@Repository
public interface DocumentRepo extends JpaRepository<Document,String>, PagingAndSortingRepository<Document,String> {
    List<Document> findByTimestampBetween(Date start, Date end);
    List<Document> findDocumentsByGwLinkedObject(String id);
}
