package com.faq.project.response;

public class FAQResponse {
    private String question;
    private String answer;

    public FAQResponse(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
