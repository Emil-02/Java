package TugasP5;

public class Mahasiswa {
    String nim, nama, jurusan;
    char nilai;

    public Mahasiswa(String nim, String nama, String jurusan, char nilai) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.nilai = nilai;
    }

    public void cetak() {
        System.out.printf("%-15s %-20s %-15s %-5s\n", nim, nama, jurusan, nilai);
    }

    public int getBobot() {
        if (nilai == 'A') return 5;
        else if (nilai == 'B') return 4;
        else if (nilai == 'C') return 3;
        else if (nilai == 'D') return 2;
        else return 1; 
    }

    public static class Stack {
        Mahasiswa stack[] = new Mahasiswa[20];
        int top = 0;
        String namaStack;

        public Stack(String namaStack) {
            this.namaStack = namaStack;
        }

        public void push(Mahasiswa data) {
            stack[top] = data;
            top++;
            // Log ini tetap ada untuk melihat proses pengurutan
            System.out.println("-> PUSH: " + data.nama + " (" + data.nilai + ") masuk ke " + namaStack);
        }

        public Mahasiswa pop() {
            top--;
            Mahasiswa data = stack[top];
            // Log ini tetap ada untuk melihat proses pengurutan
            System.out.println("<- POP : " + data.nama + " (" + data.nilai + ") keluar dari " + namaStack);
            return data;
        }

        // --- TAMBAHKAN INI ---
        // Method pop khusus untuk cetak hasil akhir supaya bersih
        public Mahasiswa popTanpaLog() {
            top--;
            return stack[top];
        }
        // ---------------------

        public Mahasiswa peek() {
            return stack[top - 1];
        }

        public boolean isEmpty() {
            return (top == 0);
        }
    }
}