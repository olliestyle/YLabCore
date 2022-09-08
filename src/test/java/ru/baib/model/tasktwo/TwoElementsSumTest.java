package ru.baib.model.tasktwo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TwoElementsSumTest {

    @Test
    public void whenSumFound1() {
        Integer[] input = new Integer[]{3, 4, 2, 7};
        Integer[] expected = new Integer[]{3, 7};
        Integer[] actual = new TwoElementsSum().findElements(input, 10);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSumFound2() {
        Integer[] input = new Integer[]{3, 4, 2, 7, 2, 5, 15};
        Integer[] expected = new Integer[]{2, 2};
        Integer[] actual = new TwoElementsSum().findElements(input, 4);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSumFound3() {
        Integer[] input = new Integer[]{3, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Integer[] expected = new Integer[]{3, 7};
        Integer[] actual = new TwoElementsSum().findElements(input, 10);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenNoElements() {
        Integer[] input = new Integer[]{};
        Integer[] expected = new Integer[]{null, null};
        Integer[] actual = new TwoElementsSum().findElements(input, 10);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenSumNotFound() {
        Integer[] input = new Integer[]{3, 4, 2, 7};
        Integer[] expected = new Integer[]{null, null};
        Integer[] actual = new TwoElementsSum().findElements(input, 50);
        assertThat(actual, is(expected));
    }

}