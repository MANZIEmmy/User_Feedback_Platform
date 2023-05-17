package com.example.serviceImplementation;

import com.example.model.ClientModel;
import com.example.model.FeedbackModal;
import com.example.model.FeedbackModal;
import com.example.repository.FeedbackRepository;
import com.example.service.ClientService;
import com.example.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackServiceImplementation implements FeedbackService {
    @Autowired
    FeedbackRepository repo;

    @Override
    public FeedbackModal saveFeedback(FeedbackModal Feedback) {
        return repo.save(Feedback);
    }

    @Override
    public List<FeedbackModal> listFeedbacks() {
        return repo.findAll();
    }

    @Override
    public FeedbackModal findFeedbackById(FeedbackModal Feedback) {
        return repo.findById(Feedback.getId()).orElse(null);
    }

    @Override
    public FeedbackModal updateFeedback(FeedbackModal Feedback) {
        FeedbackModal savedFeedback = repo.findById(Feedback.getId()).orElse(null);
        if (savedFeedback!=null){
            savedFeedback.setName(Feedback.getName());
            savedFeedback.setLecname(Feedback.getLecname());
            savedFeedback.setCoursename(Feedback.getCoursename());
            savedFeedback.setDescription(Feedback.getDescription());

            return repo.save(savedFeedback);
        }
        return repo.save(Feedback);
    }

    @Override
    public void deleteFeedback(FeedbackModal Feedback) {
        FeedbackModal savedFeedback = repo.findById(Feedback.getId()).orElse(null);
        if (savedFeedback!=null){
            repo.delete(savedFeedback);
        }
    }
}
