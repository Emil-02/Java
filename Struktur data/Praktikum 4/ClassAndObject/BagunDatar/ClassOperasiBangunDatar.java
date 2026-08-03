package ClassAndObject.BagunDatar;
public class ClassOperasiBangunDatar {
    double nilail, luas, nilai2;
    public void luas_persegi(double n)//menghitung luas persegi
    {
        nilail = n;
        luas = nilail*nilail;
    }
    public void luas_sgtiga(double a, double t){
        nilail = a;
        nilai2 = t;
        luas = 0.5*nilail*nilai2;
    }
    public void persegi_panjang(double p, double l)
    {
        nilail=p;//nilail menerima nilai p yang dikirim sebagai parameter dari main class
        nilai2=l;//nilai2 menerima nilai l yang dikirim sebagai parameter dari main class
        luas = nilail*nilai2;
    }
    public void lingkaran(double jari) //menghitung luas lingkaran
    {
        nilail=jari;
        luas = 3.14*nilail*nilail;
    }
    public void tampil()//method tampil
    {
        System.out.println("Luas adalah "+luas);//menampilkan nilai luas
    }
    void L_persegi(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated method.
    }

}