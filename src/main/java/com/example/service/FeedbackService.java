package com.example.service;
import com.example.model.FeedbackModal;

import java.util.List;
public interface FeedbackService {
    FeedbackModal saveFeedback(FeedbackModal Feedback);
    List<FeedbackModal> listFeedbacks();
    FeedbackModal findFeedbackById(FeedbackModal Feedback);
    FeedbackModal updateFeedback(FeedbackModal Feedback);
    void deleteFeedback(FeedbackModal Feedback);
}
