package ru.baib.model.taskthree;

public class FuzzySearch {

    public static void main(String[] args) {
        FuzzySearch fuzzySearcher = new FuzzySearch();
        fuzzySearcher.outputResult("car", "ca6$$#_rtwheel", fuzzySearcher);
        fuzzySearcher.outputResult("cwhl", "cartwheel", fuzzySearcher);
        fuzzySearcher.outputResult("cwhee", "cartwheel", fuzzySearcher);
        fuzzySearcher.outputResult("cartwheel", "cartwheel", fuzzySearcher);
        fuzzySearcher.outputResult("cwheeel", "cartwheel", fuzzySearcher);
        fuzzySearcher.outputResult("lw", "cartwheel", fuzzySearcher);
        fuzzySearcher.outputResult("asd", "", fuzzySearcher);
    }

    public void outputResult(String detect, String original, FuzzySearch fuzzySearcher) {
        System.out.println("Is string \"" + detect + "\"" + " is fuzzy found in string \"" + original + "\": "
                + fuzzySearcher.fuzzySearch(detect, original));
    }

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
