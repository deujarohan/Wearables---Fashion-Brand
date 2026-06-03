package com.wearables.wearables.controller;

import com.wearables.wearables.dto.SubscriberForm;
import com.wearables.wearables.exception.DuplicateSubscriberException;
import com.wearables.wearables.service.PageContentService;
import com.wearables.wearables.service.SubscriberService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SubscriberController {

    private final SubscriberService subscriberService;
    private final PageContentService pageContentService;

    public SubscriberController(SubscriberService subscriberService, PageContentService pageContentService) {
        this.subscriberService = subscriberService;
        this.pageContentService = pageContentService;
    }

    @PostMapping("/subscribe")
    public String subscribe(
            @Valid @ModelAttribute("subscriberForm") SubscriberForm subscriberForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("validationMessage", bindingResult.getFieldError("email").getDefaultMessage());
            addPageContent(model);
            return "index";
        }

        try {
            subscriberService.subscribe(subscriberForm.getEmail());
            redirectAttributes.addFlashAttribute("successMessage", "Thank you for subscribing to Wearables.");
            return "redirect:/#newsletter";
        } catch (DuplicateSubscriberException exception) {
            model.addAttribute("validationMessage", exception.getMessage());
            addPageContent(model);
            return "index";
        }
    }

    private void addPageContent(Model model) {
        model.addAttribute("collections", pageContentService.getCollections());
        model.addAttribute("articles", pageContentService.getArticles());
    }
}
