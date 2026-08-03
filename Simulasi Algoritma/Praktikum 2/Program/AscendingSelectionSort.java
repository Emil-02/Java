public class AscendingSelectionSort {
    public static void main(String[] args) {
        int[] arr = {84, 34, 25, 12, 22, 11, 90}; 
        int n = arr.length; 
        for (int i = n - 1; i >= 0; i--) { 
            int maxIdx = i; 
            for (int j = i - 1; j >= 0; j--) { 
                if (arr[j] > arr[maxIdx]) { 
                    maxIdx = j; 
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i]; 
            arr[i] = temp; 
        }
        System.out.println("Array setelah diurutkan:"); 
        for (int i = 0; i < n; i++) { 
            System.out.print(arr[i] + " "); 
        }
        System.out.println(); 
    }
}