package com.wearables.wearables.controller;

import com.wearables.wearables.dto.SubscriberForm;
import com.wearables.wearables.service.PageContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PageContentService pageContentService;

    public HomeController(PageContentService pageContentService) {
        this.pageContentService = pageContentService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (!model.containsAttribute("subscriberForm")) {
            model.addAttribute("subscriberForm", new SubscriberForm());
        }

        model.addAttribute("collections", pageContentService.getCollections());
        model.addAttribute("articles", pageContentService.getArticles());

        return "index";
    }
}
