package ClassAndObject2.TV;
import java.util.Random; 

public class ClassTV {
    // Variabel global untuk class TV
    int nilai_suara = 0; 
    int nilai_terang = 0; 
    String source_input = "TV"; 
    String ratio_gambar = "16:9"; 
    int channel_sekarang = 1; 

    public void menu() {
        System.out.println("\n----------- Menu Utama TV -----------");
        System.out.println("Status: Channel " + channel_sekarang + " (" + getNamaChannel(channel_sekarang) + ") | Suara: " + nilai_suara + " | Terang: " + nilai_terang);
        System.out.println("Source: " + source_input + " | Ratio: " + ratio_gambar);
        System.out.println("-----------------------------------");
        System.out.println("1. Ganti Channel");
        System.out.println("2. Tambah Suara");
        System.out.println("3. Kurang Suara");
        System.out.println("4. Tambah Kecerahan");
        System.out.println("5. Kurang Kecerahan");
        System.out.println("6. Pilih Input Source"); 
        System.out.println("7. Atur Ratio Gambar"); 
        System.out.println("8. Auto Random Channel"); 
        System.out.println("0. Keluar Program");
        System.out.println("-----------------------------------");
    }

    // Menggunakan IF-ELSE IF-ELSE
    public String getNamaChannel(int channel) {
        if (channel == 1) {
            return "TVRI";
        } else if (channel == 2) {
            return "MnC/TPI";
        } else if (channel == 3) {
            return "Indosiar";
        } else if (channel == 4) {
            return "RCTI";
        } else if (channel == 5) {
            return "SCTV";
        } else if (channel == 6) {
            return "ANTV";
        } else {
            return "Channel Tidak Terdaftar";
        }
    }

    public void ganti_channel(int c) {
        if (c >= 1 && c <= 6) { 
            channel_sekarang = c;
            System.out.println("✅ Channel Anda berganti ke " + c + " (" + getNamaChannel(c) + ")");
        } else {
            System.out.println("❌ Channel " + c + " Tidak Terdaftar. Silakan pilih 1-6.");
        }
    }

    // Menggunakan IF-ELSE IF-ELSE
    public void set_input_source(int pilihan) {
        if (pilihan == 1) {
            source_input = "AV";
        } else if (pilihan == 2) {
            source_input = "HDMI 1";
        } else if (pilihan == 3) {
            source_input = "HDMI 2";
        } else {
            source_input = "TV"; // Default
        }
        System.out.println("✅ Input Source diubah ke: " + source_input);
    }

    // Menggunakan IF-ELSE IF-ELSE
    public void set_ratio_gambar(int pilihan) {
        if (pilihan == 1) {
            ratio_gambar = "4:3";
        } else if (pilihan == 2) {
            ratio_gambar = "16:9";
        } else if (pilihan == 3) {
            ratio_gambar = "Zoom";
        } else {
            ratio_gambar = "Auto"; // Default
        }
        System.out.println("✅ Ratio Gambar diubah ke: " + ratio_gambar);
    }
    
    public void auto_random_channel() {
        Random rand = new Random();
        int randomChannel = rand.nextInt(6) + 1;
        ganti_channel(randomChannel);
    }

    public void tambah_suara(int s) {
        nilai_suara = nilai_suara + s;
        if (nilai_suara > 100) {
            nilai_suara = 100;
            System.out.println("📢 Suara Yang Ditambahkan Terlalu Keras (Max 100)");
        } else {
            System.out.println("📢 Suara Sekarang bertambah +" + s + " sehingga menjadi " + nilai_suara);
        }
    }

    public void kurang_suara(int s) {
        nilai_suara = nilai_suara - s;
        if (nilai_suara < 0) {
            nilai_suara = 0;
            System.out.println("📢 Suara Yang dikurangi Terlalu Kecil Tidak Bersuara (Min 0)");
        } else {
            System.out.println("📢 Suara Sekarang berkurang -" + s + " sehingga menjadi " + nilai_suara);
        }
    }

    public void tambah_terang(int t) {
        nilai_terang = nilai_terang + t;
        if (nilai_terang > 100) {
            nilai_terang = 100;
            System.out.println("💡 Gambar Yang Ditambahkan Terlalu Terang (Max 100)");
        } else {
            System.out.println("💡 Gambar Sekarang bertambah +" + t + " sehingga menjadi " + nilai_terang);
        }
    }

    public void kurang_terang(int t) {
        nilai_terang = nilai_terang - t;
        if (nilai_terang < 0) {
            nilai_terang = 0; 
            System.out.println("💡 Gambar Terlalu Gelap (Min 0)");
        } else {
            System.out.println("💡 Terang Sekarang berkurang -" + t + " sehingga menjadi " + nilai_terang);
        }
    }
}