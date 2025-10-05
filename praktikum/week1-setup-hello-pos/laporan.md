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

- Prosedural: program dibangun sebagai rangkaian perintah (fungsi/prosedur).
- OOP (Object-Oriented Programming): program dibangun dari objek yang memiliki data (atribut) dan perilaku (method).
- Fungsional: program dipandang sebagai pemetaan fungsi matematika, lebih menekankan ekspresi dan transformasi data.

---

## Langkah Praktikum

1. Langkah-langkah yang dilakukan (setup, coding, run).  
2. File/kode yang dibuat.  
3. Commit message yang digunakan.)

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
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
