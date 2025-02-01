package com.faq.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faq.project.entity.FAQ;

public interface FAQRepository extends JpaRepository<FAQ, Long> {}
