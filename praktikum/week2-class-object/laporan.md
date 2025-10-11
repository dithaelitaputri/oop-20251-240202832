# Laporan Praktikum Minggu 2 
Topik: Class dan Object

## Identitas
- Nama  : Ditha Elita Putri
- NIM   : 240202832
- Kelas : 3IKRA

---

## Tujuan
1. Mahasiswa mampu menjelaskan konsep class, object, atribut, dan method dalam OOP.
2. Mahasiswa mampu menerapkan access modifier dan enkapsulasi dalam pembuatan class.
3. Mahasiswa mampu mengimplementasikan class Produk pertanian dengan atribut dan method yang sesuai.
4. Mahasiswa mampu mendemonstrasikan instansiasi object serta menampilkan data produk pertanian di console.

---

## Dasar Teori
1. Class adalah blueprint dari objek, atau rancangan untuk membuat objek.
Di dalam class terdapat atribut (variabel) yang menyimpan data dan method(fungsi) yang menentukan perilaku objek
 - Atribut yaitu data yang dimiliki oleh class
   Contoh: nama, harga, stok adalah atribut dalam class Produk
 - Method yaitu Fungsi atau perilaku yang bisa dilakukan oleh objek
   Contoh: getNama() atau setHarga() adalah method
2. Object adalah instansiasi dari class dan punya data sendiri
   Contoh: Produk p1 = new Produk(); → p1 adalah objek
4. Enkapsulasi digunakan untuk menyembunyikan data. Agar tidak bisa diakses langsung dari luar class, tapi melalui method khusus (getter & setter).

---

## Langkah Praktikum
1. Membuat Class 
- Buat file Produk.java di folder model berisi class untuk mendefinisikan atribut dan perilaku produk (kode, nama, harga, stok, tambah/kurangi stok).
- Buat file CreditBy.java di folder util untuk menampilkan identitas pembuat program.
- Buat file MainProduk.java di folder agripos sebagai program utama untuk menjalankan seluruh kode (membuat objek, menampilkan data, dan melakukan transaksi stok).

2. kode yang dibuat.
- Produk.java berisi class produk dengan atribut dan method tambahStok() serta kurangiStok().
-  CreditBy.java menampilkan identitas pembuat program.
- MainProduk.java program utama untuk menjalankan logika dan menampilkan hasil.
   
3. Commit dan push

---

## Kode Program

Produk
```
package main.java.com.upb.agripos.model;
// produk.java

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
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
        System.out.println("\n===TRANSAKSI MASUK===");
        System.out.println("Produk : " + nama + ", " + kode);
        System.out.println("Jumlah : +" + jumlah);
        System.out.println("Stok Sekarang : " + stok);
        System.out.println("---------------------------");
    }

public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
            System.out.println("\n===TRANSAKSI KELUAR===");
            System.out.println("Produk : " + nama + ", " + kode);
            System.out.println("Jumlah : -" + jumlah);
            System.out.println("Stok Sekarang : " + stok);
            System.out.println("---------------------------");
        } else {
            System.out.println("\nStok " + nama + ", " + kode + " tidak mencukupi!");
            System.out.println("Stok tersedia : " + stok + " | Diminta : " + jumlah);
            System.out.println("---------------------------");
        }
    }
}


```
CreaditBy
```
package main.java.com.upb.agripos.util;
// creditBy.java

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " +  nama + " - " +  nim);
    }
}


```
MainProduk
```
package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.Produk;
import main.java.com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("KMJ-001", "Kemeja", 95000, 100);
        Produk p2 = new Produk("DSH-002", "Dasi Hitam", 15000, 40);
        Produk p3 = new Produk("TPP-003", "Topi Pramuka", 20000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());
        

        // Transaksi penambahan stok
        p1.tambahStok(5); // stok datang dari gudang
      

        // Transaksi pengurangan stok
         p2.kurangiStok(20); // produk dibeli pelanggan

        // Tampilkan identitas mahasiswa
        CreditBy.print("240202832", "Ditha Elita Putri");
        
    }
}

```

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)

```

## Analisis

- Program ini berjalan dimulai dari file MainProduk.java, di mana tiga objek produk dibuat menggunakan class Produk. Setiap objek memiliki data sendiri seperti kode, nama, harga, dan stok yang disimpan dalam atribut class tersebut. Setelah objek dibuat, program menampilkan informasi produk satu per satu, lalu menjalankan method tambahStok() untuk menambah stok dan kurangiStok() untuk mengurangi stok ketika ada transaksi. Pada akhir program, class CreditBy digunakan untuk menampilkan identitas pembuat program di layar. Dengan cara kerja ini, setiap bagian kode memiliki fungsi yang jelas dan saling terhubung melalui konsep objek.
  
- Jika sebelumnya program masih menggunakan cara prosedural, di mana semua perintah ditulis langsung dalam satu file tanpa pemisahan fungsi, maka kali ini setiap bagian dibuat dalam class tersendiri.

- Kendala yang kendala yang sering muncul adalah kesalahan pada struktur folder dan package yang tidak sesuai dengan letak file Java, sehingga program tidak bisa dijalankan dengan benar.

---

## Kesimpulan
Dengan menggunakan class dan object, program menjadi lebih terstruktur, rapi, dan mudah dipahami. Setiap bagian kode memiliki fungsi yang jelas data disimpan dalam atribut, sedangkan perilaku ditulis dalam method. Pendekatan berorientasi objek ini juga membuat program lebih mudah dikembangkan dan dikelola dibandingkan cara prosedural, karena setiap class dapat digunakan kembali tanpa harus menulis ulang seluruh kode.
---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
