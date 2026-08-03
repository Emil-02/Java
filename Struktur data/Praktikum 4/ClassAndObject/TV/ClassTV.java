package ClassAndObject.TV;
public class ClassTV {
    int nilai_suara, nilai_terang; //variabel global untuk class TV Karena kita akan gunakan dia di dalam b
    public void menu() //Untuk Inputan pilihan menu dari fungsi yang dibuat di atas
    {
        System.out.println("Menu Utama :");
        System.out.println("-----------------------");
        System.out.println("1. Ganti Channel");
        System.out.println("2. Tambah Suara");
        System.out.println("3. Kurang Suara");
        System.out.println("4. Tambah Kecerahan");
        System.out.println("5. Kurang Kecerahan");
        System.out.println("-----------------------");
    }
    public void ganti_channel(int c)
    {
        int channel = c;
        if (channel == 1)
            System.out.println("Channel Anda berganti ke TVRI");
        else if (channel == 2)
            System.out.println("Channel Anda berganti ke MnC/TPI");
        else if (channel == 3)
            System.out.println("Channel Anda berganti ke Indosiar");
        else if (channel == 4)
            System.out.println("Channel Anda berganti ke RCTI");
        else if (channel == 5)
            System.out.println("Channel Anda berganti ke SCTV");
        else if (channel == 6)
            System.out.println("Channel Anda berganti ke ANTV");
        else
            System.out.println("Channel Tidak Terdaftar");
    }
    public void tambah_suara(int s)
    {
        int suara = s;
        nilai_suara = nilai_suara+suara; //perubahan nilai suara
        if (nilai_suara>=100)
        {
            System.out.println("Suara Yang Ditambahkan Terlalu Keras");
        }
        else
        {
            System.out.println("Suara Sekarang bertambah "+suara+" sehingga menjadi "+nilai_suara);
        }
    }
    public void kurang_suara(int s)
    {
        int suara = s;
        nilai_suara = nilai_suara-suara;
        if(nilai_suara<=0)
        {
            System.out.println("Suara Yang dikurangi Terlalu Kecil Tidak bisa lebih kecil lagi");
        }
        else
        {
            System.out.println("Suara Sekarang berkurang "+suara+" sehingga menjadi "+nilai_suara);
        }
    }
    public void tambah_terang(int t)
    {
        int terang = t;
        nilai_terang = nilai_terang +terang ;
        if (nilai_terang >=100)
        {
            System.out.println("Gambar Yang Ditambahkan Terlalu Terang");
        }
        else
        {
            System.out.println("Gambar Sekarang bertambah Terang "+terang+" sehingga menjadi "+nilai_terang);
        }
    }
    public void kurang_terang(int t)
    {
        int terang = t;
        nilai_terang = nilai_terang-terang;
        if (nilai_terang<=0)
        {
            System.out.println("Gambar Terlalu Gelap");
        }
        else
        {
            System.out.println("Terang Sekarang berkurang "+terang+" sehingga menjadi "+nilai_terang);
        }
    }
}