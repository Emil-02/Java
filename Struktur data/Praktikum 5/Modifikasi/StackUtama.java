package Modifikasi; 
import java.util.Scanner; 
public class StackUtama { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        Stack tumpuk = new Stack(); 
        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = scanner.nextLine();
        char[] charArray = kalimat.toCharArray();
        System.out.println("\nProses Push Karakter ke Stack:");
        for (int i = 0; i < charArray.length; i++) {
            tumpuk.push(charArray[i]);
            System.out.println("Push: " + charArray[i]);
        }
        System.out.print("\nIsi Tumpukan Stack (Kalimat Terbalik): ");
        tumpuk.tampil();
        System.out.println();
        System.out.println("\nProses Pop 3 Karakter:");
        for (int i = 0; i < 3; i++) {
            if (tumpuk.top > 0) {
                 char poppedChar = tumpuk.pop();
                 System.out.println("Pop: " + poppedChar);
            }
        }
        System.out.print("\nIsi Stack setelah Pop: ");
        tumpuk.tampil();
        System.out.println();
    }
}