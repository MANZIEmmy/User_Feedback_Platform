package com.example.controller;

import com.example.model.FeedbackModal;
import com.example.model.UserModel;
import com.example.serviceImplementation.FeedbackServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
//@RequestMapping("/feedback")
public class FeedbackController {
	
    @Autowired
    FeedbackServiceImplementation service;

    @PostMapping("/Feedback/list")
    public String savefeedback(FeedbackModal feedback, Model model, RedirectAttributes ra){
        try {
            FeedbackModal savedfeedback = service.saveFeedback(feedback);
            model.addAttribute("feedback", savedfeedback);
            ra.addFlashAttribute("message", "Request sent successfully");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/feedback/list";
    }
    @GetMapping("/feedback/edit/{id}")
    public String editRequest(@PathVariable("id") FeedbackModal id, Model model, RedirectAttributes ra){
        try {
            FeedbackModal savedfeedback = service.findFeedbackById(id);
            model.addAttribute("feedback", savedfeedback);
            model.addAttribute("pageTitle","edit feedback");
            ra.addFlashAttribute("message", "Your feedback updated successfully");
            return "Editfeedback";
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "redirect:/feedback/list";
    }

    @PostMapping("/feedback/edit")
    public String editfeedback(FeedbackModal feedback, Model model, RedirectAttributes ra){
        try {
            FeedbackModal savedfeedback = service.saveFeedback(feedback);
            model.addAttribute("feedback", savedfeedback);
            model.addAttribute("pageTitle","Edit feedback");
            ra.addFlashAttribute("message", "Request sent successfully");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/feedback/list";
    }

    @GetMapping("/feedback/list")
    public String displayfeedbacks(Model model){
        try {
            List<FeedbackModal> listfeedback = service.listFeedbacks();
            model.addAttribute("listfeedback", listfeedback);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "feedbackCrud";
    }

    @GetMapping("/feedback/delete/{id}")
    public String deletefeedbackForm(@PathVariable("id") FeedbackModal id, Model model, RedirectAttributes ra){
        try{
            service.deleteFeedback(id);
            ra.addFlashAttribute("message","feedback successfully deleted");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/feedback/list";
    }

}
