# Laporan Praktikum Minggu 1 
Topik: Pengenalan Paradigma dan Setup Proyek

## Identitas
- Nama  : Hanifah
- NIM   : 240202864
- Kelas : 3 IKRA

---
 
## Tujuan
   
    1. Mahasiswa mampu mendefinisikan paradigma prosedural, OOP, dan fungsional. 
    2. Mahasiswa mampu membandingkan kelebihan dan keterbatasan tiap paradigma. 
    3. Mahasiswa mampu memberikan contoh program sederhana untuk masing-masing paradigma. 
    


---

## Dasar Teori
  
Paradigma pemrograman adalah pendekatan atau gaya dalam menulis dan mengorganisasi kode program.
Setup proyek adalah langkah awal dalam membangun lingkungan kerja yang siap untuk pengembangan perangkat lunak.
1. Prosedural: program dibangun sebagai rangkaian perintah (fungsi/prosedur).
2. OOP (Object-Oriented Programming): program dibangun dari objek yang memiliki data (atribut) dan perilaku (method).
3. Fungsional: program dipandang sebagai pemetaan fungsi matematika, lebih menekankan ekspresi dan transformasi data.


---

## Langkah Praktikum
Prosedural

1. Persiapkan Lingkungan :Pastikan JDK sudah terpasang.Jika belum terpasang, download dan install JDK dari https://www.oracle.com/java/technologies/javase-downloads.html
2. Buat File Program : Buka teks editor, ketik kode dan simpan dengan nama HelloProcedural.java
3. Kompilasi Program : Buka terminal dan arahkan ke direktori tempat file disimpan, lalu jalankan perintah javac HelloProcedural.java
maka akan terbentuk file HelloProcedural.class.
4. Jalankan Program : Jika berhasil akan muncul otput sesuai program 

OOP

1. Persiapkan Lingkungan :Pastikan JDK sudah terpasang.Jika belum terpasang, download dan install JDK dari https://www.oracle.com/java/technologies/javase-downloads.html
2. Buat File Program Java : Buka teks editor, ketik kode dan simpan dengan nama HelloOOP.java
3. Kompilasi Program : Buka terminal dan arahkan ke folder tempat file HelloOOP.java disimpan, lalu jalankan perintah javac HelloOOP.java maka akan terbentuk file HelloOOP.class dan Produk.class
4. Jalankan Program : Jika berhasil akan muncul otput sesuai program

Fungsional 

1. Persiapkan Lingkungan :Pastikan JDK sudah terpasang.Jika belum terpasang, download dan install JDK dari https://www.oracle.com/java/technologies/javase-downloads.html
2. Buat File Program : Buka teks editor, ketik kode dan simpan dengan nama HelloFunctional.java
3. Kompilasi Program : Buka terminal dan arahkan ke direktori tempat file HelloFunctional.java disimpan, jalankan perintah javac HelloFunctional.java
4. Jalankan Program : Jika berhasil akan muncul otput sesuai program
---

## Kode Program
1. Prosedural  

```java
public class HelloProcedural {
    public static void main(String[] args) {
        // Paradigma prosedural: langsung instruksi urut
        String nama = "Hanifah";
        String nim = "240202864";
        System.out.println("Hello World, I am " + nama + "-" + nim);
    }
}


2. OOP

// HelloOOP.java
class Person {
    private String name;
    private String nim;

    public Person(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

    public void sayHello() {
        System.out.println("Hello World, I am " + name + "-" + nim);
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        Person me = new Person("Hanifah", "240202864");
        me.sayHello();
    }
}

3. Fungsional

// HelloFunctional.java
import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {
        // Paradigma fungsional: pakai fungsi murni (lambda)
        BiConsumer<String, String> sayHello = (name, nim) -> 
            System.out.println("Hello World, I am " + name + "-" + nim);

        sayHello.accept("Hanifah", "240202864");
    }
}

```

---

## Hasil Eksekusi
1. Prosedural  
<img width="1366" height="768" alt="Cuplikan layar 2025-10-05 142236" src="https://github.com/user-attachments/assets/79ab8ba9-ff67-4149-a190-43ecf26332be" />

2. OOP
<img width="1366" height="768" alt="Cuplikan layar 2025-10-05 142522" src="https://github.com/user-attachments/assets/da833a9e-6391-43d0-9d67-b4e6a33c5d72" />

3. Fungsional
<img width="1366" height="768" alt="Cuplikan layar 2025-10-05 142647" src="https://github.com/user-attachments/assets/ead10283-b8c0-465b-b6e8-1dd83965c6b6" />


---

