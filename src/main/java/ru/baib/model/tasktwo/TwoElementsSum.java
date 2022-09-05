package ru.baib.model.tasktwo;

import java.util.Arrays;

public class TwoElementsSum {
    public Integer[] findElements(Integer[] input, int sum) {
        Integer[] result = new Integer[2];
        Arrays.sort(input);
        int left = 0;
        int right = input.length - 1;

        while (left < right) {
            if (input[left] + input[right] == sum) {
                result[0] = input[left];
                result[1] = input[right];
                break;
            } else if (input[left] + input[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
