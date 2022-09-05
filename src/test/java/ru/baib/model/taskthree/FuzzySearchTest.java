package ru.baib.model.taskthree;

import org.junit.Test;

import static org.junit.Assert.*;

public class FuzzySearchTest {

    @Test
    public void tests() {
        FuzzySearch fuzzySearcher = new FuzzySearch();
        assertTrue(fuzzySearcher.fuzzySearch("car", "ca6$$#_rtwheel"));
        assertTrue(fuzzySearcher.fuzzySearch("cwhl", "cartwheel"));
        assertTrue(fuzzySearcher.fuzzySearch("cwhee", "cartwheel"));
        assertTrue(fuzzySearcher.fuzzySearch("cartwheel", "cartwheel"));
        assertTrue(fuzzySearcher.fuzzySearch("", ""));
        assertFalse(fuzzySearcher.fuzzySearch("cwheeel", "cartwheel"));
        assertFalse(fuzzySearcher.fuzzySearch("lw", "cartwheel"));
        assertFalse(fuzzySearcher.fuzzySearch("asd", ""));
    }
}