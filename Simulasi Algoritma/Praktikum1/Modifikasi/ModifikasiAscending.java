import java.util.Random;
public class ModifikasiAscending {
    public static String arrayToString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        if (arr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]); 
            if (i < arr.length - 1) {
                sb.append(", "); 
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        int n = 7;
        int[] arr = new int[n];
        for (int k = 0; k < n; k++) {
            arr[k] = rand.nextInt(100);
        }
        boolean ditukar;
        System.out.println("--- Proses Bubble Sort (Kecil ke Besar) ---");
        System.out.println("Array Awal (Acak): " + arrayToString(arr));
        System.out.println("----------------------------------------------");
        for (int i = 0; i < n - 1; i++) {
            ditukar = false;
            System.out.println("\n== PASS " + (i + 1) + " ==");
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    System.out.print("  Membandingkan " + arr[j] + " dan " + arr[j + 1]);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    ditukar = true;
                    System.out.println(" -> Tukar!");
                    System.out.println("    Array sekarang: " + arrayToString(arr));
                    Thread.sleep(300);
                }
            }
            if (ditukar) {
    
                System.out.println("Hasil setelah PASS " + (i + 1) + ": " + arrayToString(arr));
            }
            if (ditukar == false) {
                System.out.println("\nArray sudah terurut. Menghentikan proses lebih awal.");
                break;
            }
        }
        System.out.println("----------------------------------------------");
        System.out.println("Proses Selesai.");
        System.out.println("Array Akhir Terurut: " + arrayToString(arr));
    }
}