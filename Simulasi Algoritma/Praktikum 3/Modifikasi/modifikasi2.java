import java.util.Random;
public class modifikasi2 {
    public static int[] generateRandomArray(int size, int maxVal) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(maxVal) + 1; 
        }
        return arr;
    }
    public static void printArrayStatus(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int size = 7;
        int maxRandomValue = 50;
        int arr[] = generateRandomArray(size, maxRandomValue);
        int n = arr.length;
        System.out.println("  Insertion Sort dengan Simulasi ");
        System.out.print("Array Awal (Random): ");
        printArrayStatus(arr);
        System.out.println("----------------------------------------");
        for (int i = n - 2; i >= 0; i--) {
            int key = arr[i];
            int j = i + 1;
            System.out.println("\nMemeriksa Angka: " + key + " (Indeks i=" + i + ")");
            boolean hasMoved = false; 
            while (j < n && arr[j] < key) {
                System.out.println("  -> Pertukaran: Memindahkan " + arr[j] + " dari arr[" + j + "] ke arr[" + (j - 1) + "]");
                
                arr[j - 1] = arr[j];
                j++;
                hasMoved = true;
                System.out.print("  -> Status Array: ");
                printArrayStatus(arr);
            }  
            if (hasMoved || arr[j - 1] != key) {
                 arr[j - 1] = key;
                 System.out.println("  -> Menyisipkan KEY (" + key + ") di arr[" + (j - 1) + "]");
                 System.out.print("  -> Status Array Final Setelah i=" + i + ": ");
                 printArrayStatus(arr);
            }
        }
        System.out.println("----------------------------------------");
        System.out.print("Array setelah diurutkan (Ascending): ");
        printArrayStatus(arr);
    }
}