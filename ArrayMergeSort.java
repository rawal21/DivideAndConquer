public class ArrayMergeSort {

  // Method to print the array
  public static void printArray(int arr[]) {
      for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");  // Print elements in the same line
      }
      System.out.println(); // Move to the next line after printing array
  }

  // Merge Sort function
  public static void MergeSort(int arr[], int si, int ei) {
      // Base case: If start index is greater than or equal to end index, return
      if (si >= ei) {
          return;
      }

      int mid = si + (ei - si) / 2; // Calculate middle index

      // Recursive call for left part
      MergeSort(arr, si, mid);
      // Recursive call for right part
      MergeSort(arr, mid + 1, ei);
      // Merge the two sorted halves
      merge(arr, si, mid, ei);
  }

  // Merge function to merge two sorted subarrays
  public static void merge(int arr[], int si, int mid, int ei) {
      int i = si;      // Pointer for the left subarray
      int j = mid + 1; // Pointer for the right subarray
      int k = 0;       // Pointer for temp array
      int temp[] = new int[ei - si + 1]; // Temporary array

      // Merge both halves into temp array
      while (i <= mid && j <= ei) {
          if (arr[i] < arr[j]) {
              temp[k] = arr[i];  // Corrected: Assign arr[i] instead of temp[i]
              i++;
          } else {
              temp[k] = arr[j];
              j++;
          }
          k++;
      }

      // Copy remaining elements from left half (if any)
      while (i <= mid) {
          temp[k++] = arr[i++];
      }

      // Copy remaining elements from right half (if any)
      while (j <= ei) {
          temp[k++] = arr[j++];
      }

      // Copy sorted elements from temp array back to original array
      for (k = 0, i = si; k < temp.length; k++, i++) {
          arr[i] = temp[k];
      }
  }

  public static void main(String[] args) {
      int arr[] = {12, 11, 13, 5, 6, 7}; // Input array
      int n = arr.length;
      int si = 0;
      int ei = n - 1;

      // Call Merge Sort function
      MergeSort(arr, si, ei);

      // Print sorted array
      System.out.println("Array after merge sort:");
      printArray(arr);
  }
}
