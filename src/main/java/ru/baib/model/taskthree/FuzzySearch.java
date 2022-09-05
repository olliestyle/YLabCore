package ru.baib.model.taskthree;

public class FuzzySearch {
    public boolean fuzzySearch(String detect, String original) {
        int detectLength = detect.length();
        int originalLength = original.length();

        if (detectLength > originalLength) {
            return false;
        }

        int detectCount = 0;
        int originalCount = 0;
        char[] detectArray = detect.toCharArray();
        char[] originalArray = original.toCharArray();

        for (int i = 0; i < original.length(); i++) {
            if (detectCount == detectLength) {
                break;
            }
            if (detectArray[detectCount] == originalArray[originalCount]) {
                detectCount++;
            }
            originalCount++;
        }

        return detectCount == detectLength;
    }
}
