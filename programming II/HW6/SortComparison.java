import java.util.Random;
import java.util.Arrays;

public class SortComparison {
    public static void main(String[] args) {
    
        int[] smallArray = generateRandomArray(10, 1, 100);
        System.out.println("original 10 int array: " + Arrays.toString(smallArray));

        int[] selectionSort = smallArray.clone();
        int countSelectionSort = selectionSort(selectionSort);
        System.out.println("Selection Sorted small array: " + Arrays.toString(selectionSort));
        System.out.println("Selection Sort iterations: " + countSelectionSort);

        int[] mergeSortedSmallArray = smallArray.clone();
        int mergeSortCountSmall = mergeSort(mergeSortedSmallArray, new int[smallArray.length], 0, smallArray.length - 1, 0);
        System.out.println("Merge Sorted small array: " + Arrays.toString(mergeSortedSmallArray));
        System.out.println("Merge Sort iterations: " + mergeSortCountSmall);

        
        int[] largeArray = generateRandomArray(10000, 1, 100);
        System.out.println("Original large array created.");

        int[] selectionSortedLargeArray = largeArray.clone();
        int selectionSortCountLarge = selectionSort(selectionSortedLargeArray);
        System.out.println("Selection Sort iterations for large array: " + selectionSortCountLarge);

        int[] mergeSortedLargeArray = largeArray.clone();
        int mergeSortCountLarge = mergeSort(mergeSortedLargeArray, new int[largeArray.length], 0, largeArray.length - 1, 0);
        System.out.println("Merge Sort iterations for large array: " + mergeSortCountLarge);

        
        System.out.println("For a array size of 10, selection sort may be the better option. For larger array sizes such as 10000, merge sort is recommended because of its ability to group multiple integers and less iterations needed.");
    }

    
    private static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    
    private static int selectionSort(int[] array) {
        int iterationCount = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                iterationCount++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return iterationCount;
    }
    private static int mergeSort(int[] array, int[] temp, int left, int right, int iterationCount) {
        if (left >= right) {
            return iterationCount;
        }
        int mid = left + (right - left) / 2;
        iterationCount = mergeSort(array, temp, left, mid, iterationCount);
        iterationCount = mergeSort(array, temp, mid + 1, right, iterationCount);
        iterationCount = merge(array, temp, left, mid, right, iterationCount);
        return iterationCount;
    }
    private static int merge(int[] array, int[] temp, int left, int mid, int right, int iterationCount) {
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            iterationCount++;
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            iterationCount++;
            array[k++] = temp[i++];
        }

        return iterationCount;
    }
}
