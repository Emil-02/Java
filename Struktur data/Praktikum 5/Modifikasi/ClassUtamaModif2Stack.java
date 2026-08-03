package Modifikasi;
import java.util.Scanner;

public class ClassUtamaModif2Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackModif s1 = new StackModif(); 
        StackModif s2 = new StackModif(); 

        System.out.print("Masukkan sebuah kalimat: ");
        String kalimatAsli = scanner.nextLine(); 
        
        System.out.println("------------------------------------------");
    
        String[] arrayKata = kalimatAsli.split("\\s+");
        System.out.println("FASE 1: Push Input ke Stack 1 (S1)");
        for (String kata : arrayKata) {
            s1.push(kata);
            System.out.println("   Push S1: " + kata);
        }
        System.out.println("\nFASE 2: Pop S1 dan Push ke Stack 2 (S2)");
        while (!s1.isEmpty()) {
            String kataPop = s1.pop();
            if (kataPop != null) {
                s2.push(kataPop); 
                System.out.println("   Pindah: " + kataPop + " dari S1 ke S2");
            }
        }
        System.out.println("\nFASE 3: Pop S2 dan Push Kembali ke Stack 1 (S1)");
         while (!s2.isEmpty()) {
            String kataPop = s2.pop();
            if (kataPop != null) {
                s1.push(kataPop); 
                System.out.println("   Pindah: " + kataPop + " dari S2 ke S1");
            }
        }
        System.out.println("\nFASE 4: Pop Hasil dari Stack 1 (S1)");
        StringBuilder kalimatTerbalik = new StringBuilder();
        while (!s1.isEmpty()) {
            String kataPop = s1.pop();
            if (kataPop != null) {
                kalimatTerbalik.append(kataPop).append(" ");
                System.out.println("   Kata keluar: " + kataPop);
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("Kalimat Terbalik (Hasil Akhir):");
        System.out.println(kalimatTerbalik.toString().trim());

        scanner.close(); 
    }
}