## Analisis
Jelaskan bagaimana kode berjalan.
  1. Prosedural
  Cara Kerja: Semua logika disusun secara urutan langkah demi langkah (step-by-step). Data (nim, nama, produk, harga) didefinisikan langsung dalam fungsi main.
  Proses: Inisialisasi data, Menampilkan output ke layar, Melakukan perhitungan total dengan loop for, Mencetak hasil akhir
  2. OOP (Object-Oriented Programming)
  Cara Kerja: Program dibangun berdasarkan objek dan kelas (Produk sebagai class). Data dan perilaku dikelompokkan bersama dalam objek.
  Proses: Buat objek Produk dengan konstruktor, Simpan dalam array objek, Iterasi array untuk tampilkan data dan hitung total, Output hasil
  3. Fungsional
  Cara Kerja: Program ditulis secara deklaratif, fokus pada "apa" yang dilakukan, bukan "bagaimana". Gunakan fitur lambda dan Stream API untuk manipulasi koleksi.
  Proses: Definisikan list produk dan harga, Gunakan IntStream.range() untuk menampilkan data, Hitung total dengan stream().mapToInt().sum(), Tampilkan hasil    

---

## Kesimpulan
1. Prosedural: Cocok untuk pemula dan tugas sederhana. Cepat dibuat, tapi kurang skalabel.
2. OOP: Ideal untuk aplikasi yang kompleks dan bertumbuh. Struktur kode lebih rapi dan terorganisir.
3. Fungsional: Kuat dalam pengolahan data, kode bersih, dan performansi tinggi di skala besar. Cocok untuk sistem modern berbasis data dan concurrency.
---

## Quiz

1. Apakah OOP selalu lebih baik dari prosedural?
   
   Jawaban: Tidak selalu. OOP (Object-Oriented Programming) lebih unggul dalam proyek berskala besar, kompleks, dan yang memerlukan modularitas serta reuse kode. Namun, prosedural lebih
   sederhana dan efisien untuk program kecil atau skrip cepat, di mana struktur objek tidak dibutuhkan. Pemilihan paradigma tergantung pada kebutuhan proyek, tim, dan tujuan jangka panjang.
2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?
   
   Jawaban: Functional programming lebih cocok digunakan ketika:
   - Aplikasi memproses data dalam jumlah besar atau kompleksitas tinggi, seperti dalam big data, stream processing, atau machine learning.
   - Dibutuhkan kode yang lebih bersih, singkat, dan minim efek samping.
   - Paralelisme atau concurrency sangat penting, karena FP mendukung immutable state dan fungsi murni.
   Contoh: pemrosesan data di Spark, aplikasi backend berbasis event-stream, atau pipeline data analytics.
3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?

   Jawaban: Prosedural: Mudah dipahami dan diimplementasikan, tetapi saat skala aplikasi membesar, struktur bisa menjadi tidak terorganisir (spaghetti code), sehingga sulit untuk di-maintain.
   OOP: Memberikan struktur yang modular dan terorganisir melalui class dan objek. Cocok untuk aplikasi berskala besar, karena lebih mudah di-maintain, diuji, dan diperluas.
   Fungsional: Memudahkan testing, debugging, dan concurrency karena menghindari efek samping. Cocok untuk aplikasi yang berskala besar dan intensif data, tetapi bisa menantang bagi
   developer yang tidak terbiasa.
4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?

   Jawaban: Karena POS (Point of Sale) adalah sistem yang melibatkan berbagai entitas seperti Produk, Pelanggan, Transaksi, Pegawai, dan Stok.
   Paradigma OOP memungkinkan:
   - Representasi real-world dalam bentuk objek dan class.
   - Modularitas dan enkapsulasi, sehingga fitur bisa dikembangkan secara terpisah (misalnya modul kasir, stok, laporan).
   - Pemeliharaan lebih mudah, karena struktur kode lebih jelas.
   - Kemudahan ekspansi, seperti penambahan fitur pembayaran digital atau diskon tanpa merombak keseluruhan sistem.
5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?

   Jawaban: Paradigma fungsional menggunakan:
   - Higher-order functions (fungsi yang menerima fungsi lain sebagai parameter)
   - Stream API dan operasi deklaratif (seperti .map(), .filter(), .reduce()), yang menghilangkan kebutuhan akan loop berulang dan variabel sementara.
   - Immutability dan fungsi murni, yang membuat kode lebih prediktif dan terstruktur tanpa banyak deklarasi tambahan.
   Hasilnya, kode menjadi Lebih pendek dan mudah dibaca, Lebih konsisten, Lebih mudah diuji dan dipelihara, Sehingga mengurangi boilerplate dan meningkatkan produktivitas.


