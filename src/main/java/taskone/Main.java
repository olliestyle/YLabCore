package taskone;

import java.util.Scanner;

/**
 * Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение.
 */

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello. This program fills 2D array and show min, max, and average values ");
        System.out.println("Please enter count of rows");
        int rows = scanner.nextInt();
        System.out.println("Please enter count of columns");
        int columns = scanner.nextInt();
        int[][] array = main.getArray(rows, columns);
        System.out.println("Genarated array: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Max value in array is: " + main.maxValue(array));
        System.out.println("Min value in array is: " + main.minValue(array));
        System.out.println("Average value in array is: " + main.averageValue(array));
    }

    private int[][] getArray(int rows, int columns) {
        int[][] result = new int[rows][columns];
        int max = 99;
        int last = (int) (System.currentTimeMillis() % max);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                last = (last * 32719 + 3) % 32749;
                result[i][j] = last % max;
            }
        }
        return result;
    }

    private int maxValue(int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    private int minValue(int[][] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    private int averageValue(int[][] array) {
        int accumulator = 0;
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                accumulator += array[i][j];
                size++;
            }
        }
        return accumulator / size;
    }

}
