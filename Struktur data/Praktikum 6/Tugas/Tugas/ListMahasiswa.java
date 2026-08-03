package Tugas;
public class ListMahasiswa {
    Node head;
    public boolean isKosong() {
        return head == null;
    }
    public void sisipDepan(Mahasiswa data) {
        Node baru = new Node(data);
        baru.next = head;
        head = baru;
    }
    public void sisipBelakang(Mahasiswa data) {
        Node baru = new Node(data);
        if (isKosong()) {
            head = baru;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = baru;
        }
    }
    public void sisipTengah(Mahasiswa data, int posisi) {
        if (posisi <= 1 || isKosong()) {
            sisipDepan(data);
            return;
        }
        Node baru = new Node(data);
        Node temp = head;
        for (int i = 0; i < posisi - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        baru.next = temp.next;
        temp.next = baru;
    }
    public void hapusPosisi(int posisi) {
        if (isKosong()) return;
        if (posisi == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; i < posisi - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    public void tampilSimple() {
        Node current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data.nilaiHuruf);
            if (current.next != null) System.out.print(", ");
            current = current.next;
        }
        System.out.print("]");
    } 
    public void urutkanList(boolean ascending) {
        if (isKosong() || head.next == null) return;
        System.out.print("\nKondisi Awal: ");
        tampilSimple();
        System.out.println();
        boolean swapped;
        int langkah = 1;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                boolean tukar = ascending ?
                        (current.data.nilaiHuruf > current.next.data.nilaiHuruf) :
                        (current.data.nilaiHuruf < current.next.data.nilaiHuruf);
                if (tukar) {
                    // Tampilkan proses tukar
                    System.out.print("Langkah " + langkah + ": Tukar " + current.data.nilaiHuruf + " dengan " + current.next.data.nilaiHuruf + " -> ");
                    // Proses tukar data
                    Mahasiswa temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                    // Tampilkan hasil setelah tukar
                    tampilSimple();
                    System.out.println();
                    langkah++;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Proses sorting selesai.");
    }
    public void tampil() {
        System.out.println("\n--- Isi Linked List ---");
        if (isKosong()) {
            System.out.println("Data Kosong.");
            return;
        }
        Node current = head;
        int no = 1;
        while (current != null) {
            System.out.println(no + " | NIM : " + current.data.nim + " | Nama: " + current.data.nama + " | Jurusan: " + current.data.jurusan + " | Nilai: " + current.data.nilaiHuruf +"|");
            current = current.next;
            no++;
        }
    }
}