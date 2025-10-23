# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : Hanifah
- NIM   : 240202864
- Kelas : 3 IKRA

---

## Tujuan
Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
Mahasiswa mampu membuat superclass dan subclass untuk produk pertanian.
Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.
Mahasiswa mampu menggunakan super untuk memanggil konstruktor dan method parent class.

---

## Dasar Teori
Inheritance adalah mekanisme dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain.
1. Superclass: class induk yang mendefinisikan atribut umum.
2. Subclass: class turunan yang mewarisi atribut/method superclass, dan dapat menambahkan atribut/method baru.
3. super digunakan untuk memanggil konstruktor atau method superclass.

---

## Langkah Praktikum
1. Membuat Superclass Produk
   Gunakan class Produk dari Bab 2 sebagai superclass.
2. Membuat Subclass
   Benih.java → atribut tambahan: varietas.
   Pupuk.java → atribut tambahan: jenis pupuk (Urea, NPK, dll).
   AlatPertanian.java → atribut tambahan: material (baja, kayu, plastik).
3. Membuat Main Class
   Instansiasi minimal satu objek dari tiap subclass.
   Tampilkan data produk dengan memanfaatkan inheritance.
4. Menambahkan CreditBy
   Panggil class CreditBy untuk menampilkan identitas mahasiswa.
5. Commit dan Push


---

## Kode Program
1. AlatPertanian  

```java
package com.upb.agripos.model;


public class AlatPertanian extends Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

        public void deskripsi() {
        System.out.println("=== Alat Pertanian ===");
        tampilInfo();
        System.out.println("Material: " + material);
        System.out.println("Keterangan: Alat pertanian ini terbuat dari material kuat dan tahan lama.");
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

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }

    public void deskripsi() {
        System.out.println("=== Benih ===");
        tampilInfo();
        System.out.println("Varietas: " + varietas);
        System.out.println("Keterangan: Benih ini cocok untuk berbagai jenis lahan dan tahan terhadap hama.");
    }
}
```
3. Produk.java

```java
package com.upb.agripos.model;
// Produk.java

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

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void setKode(String kode) { this.kode = kode; }
    public void setNama(String nama) { this.nama = nama; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }

    public void tampilInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
    }

}
```
4. Pupuk.java

```java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public void deskripsi() {
        System.out.println("=== Pupuk ===");
        tampilInfo();
        System.out.println("Jenis: " + jenis);
        System.out.println("Keterangan: Pupuk ini membantu meningkatkan kesuburan tanah dan hasil panen.");
    }
}
```
5. Maininheritance.java

```java
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        b.deskripsi();
        System.out.println();
        p.deskripsi();
        System.out.println();
        a.deskripsi();
        System.out.println();

        CreditBy.print("240202864", "Hanifah");
    }
}
)
```
---

## Hasil Eksekusi
<img width="1366" height="768" alt="Cuplikan layar 2025-10-22 120650" src="https://github.com/user-attachments/assets/0126cd06-b67f-4a7c-a179-994f61e5e88c" />

---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
1. Konsep Dasar Program
Program ini menerapkan konsep Inheritance (pewarisan) dalam Object-Oriented Programming (OOP).
Kelas Produk berfungsi sebagai superclass yang menyimpan atribut umum semua produk pertanian
2. Alur Eksekusi Program
membuat objek dari subclass dan memanggil konstruktor masing-masing.Menampilkan deskripsi tiap produk. Memanggil CreditBy
3. Inti Konsep yang Ditunjukkan
Inheritance (pewarisan)	Benih, Pupuk, AlatPertanian mewarisi dari Produk
Encapsulation (enkapsulasi)	Atribut di-private, diakses lewat getter dan setter
Polymorphism (bisa ditambahkan)	Setiap subclass punya metode deskripsi() dengan isi berbeda
Reusability (kode bisa digunakan ulang)	tampilInfo() dari Produk digunakan oleh semua subclass
4. Gambaran Output Lengkap
Ketika dijalankan, output di console akan muncul sesuai perintah program
---

## Kesimpulan
1. Lebih efisien, karena kode umum tidak perlu ditulis berulang di setiap kelas.
2. Lebih terstruktur, karena setiap jenis produk memiliki kelas yang jelas dengan hubungan hierarkis
3. Mudah dikembangkan, karena jika nanti ingin menambah jenis produk lain (misalnya “Pestisida” atau “Pakan Ternak”), cukup membuat subclass baru yang mewarisi dari Produk.
4. Menerapkan prinsip OOP seperti encapsulation (pengamanan atribut lewat getter/setter) dan polymorphism (metode deskripsi() berbeda di tiap subclass).
---

## Quiz
(1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?
    Jawaban: 
    Menghindari duplikasi kode, karena subclass dapat mewarisi atribut dan metode dari superclass.
    Memudahkan pemeliharaan dan pengembangan kode.
    Meningkatkan keteraturan dan hubungan antar objek (mewakili hierarki yang logis).
    Mendukung prinsip reusability dan extensibility dalam pemrograman berorientasi objek.

 2. Bagaimana cara subclass memanggil konstruktor superclass?
    Jawaban: Subclass memanggil konstruktor superclass menggunakan kata kunci super() di dalam konstruktor subclass.

 3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass.
    Jawaban: 
    Pestisida → subclass dari ProdukPertanian
    Bibit Tanaman Buah → subclass dari ProdukPertanian
    Obat Hewan Ternak → subclass dari ProdukPertanian
    Pakan Ternak → subclass dari ProdukPertanian
    Produk Panen (misal Beras, Jagung, Kedelai) → subclass dari ProdukPertanian

