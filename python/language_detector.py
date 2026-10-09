"""Detects a text's language by counting common stop words per language."""
import re
import sys

STOP_WORDS = {
    "English": "the and is are of to in that it with for this was you",
    "Spanish": "el la los las de que y en un una es por con para",
    "French": "le la les des et est un une du que dans pour pas vous",
    "German": "der die das und ist nicht ein eine ich mit zu den von sie",
    "Italian": "il lo gli di che e un una per con non sono della come",
    "Portuguese": "o os as de que e um uma para com nao em do da",
}
STOP_WORDS = {lang: set(words.split()) for lang, words in STOP_WORDS.items()}


def detect(text):
    """Return the best-matching language, or "Unknown" if nothing matches."""
    if not text or not text.strip():
        return "Unknown"
    tokens = re.findall(r"[^\W\d_]+", text.lower())
    best, best_score = "Unknown", 0
    for lang, words in STOP_WORDS.items():
        score = sum(1 for t in tokens if t in words)
        if score > best_score:
            best, best_score = lang, score
    return best


if __name__ == "__main__":
    if len(sys.argv) < 2:
        sys.exit('Usage: python language_detector.py "text to analyze"')
    print(detect(" ".join(sys.argv[1:])))
