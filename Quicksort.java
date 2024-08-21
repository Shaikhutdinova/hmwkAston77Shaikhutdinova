package main.java;

import java.util.Comparator;

public class Quicksort<T extends  Comparable<T>> {
        public void sort(Object[] array, int low, int high, Comparator<? super T> c) {
            if (array == null) {
                throw new NullPointerException();
            }
            if(array.length < 2) return;
            if (low < high) {
                int markerIndex = partition(array, low, high, c);
                sort(array, low, markerIndex - 1, c);
                sort(array, markerIndex + 1, high, c);
            }
        }

        private int partition(Object[] array, int low, int high, Comparator<? super T> c) {
            T marker = (T) array[high];
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (c.compare((T) array[j], marker) <= 0) {
                    i++;
                    swap(array, i, j);
                }
            }

            swap(array, i + 1, high);
            return i + 1;
        }

        private void swap(Object[] array, int i, int j) {
            Object temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 5, 6};
        Quicksort<Integer> quicksort = new Quicksort<>();
        quicksort.sort(numbers, 0, numbers.length - 1, Comparator.naturalOrder());
        System.out.println("Sorted integers: " + java.util.Arrays.toString(numbers));
    }
}
