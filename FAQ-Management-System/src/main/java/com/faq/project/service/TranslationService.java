package com.faq.project.service;

package com.example.faq;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

@Service
public class TranslationService {
    private final Translate translate;

    public TranslationService() {
        this.translate = TranslateOptions.getDefaultInstance().getService();
    }

    @Cacheable(value = "translations", key = "#text + '_' + #targetLang")
    public String translateText(String text, String targetLang) {
        Translation translation = translate.translate(text, Translate.TranslateOption.targetLanguage(targetLang));
        return translation.getTranslatedText();
    }
}
