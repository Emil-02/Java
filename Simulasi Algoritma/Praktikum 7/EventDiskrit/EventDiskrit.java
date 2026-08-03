package EventDiskrit;
import java.util.Random;
public class EventDiskrit {
    static Random random = new Random();
    static void pelayananGigi(int pasien) {
        int waktuPelayanan = random.nextInt(16) + 5;
        System.out.println("Pasien " + pasien + " selesai dari poli GIGI pada waktu " + waktuPelayanan);
    }
    static void pelayananTHT(int pasien) {
        int waktuPelayanan = random.nextInt(16) + 5;
        System.out.println("Pasien " + pasien + " selesai dari poli THT pada waktu " + waktuPelayanan);
    }
    static void kedatanganPasien() {
        int pasien = 0;
        while (true) {
            int waktuKedatangan = random.nextInt(11);
            try {
                Thread.sleep(waktuKedatangan * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pasien++;
            System.out.println("Pasien " + pasien + " datang pada waktu " + waktuKedatangan);
            pelayananPasien(pasien);
        }
    }
    static void pelayananPasien(int pasien) {
        pelayananGigi(pasien);
        pelayananTHT(pasien);
    }
    public static void main(String[] args) {
        kedatanganPasien();
    }
}