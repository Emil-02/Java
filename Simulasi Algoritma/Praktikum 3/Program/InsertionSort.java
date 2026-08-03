public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            int key = arr[i];
            int j = i + 1;
            while (j < n && arr[j] < key) {
                arr[j - 1] = arr[j];
                j++;
            }
            arr[j - 1] = key;
        }
        System.out.println("Array setelah diurutkan");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}