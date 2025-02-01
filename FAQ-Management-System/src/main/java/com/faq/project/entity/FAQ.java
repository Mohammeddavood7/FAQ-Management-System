package com.faq.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FAQ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String answer;
    private String questionHi;
    private String questionBn;

    public FAQ() {}

    public FAQ(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionHi() {
		return questionHi;
	}

	public String getQuestionBn() {
		return questionBn;
	}

	public String getTranslatedQuestion(String lang) {
        switch (lang) {
            case "hi": return questionHi != null ? questionHi : question;
            case "bn": return questionBn != null ? questionBn : question;
            default: return question;
        }
    }

    public void setQuestionHi(String questionHi) {
        this.questionHi = questionHi;
    }

    public void setQuestionBn(String questionBn) {
        this.questionBn = questionBn;
    }
}
