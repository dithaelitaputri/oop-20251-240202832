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
(1. Prosedural  

```java
// HelloProcedural.java
public class HelloProcedural {
   public static void main(String[] args) {
      String nim = "240202864";
      String nama = "Hanifah";
      String[] produk = {"Beras", "Pupuk", "Benih"};
      int[] harga = {10000, 15000, 12000};
      int total = 0;
      System.out.println("Hello World, I am Hanifah-240202864");
      System.out.println("NIM: " + nim + ", Nama: " + nama);
      System.out.println("Daftar Produk:");
      for (int i = 0; i < produk.length; i++) {
         System.out.println("- " + produk[i] + ": " + harga[i]);
         total += harga[i];
      }
      System.out.println("Total harga semua produk: " + total);
   }
}


2. OOP

// HelloOOP.java
class Produk {
   String nama;
   int harga;
   Produk(String nama, int harga) {
      this.nama = nama;
      this.harga = harga;
   }
}

public class HelloOOP {
   public static void main(String[] args) {
      String nim = "240202864";
      String namaMhs = "Hanifah";
      Produk[] daftar = {
         new Produk("Beras", 10000),
         new Produk("Pupuk", 15000),
         new Produk("Benih", 12000)
      };
      int total = 0;
      System.out.println("Hello World, I am Hanifah-240202864");
      System.out.println("NIM: " + nim + ", Nama: " + namaMhs);
      System.out.println("Daftar Produk:");
      for (Produk p : daftar) {
         System.out.println("- " + p.nama + ": " + p.harga);
         total += p.harga;
      }
      System.out.println("Total harga semua produk: " + total);
   }
}

3. Fungsional

// HelloFunctional.java
import java.util.*;
import java.util.stream.*;
public class HelloFunctional {
   public static void main(String[] args) {
      String nim = "240202864";
      String nama = "Hanifah";
      List<String> produk = Arrays.asList("Beras", "Pupuk", "Benih");
      List<Integer> harga = Arrays.asList(10000, 15000, 12000);
      System.out.println("Hello World, I am Hanifah-240202864");
      System.out.println("NIM: " + nim + ", Nama: " + nama);
      System.out.println("Daftar Produk:");
      IntStream.range(0, produk.size())
         .forEach(i -> System.out.println("- " + produk.get(i) + ": " + harga.get(i)));
      int total = harga.stream().mapToInt(Integer::intValue).sum();
      System.out.println("Total harga semua produk: " + total);
   }
}
```
)
---

## Hasil Eksekusi
(1. Prosedural  
<img width="1366" height="768" alt="Cuplikan layar 2025-10-02 163428" src="https://github.com/user-attachments/assets/30b8eacb-f31d-4c72-8b44-afdb5c93dda1" />

2. OOP
<img width="1366" height="768" alt="Cuplikan layar 2025-10-02 163707" src="https://github.com/user-attachments/assets/c4dc1038-f018-42d6-8c3e-b1679c3b6fbb" />

3. Fungsional
<img width="1366" height="768" alt="Cuplikan layar 2025-10-02 163859" src="https://github.com/user-attachments/assets/3568497b-d590-4738-9a7e-b4d8f7ff8003" />


)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
