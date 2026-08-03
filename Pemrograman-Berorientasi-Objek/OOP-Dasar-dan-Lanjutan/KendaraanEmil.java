// Parent class
class Kendaraan {
    String ErMerk;
    int ErTahun;
    String ErWarna;
    // Constructor
    public Kendaraan(String ErMerk, int ErTahun, String ErWarna) {
        this.ErMerk = ErMerk;
        this.ErTahun = ErTahun;
        this.ErWarna = ErWarna;
    }
    // Method info()
    public void info() {
        System.out.println("Merk: " + ErMerk);
        System.out.println("Tahun: " + ErTahun);
        System.out.println("Warna: " + ErWarna);
    }
}
// Child class: Motor
class Motor extends Kendaraan {
    int ErCc;
    public Motor(String ErMerk, int ErTahun, String ErWarna, int ErCc) {
        super(ErMerk, ErTahun, ErWarna);
        this.ErCc = ErCc;
    }
    // Override method info()
    @Override
    public void info() {
        super.info();
        System.out.println("Kapasitas Mesin: " + ErCc + " cc");
    }
    // Method khusus
    public void wheelie() {
        System.out.println(ErMerk + " melakukan wheelie!");
    }
}
// Child class: Mobil
class Mobil extends Kendaraan {
    int ErJumlahPintu;
    public Mobil(String ErMerk, int ErTahun, String ErWarna, int ErJumlahPintu) {
        super(ErMerk, ErTahun, ErWarna);
        this.ErJumlahPintu = ErJumlahPintu;
    }
    // Override method info()
    @Override
    public void info() {
        super.info();
        System.out.println("Jumlah Pintu: " + ErJumlahPintu);
    }
    // Method khusus
    public void bukaBagasi() {
        System.out.println("Bagasi " + ErMerk + " dibuka.");
    }
}
// Main class
public class KendaraanEmil {
    public static void main(String[] args) {
        Motor motor1 = new Motor("Yamaha", 2063, "biru", 150);
        Mobil mobil1 = new Mobil("Toyota", 2063, "biru", 4);

        System.out.println("=== Data Motor ===");
        motor1.info();
        motor1.wheelie();

        System.out.println("\n=== Data Mobil ===");
        mobil1.info();
        mobil1.bukaBagasi();
    }
}
