public class BubbleShortDescending {
    public static void main(String[] args) {
        int [] arr = {64, 34, 25, 12, 22, 11, 90};
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = n - 1; j > n- i - 1; j--) {
                for (int k = n - i - 1; k >= 0; k--) {
                    if (arr[j] < arr[k]) {
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
        }
        System.out.println("Array Setelah diurut");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
