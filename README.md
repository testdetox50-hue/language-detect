# language-detect

A small Java project that detects the language of a text using stop-word matching.
Supports English, Spanish, French, German, Italian and Portuguese.

## Build and run (JDK 8+)

```
javac --release 8 -d out src/main/java/com/example/langdetect/*.java
java -cp out com.example.langdetect.Main "This is a sample sentence"
```

## Test

```
javac --release 8 -cp out -d out src/test/java/com/example/langdetect/*.java
java -cp out com.example.langdetect.LanguageDetectorTest
```

## Python version

```
python python/language_detector.py "Le chat est dans la maison"
python python/tests/test_language_detector.py
```
