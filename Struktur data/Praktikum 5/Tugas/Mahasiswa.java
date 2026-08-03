package Tugas;
public class Mahasiswa {
    String nim;
    String nama;
    String jurusan;
    char nilaiHuruf; // A, B, C, D, E

    // Constructor
    public Mahasiswa(String nim, String nama, String jurusan, char nilaiHuruf) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.nilaiHuruf = nilaiHuruf;
    }

    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Jurusan: " + jurusan + ", Nilai: " + nilaiHuruf;
    }
}