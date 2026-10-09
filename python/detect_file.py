"""Detects the language of each line in a file (or stdin) and prints a summary."""
import sys
from collections import Counter

from language_detector import detect


def main(argv):
    source = open(argv[1], encoding="utf-8") if len(argv) > 1 else sys.stdin
    counts = Counter()
    with source:
        for line in source:
            line = line.strip()
            if not line:
                continue
            language = detect(line)
            counts[language] += 1
            print("%s\t%s" % (language, line))
    print("\nSummary:", dict(counts.most_common()))


if __name__ == "__main__":
    main(sys.argv)
