# Laporan Praktikum Minggu 2 
Topik: Class dan Object

## Identitas
- Nama  : Hanifah
- NIM   : 240202864
- Kelas : 3 IKRA

---

## Tujuan
Mahasiswa mampu menjelaskan konsep class, object, atribut, dan method dalam OOP.
Mahasiswa mampu menerapkan access modifier dan enkapsulasi dalam pembuatan class.
Mahasiswa mampu mengimplementasikan class Produk dengan atribut dan method yang sesuai.
Mahasiswa mampu mendemonstrasikan instansiasi object serta menampilkan data produk di console.

---

## Dasar Teori
1. Class adalah blueprint dari objek.  
2. Object adalah instansiasi dari class yang berisi atribut (data) dan method (perilaku).   
3. Enkapsulasi digunakan untuk menyembunyikan data menggunakan access modifier (public, private, protected) serta menyediakan akses melalui getter dan setter.


---

## Langkah Praktikum
Membuat Class Produk
   1. Buat file Produk.java pada package model.
   2. Tambahkan atribut: kode, nama, harga, dan stok.
   3. Gunakan enkapsulasi dengan menjadikan atribut bersifat private dan membuat getter serta setter untuk masing-masing atribut.

 Membuat Class CreditBy
   1. Buat file CreditBy.java pada package util.
   2. Isi class dengan method statis untuk menampilkan identitas mahasiswa di akhir output: credit by: 240202864 - Hanifah.

 Membuat Objek Produk dan Menampilkan Credit
   1. Buat file MainProduk.java.
   2. Instansiasi minimal tiga objek produk, misalnya "Totebag", "Kemeja", "Flat Shose".
   3. Tampilkan informasi produk melalui method getter.
   4. Panggil CreditBy.print("240202864", "Hanifah") di akhir main untuk menampilkan identitas.

 Commit dan Push
   1. Commit dengan pesan: week2-class-object.
---

## Kode Program

1. Produk.java  

```java
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
        if (jumlah > 0) {
            this.stok += jumlah;
        } else {
            System.out.println("Jumlah stok yang ditambahkan tidak boleh ditambahkan!");
            
        }
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }
}
```
2. CreditBy.java

```java
package main.java.com.upb.agripos.util;
// creditBy.java


public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " +  nama + " - " +  nim);
    }
}
```
3. MainProduk.java

```java
package main.java.com.upb.agripos.util;

import main.java.com.upb.agripos.model.Produk;
import main.java.com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("TOB-001", "Totebag ", 60000, 50);
        Produk p2 = new Produk("KMJ-002", "Kemeja", 80000, 30);
        Produk p3 = new Produk("FLS-003", "Flat Shoes", 40000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());
        
        System.out.println("perubahan stok") ;
        p1.tambahStok(10);
        p2.kurangiStok(5);

        System.out.println(p1.getNama() + " Sisa Stok: " + p1.getStok()) ;
        System.out.println(p2.getHarga() + " Sisa Stok: " + p2.getStok()) ;

        // Tampilkan identitas mahasiswa
        CreditBy.print("240202864", "Hanifah");
    }
}
```

---

## Hasil Eksekusi
![alt text](<Cuplikan layar 2025-10-08 144907.png>)
---

## Analisis

- Jelaskan bagaimana kode berjalan.  
Produk.java dalam konteks aplikasi (misal aplikasi kasir atau gudang), class Produk akan digunakan seperti ini:
1. Membuat objek produk saat input data barang baru.
2. Mengubah data jika ada perubahan harga atau stok.
3. Melakukan transaksi dengan memanggil kurangiStok() saat pembelian.
4. Mengisi ulang stok dengan tambahStok(). 
CreditBy.java class ini dibuat untuk menampilkan informasi kredit atau identitas pembuat program, biasanya digunakan di akhir program untuk menyatakan siapa yang membuat/mengembangkan aplikasi.
MainProduk untuk menampilkan daftar produk (beserta kode, nama, harga, dan stok), kemudian mencetak identitas pembuat program.  

---

## Kesimpulan
Program ini merupakan contoh yang baik dari penggunaan class terpisah, modularisasi kode, dan encapsulation, yang sangat penting dalam pengembangan aplikasi skala besar. Selain itu, mencantumkan identitas pembuat memberikan nilai tambah dari sisi dokumentasi dan profesionalitas. Jika dikembangkan lebih lanjut, program ini bisa menjadi bagian dari sistem manajemen produk secara digital.
---

## Quiz
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?
Jawaban:
Untuk menjaga keamanan dan integritas data. Dengan menjadikan atribut private, data tidak bisa diakses atau diubah secara langsung dari luar class, sehingga dapat mencegah perubahan yang tidak diinginkan dan memastikan bahwa semua akses terhadap data dilakukan melalui metode yang dikontrol (seperti getter dan setter). Ini adalah prinsip utama dari enkapsulasi dalam pemrograman berorientasi objek.
2. Apa fungsi getter dan setter dalam enkapsulasi?
Jawaban:
Getter dan setter berfungsi sebagai antarmuka (interface) untuk mengakses dan mengubah nilai atribut private. Getter digunakan untuk mengambil (membaca) nilai atribut, sedangkan setter digunakan untuk mengubah nilai atribut dengan logika tertentu jika diperlukan (misalnya validasi data). 
3. Bagaimana cara class Produk mendukung pengembangan aplikasi POS yang lebih kompleks?
Jawaban:
Class Produk dapat menjadi fondasi utama dalam aplikasi Point of Sale (POS) karena mewakili entitas barang yang dijual. Dengan mendefinisikan atribut seperti nama, harga, dan stok dalam class Produk, serta menyediakan metode untuk mengelola data tersebut (misalnya mengurangi stok saat transaksi), kita dapat membangun sistem yang modular dan mudah dikembangkan. Dalam aplikasi POS yang lebih kompleks, class Produk bisa diperluas untuk mendukung fitur seperti kategori produk, diskon, barcode, pelacakan inventaris, dan integrasi dengan sistem lain seperti kasir atau laporan penjualan.

