package com.faq.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faq.project.entity.FAQ;
import com.faq.project.repository.FAQRepository;
import com.faq.project.response.FAQResponse;
import com.faq.project.service.TranslationService;

@RestController
@RequestMapping("/api/faqs")
public class FAQController {
    @Autowired
    private FAQRepository faqRepository;

    @Autowired
    private TranslationService translationService;

    @GetMapping
    public ResponseEntity<List<FAQResponse>> getFAQs(@RequestParam(defaultValue = "en") String lang) {
        List<FAQ> faqs = faqRepository.findAll();
        List<FAQResponse> response = faqs.stream().map(faq -> {
            String translatedQuestion = faq.getTranslatedQuestion(lang);
            return new FAQResponse(translatedQuestion, faq.getAnswer());
        }).toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<FAQ> createFAQ(@RequestBody FAQ faq) {
        FAQ savedFAQ = faqRepository.save(faq);

        // Translate questions asynchronously
        String translatedHi = translationService.translateText(faq.getQuestion(), "hi");
        String translatedBn = translationService.translateText(faq.getQuestion(), "bn");

        savedFAQ.setQuestionHi(translatedHi);
        savedFAQ.setQuestionBn(translatedBn);

        faqRepository.save(savedFAQ); // Save translations to database

        return ResponseEntity.status(201).body(savedFAQ);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFAQ(@PathVariable Long id) {
        faqRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

