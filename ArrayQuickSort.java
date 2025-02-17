public class ArrayQuickSort {

  // Method to print the array
  public static void Arrayprint(int arr[]) {
      for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
      }
      System.out.println(); // Print new line after array
  }

  // QuickSort function
  public static void QuickSort(int arr[], int si, int ei) {
      // Base case: If start index is greater than or equal to end index, return
      if (si >= ei) {
          return;
      }

      // Find partition index
      int pIdx = partition(arr, si, ei);

      // Recursive calls for left and right subarrays
      QuickSort(arr, si, pIdx - 1); // Left part
      QuickSort(arr, pIdx + 1, ei); // Right part
  }

  // Partition function to find the correct position of pivot
  public static int partition(int arr[], int si, int ei) {
      int pivot = arr[ei]; // Choosing last element as pivot
      int i = si - 1; // Pointer for smaller element

      // Loop to compare elements with pivot
      for (int j = si; j < ei; j++) {
          if (arr[j] < pivot) {
              i++;
              // Swap arr[i] and arr[j]
              int temp = arr[j];
              arr[j] = arr[i];
              arr[i] = temp;
          }
      }

      // Swap pivot element with correct position (arr[i+1])
      int temp = arr[i + 1];
      arr[i + 1] = arr[ei];
      arr[ei] = temp;

      return i + 1; // Returning partition index
  }

  public static void main(String[] args) {
      int[] arr = {5, 2, 9, 1, 7, 6, 8};
      
      System.out.println("Array before QuickSort:");
      Arrayprint(arr);

      // Call QuickSort function
      QuickSort(arr, 0, arr.length - 1);

      System.out.println("Array after QuickSort:");
      Arrayprint(arr); // Print sorted array
  }
}
