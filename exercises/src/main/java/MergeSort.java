public class MergeSort {

    // Test the mergeSort method
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] array = {1, 2, 3, 2, 5, 6};

        System.out.println("Original Array:");
        printArray(array);

        sorter.mergeSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    // Main method to sort an array
    public void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: already sorted
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Split the array into left and right halves
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }

    // Method to merge two sorted arrays
    private void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge elements into the main array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements from left
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements from right
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Helper method to print an array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
}
