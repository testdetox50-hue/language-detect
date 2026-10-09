package com.example.langdetect;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java com.example.langdetect.Main \"text to analyze\"");
            System.exit(1);
        }
        System.out.println(new LanguageDetector().detect(String.join(" ", args)));
    }
}
