package tasktwo;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9, 1, 1, 2};
        System.out.println("This program sorts array in different ways");
        System.out.println("Before bubble sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        main.bubbleSort(array);
        System.out.println("\nAfter bubble sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        main.toInitialArray(array);
        System.out.println("\nBefore quick sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        main.quickSort(array, 0, array.length - 1);
        System.out.println("\nAfter quick sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        main.toInitialArray(array);
        System.out.println("\nBefore insertion sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        main.insertionSort(array);
        System.out.println("\nAfter insertion sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        main.toInitialArray(array);
        System.out.println("\nBefore merge sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        main.mergeSort(array, 0, array.length - 1);
        System.out.println("\nAfter merge sort:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private void quickSort(int[] array, int low, int high) {
        if (array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(array, low, j);
        }
        if (high > i) {
            quickSort(array, i, high);
        }
    }

    private void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    private void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            merge(array, l, m, r);
        }
    }

    private void merge(int[] array, int l, int m, int r)  {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = array[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = array[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    private void toInitialArray(int[] array) {
        array[0] = 5;
        array[1] = 6;
        array[2] = 3;
        array[3] = 2;
        array[4] = 5;
        array[5] = 1;
        array[6] = 4;
        array[7] = 9;
        array[8] = 1;
        array[9] = 1;
        array[10] = 2;
    }
}
