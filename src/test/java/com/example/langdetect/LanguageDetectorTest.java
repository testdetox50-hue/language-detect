package com.example.langdetect;

public class LanguageDetectorTest {
    public static void main(String[] args) {
        LanguageDetector d = new LanguageDetector();
        check("English", d.detect("This is the best day of the year and you know it"));
        check("Spanish", d.detect("El perro es una mascota que vive en la casa"));
        check("French", d.detect("Le chat est dans la maison et vous le voyez"));
        check("German", d.detect("Ich habe das Buch nicht und er ist ein Freund"));
        check("Unknown", d.detect(""));
        System.out.println("All tests passed");
    }

    private static void check(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected " + expected + " but got " + actual);
        }
    }
}
