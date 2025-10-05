# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: Pengenalan Paradigma dan Setup Proyek

## Identitas
- Nama  : Hanifah
- NIM   : 240202864
- Kelas : 3 IKRA

---
 
## Tujuan
(Tuliskan tujuan praktikum minggu ini.   
    1. Mahasiswa mampu mendefinisikan paradigma prosedural, OOP, dan fungsional.
    2. Mahasiswa mampu membandingkan kelebihan dan keterbatasan tiap paradigma.
    3. Mahasiswa mampu memberikan contoh program sederhana untuk masing-masing paradigma.
    4. Mahasiswa aktif dalam diskusi kelas (bertanya, menjawab, memberi opini).


---

## Dasar Teori
(Tuliskan ringkasan teori singkat (3–5 poin) yang mendasari praktikum.  
Paradigma pemrograman adalah pendekatan atau gaya dalam menulis dan mengorganisasi kode program.
Setup proyek adalah langkah awal dalam membangun lingkungan kerja yang siap untuk pengembangan perangkat lunak.

---

## Langkah Praktikum
1. Persiapkan Lingkungan :Pastikan JDK sudah terpasang.Jika belum terpasang, download dan install JDK dari https://www.oracle.com/java/technologies/javase-downloads.html
2. Buat File Program : Buka teks editor, ketik kode dan simpan dengan nama HelloProcedural.java
3. Kompilasi Program : Buka terminal dan arahkan ke direktori tempat file disimpan, lalu jalankan kode javac HelloProcedural.java
maka akan terbentuk file HelloProcedural.class.
4. Jalankan Program : Jika berhasil akan muncul otput sesuai program 

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
 HelloProcedural.java
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
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
<img width="1366" height="768" alt="Cuplikan layar 2025-10-02 163428" src="https://github.com/user-attachments/assets/30b8eacb-f31d-4c72-8b44-afdb5c93dda1" />

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
