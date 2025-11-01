# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Ditha Elita Putri
- NIM   : 240202832
- Kelas : 3 IKRA

---

## Tujuan
- Mahasiswa mampu **menjelaskan konsep polymorphism** dalam OOP.  
- Mahasiswa mampu **membedakan method overloading dan overriding**.  
- Mahasiswa mampu **mengimplementasikan polymorphism (overriding, overloading, dynamic binding)** dalam program.  
- Mahasiswa mampu **menganalisis contoh kasus polymorphism** pada sistem nyata (Agri-POS).

  
## Dasar Teori
Polymorphism berarti “banyak bentuk” dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.  
1. **Overloading** → mendefinisikan method dengan nama sama tetapi parameter berbeda.  
2. **Overriding** → subclass mengganti implementasi method dari superclass.  
3. **Dynamic Binding** → pemanggilan method ditentukan saat runtime, bukan compile time. 
 
Dalam konteks Agri-POS, misalnya:  
- Method `getInfo()` pada `Produk` dioverride oleh `Benih`, `Pupuk`, `AlatPertanian` untuk menampilkan detail spesifik.  
- Method `tambahStok()` bisa dibuat overload dengan parameter berbeda (int, double).

---


## Langkah Praktikum
1. **Overloading**  
   - Tambahkan method `tambahStok(int jumlah)` dan `tambahStok(double jumlah)` pada class `Produk`.

2. **Overriding**  
   - Tambahkan method `getInfo()` pada superclass `Produk`.  
   - Override method `getInfo()` pada subclass `Benih`, `Pupuk`, dan `AlatPertanian`.  

3. **Dynamic Binding**  
   - Buat array `Produk[] daftarProduk` yang berisi objek `Benih`, `Pupuk`, dan `AlatPertanian`.  
   - Loop array tersebut dan panggil `getInfo()`. Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual. 

4. **Main Class**  
   - Buat `MainPolymorphism.java` untuk mendemonstrasikan overloading, overriding, dan dynamic binding.  

5. **CreditBy**  
   - Tetap panggil `"CreditBy: " + nama + " (" + nim + ")")` .  

6. **Commit dan Push**  
   - Commit dengan pesan: `week4-polymorphism`.  

---

## Kode Program

### Produk.java
```java
package com.upb.agripos.model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Overloading
    public void tambahStok(int jumlah) {
        stok += jumlah;
        System.out.println("Stok bertambah sebanyak " + jumlah + " unit (int).");
    }

    public void tambahStok(double jumlah) {
        stok += (int) jumlah;
        System.out.println("Stok bertambah sebanyak " + jumlah + " unit (double).");
    }

    // Getters
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    // Default info
    public String getInfo() {
        return "Produk: " + nama + " (Kode: " + kode + ")";
    }
}

```

### Benih.java
```java
package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    @Override
    public String getInfo() {
        return "Benih\n----------------------------------\n"
             + "Produk : " + getNama() + "\n"
             + "Kode   : " + getKode() + "\n"
             + "Harga  : Rp" + getHarga() + "\n"
             + "Stok   : " + getStok() + "\n"
             + "Varietas : " + varietas + "\n";
    }
}
```

### Pupuk.java
```java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public String getInfo() {
        return "Pupuk\n----------------------------------\n"
             + "Produk : " + getNama() + "\n"
             + "Kode   : " + getKode() + "\n"
             + "Harga  : Rp" + getHarga() + "\n"
             + "Stok   : " + getStok() + "\n"
             + "Jenis  : " + jenis + "\n";
    }
}
```

### AlatPertanian.java
```java
package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String bahan;

    public AlatPertanian(String kode, String nama, double harga, int stok, String bahan) {
        super(kode, nama, harga, stok);
        this.bahan = bahan;
    }

    @Override
    public String getInfo() {
        return "Alat Pertanian\n----------------------------------\n"
             + "Produk : " + getNama() + "\n"
             + "Kode   : " + getKode() + "\n"
             + "Harga  : Rp" + getHarga() + "\n"
             + "Stok   : " + getStok() + "\n"
             + "Bahan  : " + bahan + "\n";
    }}

```
### ObatHama.java
```java
package com.upb.agripos.model;

public class ObatHama extends Produk {
    private String bahanAktif;

    public ObatHama(String kode, String nama, double harga, int stok, String bahanAktif) {
        super(kode, nama, harga, stok);
        this.bahanAktif = bahanAktif;
    }

    @Override
    public String getInfo() {
        return "Obat Hama\n----------------------------------\n"
             + "Produk : " + getNama() + "\n"
             + "Kode   : " + getKode() + "\n"
             + "Harga  : Rp" + getHarga() + "\n"
             + "Stok   : " + getStok() + "\n"
             + "Bahan Aktif : " + bahanAktif + "\n";
    }
}
```
### CreditBy.java
```java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("=== Program dibuat oleh ===");
        System.out.println("NIM  : " + nim);
        System.out.println("Nama : " + nama);
    }
}
```
### MainPolymorphism.java
```java
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {
        // Demonstrasi overloading
        Produk contoh = new Produk("P-001", "Contoh Produk", 10000, 10);
        contoh.tambahStok(5);
        contoh.tambahStok(2.5);

        System.out.println("\n=== Demonstrasi Dynamic Binding ===\n");

        // Dynamic binding
        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja"),
            new ObatHama("OBT-301", "Racun Serangga", 120000, 25, "Deltamethrin")
        };

        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo());
        }


        // Credit info
        CreditBy.print("240202832", "Ditha Elita Putri");
    }
}
```
)
---

