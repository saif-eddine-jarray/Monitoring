package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Submission;
import com.Guidewire.Monitoring.Repositories.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {
    @Autowired
    SubmissionRepo submissionRepo;
    public Submission createSubmission(String id){
        Submission submission=new Submission();
        submission.setId(id);
        return submissionRepo.save(submission);
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepo.findAll();
    }

    public Submission getSubmissionById(String id) {
        Optional<Submission> optionalSubmission = submissionRepo.findById(id);
        return optionalSubmission.orElse(null);
    }




}
