package com.example.langdetect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Detects a text's language by counting common stop words per language. */
public class LanguageDetector {

    private final Map<String, Set<String>> stopWords = new HashMap<>();

    public LanguageDetector() {
        add("English", "the", "and", "is", "are", "of", "to", "in", "that", "it", "with", "for", "this", "was", "you");
        add("Spanish", "el", "la", "los", "las", "de", "que", "y", "en", "un", "una", "es", "por", "con", "para");
        add("French", "le", "la", "les", "des", "et", "est", "un", "une", "du", "que", "dans", "pour", "pas", "vous");
        add("German", "der", "die", "das", "und", "ist", "nicht", "ein", "eine", "ich", "mit", "zu", "den", "von", "sie");
        add("Italian", "il", "lo", "gli", "di", "che", "e", "un", "una", "per", "con", "non", "sono", "della", "come");
        add("Portuguese", "o", "os", "as", "de", "que", "e", "um", "uma", "para", "com", "nao", "em", "do", "da");
    }

    private void add(String language, String... words) {
        stopWords.put(language, new HashSet<>(Arrays.asList(words)));
    }

    /** Returns the best-matching language, or "Unknown" if nothing matches. */
    public String detect(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "Unknown";
        }
        String[] tokens = text.toLowerCase(java.util.Locale.ROOT).split("[^\\p{L}]+");
        String best = "Unknown";
        int bestScore = 0;
        for (Map.Entry<String, Set<String>> entry : stopWords.entrySet()) {
            int score = 0;
            for (String token : tokens) {
                if (entry.getValue().contains(token)) {
                    score++;
                }
            }
            if (score > bestScore) {
                bestScore = score;
                best = entry.getKey();
            }
        }
        return best;
    }
}
