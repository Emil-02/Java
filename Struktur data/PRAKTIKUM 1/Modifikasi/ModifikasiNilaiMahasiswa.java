import java.util.InputMismatchException;
import java.util.Scanner; 
public class ModifikasiNilaiMahasiswa { 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);       
        System.out.print("Jumlah mahasiswa: "); 
        int jumlahMahasiswa; 
        try { 
            jumlahMahasiswa = input.nextInt(); 
        } catch (InputMismatchException ime) { 
            System.out.println("Input tidak valid. Masukkan angka bulat untuk jumlah mahasiswa."); 
            input.close(); 
            return; 
        }      
        if (jumlahMahasiswa <= 0) { 
            System.out.println("Jumlah mahasiswa harus lebih dari 0."); 
            input.close(); 
            return; 
        }      
        String[] kodeMataKuliah = new String[jumlahMahasiswa]; 
        String[] namaMataKuliah = new String[jumlahMahasiswa]; 
        double[] nilaiAbsensi = new double[jumlahMahasiswa]; 
        double[] nilaiTugas = new double[jumlahMahasiswa]; 
        double[] nilaiMid = new double[jumlahMahasiswa]; 
        double[] nilaiFinal = new double[jumlahMahasiswa]; 
        double[] nilaiAkhir = new double[jumlahMahasiswa]; 
        String[] nilaiHuruf = new String[jumlahMahasiswa]; 
               
        double minNilaiAkhir = 101.0; 
        int idxMin = -1;        

        for (int i = 0; i < jumlahMahasiswa; i++) { 
            System.out.println("Mahasiswa ke-" + (i + 1)); 
            System.out.print("Kode Mata Kuliah: "); 
            kodeMataKuliah[i] = input.next(); 
            input.nextLine(); // consume newline
            System.out.print("Nama Mata Kuliah: "); 
            namaMataKuliah[i] = input.nextLine(); 
            System.out.print("Nilai Absensi: "); 
            nilaiAbsensi[i] = input.nextDouble(); 
            System.out.print("Nilai Tugas: "); 
            nilaiTugas[i] = input.nextDouble(); 
            System.out.print("Nilai Mid: "); 
            nilaiMid[i] = input.nextDouble(); 
            System.out.print("Nilai Final: "); 
            nilaiFinal[i] = input.nextDouble(); 
            nilaiAkhir[i] = (nilaiAbsensi[i] * 0.1) + (nilaiTugas[i] * 0.2) + (nilaiMid[i] * 0.3) + 
    (nilaiFinal[i] * 0.4); 
            if (nilaiAkhir[i] >= 85) { 
                nilaiHuruf[i] = "A"; 
            } else if (nilaiAkhir[i] >= 70) { 
                nilaiHuruf[i] = "B"; 
            } else if (nilaiAkhir[i] >= 55) { 
                nilaiHuruf[i] = "C"; 
            } else if (nilaiAkhir[i] >= 40) { 
                nilaiHuruf[i] = "D"; 
            } else { 
                nilaiHuruf[i] = "E"; 
            }
            if (nilaiAkhir[i] < minNilaiAkhir) { 
                minNilaiAkhir = nilaiAkhir[i]; 
                idxMin = i;
            } 
        } 
        System.out.println("Daftar Nilai Mahasiswa:"); 
        System.out.println("-------------------------------------------------"); 
        System.out.println("Kode MK | Nama MK | Nilai Akhir | Nilai Huruf"); 
        System.out.println("-------------------------------------------------"); 
        for (int i = 0; i < jumlahMahasiswa; i++) { 
            System.out.println(kodeMataKuliah[i] + " | " + namaMataKuliah[i] + " | " + 
                String.format("%.2f", nilaiAkhir[i]) + " | " + nilaiHuruf[i]); 
        } 
        System.out.println("-------------------------------------------------"); 
        if (idxMin != -1) {
            System.out.println("Nilai Terendah: " + String.format("%.2f", minNilaiAkhir) + 
                " (Kode: " + kodeMataKuliah[idxMin] + ", Nama: " + namaMataKuliah[idxMin] + ")");
        } else {
            System.out.println("Tidak ada data nilai.");
        }
        input.close();
     } 
}