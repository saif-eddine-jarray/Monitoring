package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Submission;
import com.Guidewire.Monitoring.Repositories.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {
    @Autowired
    SubmissionRepo submissionRepo;
    public Submission createSubmission(String id){
        Submission submission=new Submission();
        submission.setId(id);
        return submissionRepo.save(submission);
    }
}