## Hasil Eksekusi

<img width="1920" height="1080" alt="week 4 (1)" src="https://github.com/user-attachments/assets/5ed8cfe0-b3e6-4202-9671-f2ed463f0db1" />

<img width="1920" height="1080" alt="week 4 (2)" src="https://github.com/user-attachments/assets/7e286170-39d6-4f2d-a84d-fd38bf4c44fc" />

---

## Analisis
- Pada percobaan kali ini, konsep polymorphism diterapkan melalui tiga bentuk utama, yaitu overloading, overriding, dan dynamic binding.
Program dimulai dari class Produk sebagai superclass yang memiliki method tambahStok() dengan dua versi berbeda (parameter int dan double), ini menunjukkan method overloading. Perbedaan parameter membuat method bisa dipanggil dengan nilai berbeda tanpa menimbulkan error.
- Selanjutnya, masing-masing subclass (Benih, Pupuk, AlatPertanian, dan ObatHama) melakukan method overriding terhadap getInfo(). Dengan begitu, setiap subclass menampilkan informasi yang lebih spesifik sesuai jenis produknya. Misalnya, Benih menampilkan atribut “Varietas”, sedangkan Pupuk menampilkan “Jenis”.
- Bagian dynamic binding terlihat saat array Produk[] daftarProduk berisi berbagai objek subclass. Walaupun semua elemen bertipe Produk, ketika dilakukan pemanggilan getInfo(), Java secara otomatis memanggil method sesuai jenis objek sebenarnya di runtime. Hal ini membuktikan bahwa Java mendukung polymorphism secara dinamis.
- Dibandingkan minggu sebelumnya yang hanya berfokus pada inheritance tanpa perilaku dinamis, minggu ini lebih menekankan bagaimana satu referensi superclass dapat merujuk ke berbagai bentuk objek turunan.
Kendala yang sempat muncul adalah saat mencoba memanggil method dari subclass tanpa casting yang tepat, namun setelah memahami konsep dynamic dispatch, masalah tersebut bisa teratasi.
---

## Kesimpulan
Dari praktikum minggu ini, dapat disimpulkan bahwa polymorphism memungkinkan satu nama method memiliki banyak perilaku berbeda tergantung konteks penggunaannya.
 - Overloading memberikan fleksibilitas dalam parameter method.
 - verriding memungkinkan subclass mengubah perilaku method superclass.
 - Dynamic binding memastikan pemanggilan method sesuai tipe objek sebenarnya saat runtime.
Dengan penerapan konsep ini, program menjadi lebih efisien, mudah dikembangkan, dan dapat menyesuaikan diri dengan berbagai jenis objek tanpa harus menulis kode berulang.

---

## Quiz
1. Apa perbedaan overloading dan overriding?  
   **Jawaban:** 
Overloading terjadi ketika dua atau lebih method memiliki nama yang sama tetapi parameter berbeda dalam satu class. Sedangkan overriding terjadi ketika subclass menulis ulang method dari superclass dengan nama, parameter, dan tipe return yang sama untuk mengubah perilakunya.

2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?  
   **Jawaban:**  
Java menentukan method yang dipanggil berdasarkan tipe objek sebenarnya di runtime, bukan tipe referensinya di compile time. Jadi, walaupun variabel bertipe Produk, jika objeknya Benih, maka method getInfo() milik Benih yang akan dijalankan.

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.  
   **Jawaban:**
Misalnya dalam sistem POS untuk supermarket, class Barang bisa memiliki subclass seperti Makanan, Minuman, dan Elektronik. Semua memiliki method getInfo(), namun hasilnya berbeda — Makanan menampilkan tanggal kedaluwarsa, Minuman menampilkan volume, dan Elektronik menampilkan garansi.
