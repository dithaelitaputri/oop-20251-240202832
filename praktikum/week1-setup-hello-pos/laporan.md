# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: Tuliskan judul topik, misalnya "Class dan Object"

## Identitas
- Nama  : Ditha Elita Putri
- NIM   : 240202832
- Kelas : 3IKRA

---

## Tujuan
(Tuliskan tujuan praktikum minggu ini.  
Contoh: *Mahasiswa memahami konsep class dan object serta dapat membuat class Produk dengan enkapsulasi.*)

---

## Dasar Teori
(Tuliskan ringkasan teori singkat (3–5 poin) yang mendasari praktikum.  
Contoh:  
1. Class adalah blueprint dari objek.  
2. Object adalah instansiasi dari class.  
3. Enkapsulasi digunakan untuk menyembunyikan data.)

---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam prakrikum, contoh:
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
