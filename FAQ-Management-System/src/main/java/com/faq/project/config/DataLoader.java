package com.faq.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.faq.project.entity.FAQ;
import com.faq.project.repository.FAQRepository;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private FAQRepository faqRepository;

    @Override
    public void run(String... args) throws Exception {
        faqRepository.save(new FAQ("What is Spring Boot?", "Spring Boot is a framework for Java."));
        faqRepository.save(new FAQ("What is Java?", "Java is a programming language."));
    }
}
