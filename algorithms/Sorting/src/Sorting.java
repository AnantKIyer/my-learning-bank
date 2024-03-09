import java.util.Arrays;

import static BasicFunctions.Basics.swapNumbers;


public class Sorting {

    public static int[] bubbleSort(int[] arr, int len) {
        int[] sortedArray;
        sortedArray = arr;
        for (int i=len; i>0; i--) {
            for(int j = 0; j < i - 1; j++) {
                if(sortedArray[j] > sortedArray[j+1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j+1];
                    sortedArray[j+1] = temp;
                }
            }
        }
        return sortedArray;
    }

    public static int[] merge2Sort(int[] arr, int low, int mid, int high) {
        int[] merged = new int[high - low +1];
        int _index1 = low; int _index2 = mid + 1; int _index = 0;

        while (_index1 <= mid && _index2 <= high) {
            if(arr[_index1] <= arr[_index2]) {
                merged[_index] = arr[_index1];
                
                _index++; _index1++;
            } else {
                merged[_index] = arr[_index2];
                _index++; _index2++;
            }
        }
        return merged;
    }
    
    public static int[] mergeSort(int[] arr, int low, int high) {
        if(low <= high) {
            return arr;
        }
        else {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
           return merge2Sort(arr, low, mid, high);
        }
    }

    public static int[] insertionSort(int[] arr, int length) {

        for(int i = 1; i < length; i++) {
            int j = i-1;
            while(j>=0) {

                if(arr[j+1] < arr[j]) {

                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                }
                j--;
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr, int len) {
        for (int i = 0; i<len; i++) {
            // taking a minimum index
            int min = i;

            for (int j = 0; j<len; j++){

                if(arr[j] > arr[min]) {  // comparing if arr[j] is less than arr[min]

                    int temp = arr[min];
                    arr[min] = arr[j];
                    arr[j] = temp;

                }
            }
        }
        return arr;
    }

    public static int pivotDropper(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low; int j = high;
        while(i<j) {
            while(arr[i] <= arr[pivot] && i<=high - 1) i++;

            while(arr[j] > arr[pivot] && j>=low + 1) j--;


            if(i<j) swapNumbers(arr[i], arr[j]);
        }
                swapNumbers(arr[low], arr[j]);

        return j;
    }
    public static int[] quickSort(int[] arr, int low, int high) {
        if(low >= high) {
            return arr;
        } else {
            int partitioner = pivotDropper(arr, low, high);
            quickSort(arr, low, partitioner-1);
            quickSort(arr, partitioner+1, high);

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,7,1,3,2};
        int length = arr.length;

        System.out.println("Arrays sorted with Bubble Sort " + Arrays.toString(bubbleSort(arr, length)));

        System.out.println("Arrays sorted with Merge Sort " + Arrays.toString(mergeSort(arr, 0, 5)));

        System.out.println("Arrays sorted with Insertion Sort " + Arrays.toString(insertionSort(arr, length)));

        System.out.println("Arrays sorted with Selection Sort " + Arrays.toString(selectionSort(arr, length)));

        System.out.println("Arrays sorted with Quick Sort " + Arrays.toString((quickSort(arr, 0, 5))));
    }
}
