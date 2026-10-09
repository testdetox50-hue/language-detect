import os
import sys
import unittest

sys.path.insert(0, os.path.join(os.path.dirname(__file__), ".."))
from language_detector import detect


class DetectTest(unittest.TestCase):
    def test_languages(self):
        cases = {
            "English": "This is the best day of the year and you know it",
            "Spanish": "El perro es una mascota que vive en la casa",
            "French": "Le chat est dans la maison et vous le voyez",
            "German": "Ich habe das Buch nicht und er ist ein Freund",
            "Unknown": "",
        }
        for expected, text in cases.items():
            self.assertEqual(expected, detect(text))


if __name__ == "__main__":
    unittest.main()
