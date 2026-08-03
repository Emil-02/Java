package Program;
import java.util.Random;
import java.util.Scanner;
public class StackUtama {   
     public static void main(String[] args) {
        Stack tumpuk = new Stack();
        Scanner scanner = new Scanner(System.in);
        tumpuk.push(5);
        tumpuk.push(7);
        tumpuk.push(1);
        tumpuk.push(4);
        tumpuk.push(8);
        tumpuk.push(0);
        tumpuk.push(10);
        tumpuk.push(11);
        tumpuk.push(9);
        tumpuk.tampil();
        System.out.println();
        tumpuk.pop();
        tumpuk.tampil();
        System.out.println();
        tumpuk.pop();
        tumpuk.tampil();
        System.out.println();
        tumpuk.pop();
        tumpuk.tampil();
        System.out.println();
        for (int i = 0; i < 5; i++) {
            tumpuk.pop();
        }
        tumpuk.tampil();
        System.out.println();
        int n[] = new int[10];
        Random nilai = new Random();
        for (int i = 0; i < 5; i++) {
            n[i] = nilai.nextInt(10);
        }
        System.out.print("Isi Array n : ");
        for (int j = 0; j < 5; j++) {
            System.out.print(n[j] + " ");
        }
        for (int i = 0; i < 5; i++) {
            tumpuk.push(n[i]);
        }
        System.out.println();
        System.out.print("Isi Tumpukan Stack : ");
        tumpuk.tampil();
 }
}