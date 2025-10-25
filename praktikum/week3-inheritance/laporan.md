# Laporan Praktikum Minggu 3 
Topik: Bab 3 – Inheritance

## Identitas
- Nama  : Ditha Elita Putri
- NIM   : 240202832
- Kelas : 3 IKRA

---

## Tujuan
Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
Mahasiswa mampu membuat superclass dan subclass untuk produk pertanian.
Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.
Mahasiswa mampu menggunakan super untuk memanggil konstruktor dan method parent class.
Mahasiswa mampu membuat laporan praktikum yang menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.

---

## Dasar Teori
Inheritance (pewarisan) adalah konsep dalam pemrograman berorientasi objek (OOP) yang memungkinkan sebuah class mewarisi sifat dan perilaku dari class lain.
  -Superclass adalah class induk yang berisi atribut dan fungsi umum.
  -Subclass adalah class turunan yang mengambil atribut dan fungsi dari superclass, lalu bisa menambahkan hal-hal baru sesuai kebutuhannya.
 -Kata kunci super digunakan untuk memanggil konstruktor atau method milik superclass.
Dalam contoh sistem Agri-POS, kita bisa membuat class Produk sebagai class induk, lalu membuat class Benih, Pupuk, dan AlatPertanian sebagai class turunannya.

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
(Tuliskan kode utama yang dibuat, contoh:  

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
```
)
---

## Hasil Eksekusi
<img width="1920" height="1080" alt="hasil week 3" src="https://github.com/user-attachments/assets/ba14b5db-17bf-4c23-9123-59324489af21" />


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
