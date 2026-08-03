package strudalclassnobjek;
public class ClassOperasiBangunDatar {
    double nilai1, luas, nilai2;

    public void luas_persegi(double n) { //menghitung luas persegi
        nilai1 = n;
        luas = nilai1 * nilai1;
    }

    public void luas_sgtiga(double a, double t) {
        nilai1 = a;
        nilai2 = t;
        luas = 0.5 * nilai1 * nilai2;
    }

    public void persegi_panjang(double p, double l) {
        nilai1 = p; //nilai1 menerima nilai p yang dikirim sebagai parameter dari main class
        nilai2 = l; //nilai2 menerima nilai l yang dikirim sebagai parameter dari main class
        luas = nilai1 * nilai2;
    }

    public void lingkaran(double jari) { //menghitung luas lingkaran
        nilai1 = jari;
        luas = 3.14 * nilai1 * nilai1;
    }

    public void tampil() { //method tampil
        System.out.println("Luas adalah " + luas); //menampilkan nilai luas
    }
}