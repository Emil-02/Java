import java.util.Random;
public class ModifSelectionSort {
    public static void main(String[] args) {
        int arraySize = 8; 
        int maxRandomValue = 50; 
        int[] arr = new int[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            arr[i] = random.nextInt(maxRandomValue) + 1;
        }
        System.out.println("--- Selection Sort (Ascending) ---");
        System.out.print("Array Awal: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");        
        System.out.println("----------------------------------");
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            int maxIdx = i;
            System.out.println("\nLangkah " + (n - 1 - i + 1) + ": Mencari MAX di arr[0..." + i + "]");
            for (int j = i - 1; j >= 0; j--) {
                System.out.print("   > Bandingkan arr[" + j + "] (" + arr[j] + 
                                 ") dengan arr[" + maxIdx + "] (" + arr[maxIdx] + ") ... ");
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j; 
                    System.out.println("**" + arr[j] + " lebih besar. maxIdx diperbarui menjadi " + j + "**");
                } else {
                    System.out.println("Tidak ada perubahan.");
                }
            }
            if (maxIdx != i) {
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[i];
                arr[i] = temp;
                System.out.println("   --- SWAP: Tukar arr[" + maxIdx + "] (" + arr[i] + 
                                   ") dengan arr[" + i + "] (" + arr[maxIdx] + ")");
            } else {
                System.out.println("   Tidak ada pertukaran. Elemen terbesar sudah di posisi " + i + ".");
            }
            System.out.print("   Array Sementara: [");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k]);
                if (k < arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("\n----------------------------------");
        System.out.print("Array Setelah Diurutkan: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        System.out.println("----------------------------------");
    }
}