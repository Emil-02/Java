package ClassAndObject2.BagunDatar;
public class ClassOperasiBangunDatarRuang { // Ganti nama class atau tetap ClassOperasiBangunDatar
    double nilai1, luas, nilai2; // Variabel untuk Bangun Datar
    double volume; // Variabel baru untuk volume Bangun Ruang
    public void luas_persegi(double n) {
        nilai1 = n;
        luas = nilai1 * nilai1;
    }
    public void luas_sgtiga(double a, double t) {
        nilai1 = a;
        nilai2 = t;
        luas = 0.5 * nilai1 * nilai2;
    }
    public void persegi_panjang(double p, double l) {
        nilai1 = p;
        nilai2 = l; 
        luas = nilai1 * nilai2;
    }
    public void lingkaran(double jari) {
        nilai1 = jari;
        luas = 3.14 * nilai1 * nilai1;
    }
    public void tampil_luas() {
        System.out.println("Luas adalah: " + luas); 
    }
    public void volume_kubus(double s) {
        volume = s * s * s;
    }
    public void volume_balok(double p, double l, double t) {
        volume = p * l * t;
    }
    public void volume_tabung(double r, double t) {
        volume = 3.14 * r * r * t;
    }
    public void volume_limas_segiempat(double p_alas, double l_alas, double t_limas) {
        double luas_alas = p_alas * l_alas;
        volume = (1.0 / 3.0) * luas_alas * t_limas;
    }
    public void volume_kerucut(double r, double t) {
        volume = (1.0 / 3.0) * 3.14 * r * r * t;
    }
    public void tampil_volume() {
        System.out.println("Volume adalah: " + volume);
    }
}