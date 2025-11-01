# Laporan Praktikum Minggu 3 
Topik: Bab 3 – Inheritance

## Identitas
- Nama  : Ditha Elita Putri
- NIM   : 240202832
- Kelas : 3 IKRA

---

## Tujuan
- Mahasiswa mampu **menjelaskan konsep inheritance (pewarisan class)** dalam OOP.  
- Mahasiswa mampu **membuat superclass dan subclass** untuk produk pertanian.  
- Mahasiswa mampu **mendemonstrasikan hierarki class** melalui contoh kode.  
- Mahasiswa mampu **menggunakan `super` untuk memanggil konstruktor dan method parent class**.  
- Mahasiswa mampu **membuat laporan praktikum** yang menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.
  
---

## Dasar Teori
Inheritance (pewarisan) adalah konsep dalam pemrograman berorientasi objek (OOP) yang memungkinkan sebuah class mewarisi sifat dan perilaku dari class lain.
  - Superclass adalah class induk yang berisi atribut dan fungsi umum.
  - Subclass adalah class turunan yang mengambil atribut dan fungsi dari superclass, lalu bisa menambahkan hal-hal baru sesuai kebutuhannya.
  -Kata kunci super digunakan untuk memanggil konstruktor atau method milik superclass.
  - Dalam contoh sistem Agri-POS, kita bisa membuat class Produk sebagai class induk, lalu membuat class Benih, Pupuk, dan AlatPertanian sebagai class turunannya.

---

## Langkah Praktikum
1. **Membuat Superclass Produk**
    - Gunakan class `Produk` dari Bab 2 sebagai superclass.

2. **Membuat Subclass**
    - `Benih.java` → atribut tambahan: varietas.
    - `Pupuk.java` → atribut tambahan: jenis pupuk (Urea, NPK, dll).
    - `AlatPertanian.java` → atribut tambahan: material (baja, kayu, plastik).

3. **Membuat Main Class**
    - Instansiasi minimal satu objek dari tiap subclass.
    - Tampilkan data produk dengan memanfaatkan inheritance.

4. **Menambahkan CreditBy**
    - Panggil class `CreditBy` untuk menampilkan identitas mahasiswa.

5. **Commit dan Push**
    - Commit dengan pesan: `week3-inheritance`.

---

## Kode Program


## 1. Produk.java

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

## 2. Benih.java
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

## 3. Pupuk.java
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

### 4. AlatPertanian.java
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

### 5.CreaditBy.java
```java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\n=== Credit By ===");
        System.out.println("NIM  : " + nim);
        System.out.println("Nama : " + nama);
    }
}
```

## 6.MainInheritance.java
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

        CreditBy.print("240202832", "Ditha Elita Putri");
    }
}
```
---

## Hasil Eksekusi
<img width="1920" height="1080" alt="hasil week 3" src="https://github.com/user-attachments/assets/ba14b5db-17bf-4c23-9123-59324489af21" />
---

## Analisis
- Pada praktikum minggu ini, saya mempelajari dan menerapkan konsep inheritance di Java. Saya membuat class Produk sebagai superclass, lalu menurunkan tiga class yaitu Benih, Pupuk, dan AlatPertanian sebagai subclass yang mewarisi atribut dan method dari class induknya.
- Di awal, saya sempat mengalami kendala karena struktur folder tidak sesuai dengan deklarasi package com.upb.agripos.model, sehingga file tidak terbaca saat dijalankan. Setelah saya ubah struktur folder menjadi sesuai dengan penulisan package pada setiap file, program akhirnya bisa dikompilasi dan dijalankan tanpa error.
- Class Produk berisi atribut umum seperti kode, nama, harga, dan stok, serta method tampilInfo() untuk menampilkan data produk. Kemudian, masing-masing subclass saya tambahkan atribut khusus, yaitu:
Benih,memiliki atribut varietas,
Pupuk, memiliki atribut jenis, dan
AlatPertanian, memiliki atribut material.
-Setiap subclass juga memiliki method deskripsi() untuk menampilkan detail produk sekaligus memanggil method tampilInfo() dari superclass. Di class MainInheritance, saya membuat objek dari masing-masing subclass dan menambahkan beberapa System.out.println() agar hasil antar produk terlihat lebih rapi di konsol.

---

## Kesimpulan
Dengan menerapkan konsep inheritance, program menjadi lebih terstruktur, efisien, dan mudah dikembangkan. Atribut serta method yang bersifat umum cukup dibuat satu kali di superclass (Produk), lalu dapat digunakan oleh berbagai subclass tanpa perlu penulisan ulang. Pendekatan ini membuat kode lebih rapi, meminimalkan duplikasi, serta memudahkan perawatan dan pengembangan sistem di masa mendatang.

---

## Quiz
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?  
   **Jawaban:** Dengan inheritance, kita tidak perlu menulis kode yang sama berulang kali. Class turunan bisa langsung memakai atribut dan method dari class induk, jadi kode lebih singkat, rapi, dan mudah diubah kalau ada perbaikan

2. Bagaimana cara subclass memanggil konstruktor superclass?  
   **Jawaban:** Subclass bisa memanggil konstruktor dari superclass dengan keyword super(), biasanya ditulis di baris pertama konstruktor subclass.

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass.  
   **Jawaban:** Contohnya HasilPanen. Class ini bisa dibuat sebagai turunan dari Produk karena hasil panen juga termasuk barang yang dijual di sistem pertanian.
Atribut tambahannya bisa seperti:
jenisTanaman (misalnya: padi, jagung, sayur)
beratPanen (dalam kilogram)
Dengan begitu, HasilPanen bisa menyimpan data produk hasil panen lengkap, tapi tetap memakai atribut umum dari Produk seperti kode, nama, harga, dan stok.

