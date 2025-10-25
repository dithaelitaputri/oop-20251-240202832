# Laporan Praktikum Minggu 4 
Topik: Polymorphism (Info Produk)

## Identitas
- Nama  : Hanifah
- NIM   : 240202864
- Kelas : 3 IKRA

---

## Tujuan

    Mahasiswa mampu menjelaskan konsep polymorphism dalam OOP.
    Mahasiswa mampu membedakan method overloading dan overriding.
    Mahasiswa mampu mengimplementasikan polymorphism (overriding, overloading, dynamic binding) dalam program.
    Mahasiswa mampu menganalisis contoh kasus polymorphism pada sistem nyata (Agri-POS).


---

## Dasar Teori
Polymorphism berarti “banyak bentuk” dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.
1. Overloading → mendefinisikan method dengan nama sama tetapi parameter berbeda.
2. Overriding → subclass mengganti implementasi method dari superclass.
3. Dynamic Binding → pemanggilan method ditentukan saat runtime, bukan compile time.

Dalam konteks Agri-POS, misalnya:
1. Method getInfo() pada Produk dioverride oleh Benih, Pupuk, AlatPertanian untuk menampilkan detail spesifik.
2. Method tambahStok() bisa dibuat overload dengan parameter berbeda (int, double).

---

## Langkah Praktikum
1. Overloading
   Tambahkan method tambahStok(int jumlah) dan tambahStok(double jumlah) pada class Produk.
2. Overriding
   Tambahkan method getInfo() pada superclass Produk.
   Override method getInfo() pada subclass Benih, Pupuk, dan AlatPertanian.
3. Dynamic Binding
   Buat array Produk[] daftarProduk yang berisi objek Benih, Pupuk, dan AlatPertanian.
   Loop array tersebut dan panggil getInfo(). Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual.
4. Main Class
   Buat MainPolymorphism.java untuk mendemonstrasikan overloading, overriding, dan dynamic binding.
5. CreditBy
   Tetap panggil CreditBy.print("<NIM>", "<Nama>").
6. Commit dan Push
   Commit dengan pesan: week4-polymorphism.


---

## Kode Program
1. AlatPertanian  

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
    }
}
```

2. Benih.java 

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

3. ObatHama.java

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

4. Produk.java

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

5. Pupuk.java

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

6. CreditBy.java

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

7. MainPolymorphism.java

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
        CreditBy.print("240202864", "Hanifah");
    }
}

```

---

## Hasil Eksekusi
![alt text](<Cuplikan layar 2025-10-25 155911.png>)
![alt text](<Cuplikan layar 2025-10-25 155931.png>)
---

## Analisis

- Jelaskan bagaimana kode berjalan.  
1. Method tambahStok() menunjukkan overloading, karena memiliki dua versi dengan parameter berbeda.
2. Method getInfo() di setiap subclass menunjukkan overriding, karena mengganti perilaku dari method di superclass.
3. Polymorphism terjadi ketika array Produk[] berisi berbagai subclass. Saat getInfo() dipanggil, Java secara dinamis memilih method yang sesuai dengan tipe objek sebenarnya.
- Kendala yang dihadapi dan cara mengatasinya.  
1. Kendala: saat pertama kali dijalankan, muncul error karena file belum dipisah sesuai nama class
2. Solusinya: pastikan setiap class berada di file .java dengan nama yang sama

---

## Kesimpulan
Dengan menerapkan konsep Polymorphism, Overloading, dan Overriding, program menjadi:
1. Lebih fleksibel dalam menangani berbagai jenis objek dengan satu antarmuka umum.
2. Lebih mudah dikembangkan karena method dapat diubah sesuai kebutuhan subclass.
3. Lebih efisien karena method yang dipanggil disesuaikan secara dinamis saat runtime.
---

## Quiz
1. Apa perbedaan overloading dan overriding? 
   **Jawaban:**  Overloading terjadi saat dua method memiliki nama sama namun parameter berbeda, sedangkan Overriding mengganti implementasi method yang sudah ada di superclass.

2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?
   **Jawaban:** Dalam dynamic binding, Java menentukan method yang dipanggil berdasarkan tipe objek aktual (bukan tipe referensinya) saat program dijalankan (runtime).Artinya, meskipun referensinya bertipe Produk, jika objek aslinya adalah Benih, maka method getInfo() milik Benih yang akan dijalankan.

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian.
   **Jawaban:**  Contoh penerapan polymorphism dalam sistem Point of Sales (POS) selain produk pertanian:
   1. Pada toko elektronik, terdapat superclass Barang dengan subclass seperti Laptop, Smartphone, dan Televisi.
   2. Semua subclass tersebut memiliki method getInfo() sendiri untuk menampilkan spesifikasi yang berbeda, misalnya kapasitas RAM, ukuran layar, atau daya listrik.
   3. Saat disimpan dalam array Barang[], setiap objek akan memanggil method getInfo() sesuai jenis produk sebenarnya (dynamic binding).
