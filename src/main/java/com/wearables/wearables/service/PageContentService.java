package com.wearables.wearables.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PageContentService {

    public List<Map<String, String>> getCollections() {
        return List.of(
                Map.of("name", "Women's Collection", "description", "Fluid tailoring, silk essentials, and evening silhouettes."),
                Map.of("name", "Men's Collection", "description", "Sharp suiting, textured outerwear, and refined wardrobe staples."),
                Map.of("name", "Accessories Collection", "description", "Statement pieces, heirloom-inspired jewelry, and sculptural bags.")
        );
    }

    public List<Map<String, String>> getArticles() {
        return List.of(
                Map.of("title", "Summer Fashion Trends 2026", "tag", "Trend Report", "summary", "Light tailoring, luminous fabrics, and resort-ready layers define the season."),
                Map.of("title", "Sustainable Luxury Fashion", "tag", "Craft", "summary", "A closer look at slow fashion, ethical sourcing, and investment dressing."),
                Map.of("title", "Fashion Week Highlights", "tag", "Runway", "summary", "The standout silhouettes, palettes, and styling ideas from global fashion week.")
        );
    }
}
