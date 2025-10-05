# Laporan Praktikum Minggu 1 
Topik: Praktikum OOP

## Identitas
- Nama  : Ditha Elita Putri
- NIM   : 240202832
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu mendefinisikan paradigma prosedural, OOP, dan fungsional.
- Mahasiswa mampu membandingkan kelebihan dan keterbatasan tiap paradigma.
- Mahasiswa mampu memberikan contoh program sederhana untuk masing-masing paradigma.
- Mahasiswa aktif dalam diskusi kelas (bertanya, menjawab, memberi opini).

---

## Dasar Teori
Paradigma pemrograman adalah cara pandang dalam menyusun program:

- Prosedural: prosedural menyusun program sebagai rangkaian langkah atau fungsi yang dieksekusi secara berurutan
- OOP (Object-Oriented Programming): paradigma OOP menggunakan konsep objek yang punya atribut dan method, sehingga lebih terstruktur, mudah dikembangkan, dan bisa digunakan ulang.
- Fungsional: memandang program sebagai pemetaan fungsi matematika yang berfokus pada ekspresi dan transformasi data, biasanya menggunakan stream atau lambda di Java

---

## Langkah Praktikum

1. Langkah-langkah yang dilakukan (setup, coding, run).  
2. File/kode yang dibuat.  
3. Commit dan Push

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

Prosedural
```
// HelloProcedural.java
public class HelloProcedural {
   public static void main(String[] args) {
      String nim = "240202832";
      String nama = "Ditha Elita Putri";
      System.out.println("Hello World, I am "+ nama + ", "+ nim);
   }
}

```

OOP

```

// HelloOOP.java
class Mahasiswa {
   String nama;
   int nim;
   Mahasiswa(String m, int n) {
      this.nama = m;
      this.nim = n;
   }
   void sapa(){System.out.println("Hallo World, I am " + nama + ", "+ nim);}
}

public class HelloOOP {
   public static void main(String[] args) {
      Mahasiswa m = new Mahasiswa ( "Ditha Elita Putri", 240202832);
      m.sapa();
   }}

```

Functional

```

// HelloFunctional.java
import java.util.function.BiConsumer;
public class HelloFunctional {

public static void main(String[] args) {
    BiConsumer<String, Integer> sapa= (nama, nim)-> System.out.println("Hallo World, I am "+ nama+", "+ nim);
    sapa.accept("Ditha Elita Putri", 240202832);
    }
}

```

## Hasil Eksekusi

![Screenshot Prosedural](<img width="799" height="503" alt="HelloProcedural_ditha" src="https://github.com/user-attachments/assets/2ac8c929-e8d3-4213-9718-9f5baadb2bc2" />
)
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
1. Apakah OOP selalu lebih baik dari prosedural?
   **Jawaban:**
   - Tidak selalu. OOP bagus kalau programnya besar dan kompleks karena ada konsep objek yang rapi. Tapi kalau program kecil dan sederhana, prosedural bisa lebih cepat dibuat dan lebih mudah.

2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?
   **Jawaban:**
   - Functional programming cocok dipakai kalau butuh proses yang banyak ngolah data, misalnya perhitungan matematis, analisis data, atau aplikasi yang butuh kecepatan tinggi. Paradigma ini fokus pada fungsi murni dan minim efek samping, jadi hasilnya lebih konsisten.

3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?
   **Jawaban:**

   - * Prosedural: gampang ditulis, tapi susah dirawat kalau program makin besar.
   * OOP: lebih teratur, gampang dikembangkan, dan mudah diperluas.
   * Fungsional: kode singkat, minim efek samping, gampang diuji, dan mudah diparalelkan.

4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
   **Jawaban:**
   -  Karena aplikasi POS (kasir) biasanya punya banyak fitur seperti data barang, pelanggan, transaksi, laporan, dll. OOP cocok karena setiap fitur bisa jadi objek sendiri, jadi lebih rapi, mudah dikembangkan, dan tidak membingungkan.

5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (*boilerplate code*)?
   **Jawaban:**
   - Dalam fungsional, fungsi bisa dipakai berulang-ulang tanpa perlu nulis ulang kodenya. Karena fungsi dianggap sebagai "blok bangunan utama", kita bisa kombinasikan fungsi-fungsi kecil untuk bikin proses yang lebih kompleks, jadi lebih hemat kode.

---
