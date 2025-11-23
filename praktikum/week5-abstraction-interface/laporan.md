# Laporan Praktikum Minggu 5 
Topik: "Main Abstraction"

## Identitas
- Nama  : Ditha Elita Putri
- NIM   : 240202832
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu **menjelaskan perbedaan abstract class dan interface**.
- Mahasiswa mampu **mendesain abstract class dengan method abstrak** sesuai kebutuhan kasus.
- Mahasiswa mampu **membuat interface dan mengimplementasikannya pada class**.
- Mahasiswa mampu **menerapkan multiple inheritance melalui interface** pada rancangan kelas.
- Mahasiswa mampu **mendokumentasikan kode** (komentar kelas/method, README singkat pada folder minggu).


---

## Dasar Teori
**Abstraksi** adalah proses menyederhanakan kompleksitas dengan menampilkan elemen penting dan menyembunyikan detail implementasi.
- **Abstract class**: tidak dapat diinstansiasi, dapat memiliki method abstrak (tanpa badan) dan non-abstrak. Dapat menyimpan state (field).
- **Interface**: kumpulan kontrak (method tanpa implementasi konkret). Sejak Java 8 mendukung default method. Mendukung **multiple inheritance** (class dapat mengimplementasikan banyak interface).
- Gunakan **abstract class** bila ada _shared state_ dan perilaku dasar; gunakan **interface** untuk mendefinisikan kemampuan/kontrak lintas hierarki.

Dalam konteks Agri-POS, **Pembayaran** dapat dimodelkan sebagai abstract class dengan method abstrak `prosesPembayaran()` dan `biaya()`. Implementasi konkritnya: `Cash` dan `EWallet`. Kemudian, interface seperti `Validatable` (mis. verifikasi OTP) dan `Receiptable` (mencetak bukti) dapat diimplementasikan oleh jenis pembayaran yang relevan.


---

## Langkah Praktikum
1. **Abstract Class – Pembayaran**
   - Buat `Pembayaran` (abstract) dengan field `invoiceNo`, `total` dan method:
     - `double biaya()` (abstrak) → biaya tambahan (fee).
     - `boolean prosesPembayaran()` (abstrak) → mengembalikan status berhasil/gagal.
     - `double totalBayar()` (konkrit) → `return total + biaya();`.

2. **Subclass Konkret**
   - `Cash` → biaya = 0, proses = selalu berhasil jika `tunai >= totalBayar()`.
   - `EWallet` → biaya = 1.5% dari `total`; proses = membutuhkan validasi.

3. **Interface**
   - `Validatable` → `boolean validasi();` (contoh: OTP).
   - `Receiptable` → `String cetakStruk();`

4. **Multiple Inheritance via Interface**
   - `EWallet` mengimplementasikan **dua interface**: `Validatable`, `Receiptable`.
   - `Cash` setidaknya mengimplementasikan `Receiptable`.

5. **Main Class**
    - Buat `MainAbstraction.java` untuk mendemonstrasikan pemakaian `Pembayaran` (polimorfik).
    - Tampilkan hasil proses dan struk. Di akhir, panggil `CreditBy.print("[NIM]", "[Nama]")`.

6. **Commit dan Push**
   - Commit dengan pesan: `week5-abstraction-interface`.


---

## Kode Program

### Receiptable.java
```java
package com.upb.agripos.model.kontrak;

public interface Receiptable {
    String cetakStruk();
}

```

### Validatable.java
```java
package com.upb.agripos.model.kontrak;

public interface Validatable {
    boolean validasi(); // misal validasi OTP/PIN
}

```

### Cash.java
```java
package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Receiptable;

public class Cash extends Pembayaran implements Receiptable {
    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() {
        return 0.0;
    }

    @Override
    public boolean prosesPembayaran() {
        // Berhasil jika uang tunai (tunai) mencukupi (>= totalBayar)
        return this.tunai >= this.totalBayar(); // sederhana: cukup uang tunai
    }

    @Override
    public String cetakStruk() {
        String status = prosesPembayaran() ? "BERHASIL" : "GAGAL (Uang Kurang)";
        double kembalian = prosesPembayaran() ? this.tunai - this.totalBayar() : 0.0;
        
        return "\n====== STRUK PEMBAYARAN TUNAI ======\n" +
               "Invoice No.    : " + this.invoiceNo + "\n" +
               "Total Belanja  : Rp " + String.format("%.0f", this.total) + "\n" +
               "Biaya (Fee)    : Rp " + String.format("%.0f", this.biaya()) + "\n" +
              "--------------------------------------\n" +
               "TOTAL BAYAR    : Rp " + String.format("%.0f", this.totalBayar()) + "\n" +
               "Tunai Diberikan: Rp " + String.format("%.0f", this.tunai) + "\n" +
               "Kembalian      : Rp " + String.format("%.0f", kembalian) + "\n" +
               "STATUS         : " + status + "\n" +
               " \n" +
               "--------------------------------------";
    }
    }

 ```
### Ewallet.java

```java
package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Validatable;
import com.upb.agripos.model.kontrak.Receiptable;

public class EWallet extends Pembayaran implements Validatable, Receiptable {
    private final String akun;
    private final String otp; // sederhana untuk simulasi

    public EWallet(String invoiceNo, double total, String akun, String otp) {
        super(invoiceNo, total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() {
        return total * 0.015; // 1.5% fee
    }

    @Override
    public boolean validasi() {
        return otp != null && otp.length() == 6; // contoh validasi sederhana
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi(); // jika validasi lolos, anggap berhasil
    }

    @Override
   public String cetakStruk() {
    // Panggil prosesPembayaran() untuk menentukan status
    String status = prosesPembayaran() ? "BERHASIL" : "GAGAL (Validasi Gagal)";

    return "==== STRUK PEMBAYARAN E-WALLET ====\n" +
           "Invoice No.   : " + this.invoiceNo + "\n" +
           "Akun E-Wallet : " + this.akun + "\n" + // Tambahkan detail akun
           "Total Belanja : Rp " + String.format("%,.2f", this.total) + "\n" +
           "Biaya (1.5%)  : Rp " + String.format("%,.2f", this.biaya()) + "\n" +
           "--------------------------------------\n" +
           "TOTAL BAYAR   : Rp " + String.format("%,.2f", this.totalBayar()) + "\n" +
           "STATUS        : " + status + "\n" +
           "--------------------------------------\n" ;
    }
}

```

### Pembayaran.java
```java
package com.upb.agripos.model.pembayaran;

public abstract class Pembayaran {
    protected String invoiceNo;
    protected double total;

    public Pembayaran(String invoiceNo, double total) {
        this.invoiceNo = invoiceNo;
        this.total = total;
    }

    public abstract double biaya();               // biaya tambahan/admin
    public abstract boolean prosesPembayaran();   // proses spesifik tiap metode

    public double totalBayar() {
        return total + biaya();
    }

    public String getInvoiceNo() { return invoiceNo; }
    public double getTotal() { return total; }
}

```


### TransferBank.java
```java
package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Validatable;
import com.upb.agripos.model.kontrak.Receiptable;

public class TransferBank extends Pembayaran implements Validatable, Receiptable {
    
    // Biaya tetap: Rp3500
    private static final double BIAYA_TETAP = 3500.0;
    private String kodeKonfirmasi; // Field untuk simulasi validasi

    public TransferBank(String invoiceNo, double total, String kodeKonfirmasi) {
        super(invoiceNo, total);
        this.kodeKonfirmasi = kodeKonfirmasi;
    }

    // Metode Abstrak Pembayaran
    @Override
    public double biaya() {
        return BIAYA_TETAP;
    }

    @Override
    public boolean prosesPembayaran() {
        // Pembayaran berhasil jika validasi sukses
        if (this.validasi()) {
          //  System.out.println("[TransferBank] Pembayaran diproses sebesar Rp " + String.format("%,.0f", this.totalBayar()));
            return true;
        }
        return false;
    }

    // Metode Interface Validatable
    @Override
    public boolean validasi() {
        // Contoh validasi: Kode konfirmasi harus 4 digit
        boolean isValid = kodeKonfirmasi != null && kodeKonfirmasi.length() == 4;
        // System.out.println("[TransferBank] Validasi Kode Konfirmasi (4 digit) " + (isValid ? "BERHASIL." : "GAGAL!"));
        return isValid;
    }

    // Metode Interface Receiptable
    @Override
    public String cetakStruk() {
        String status = prosesPembayaran() ? "BERHASIL" : "GAGAL (Konfirmasi Salah)";

        return "\n=== STRUK PEMBAYARAN TRANSFER BANK ===\n" +
               "Invoice No.   : " + this.invoiceNo + "\n" +
               "Total Belanja : Rp " + String.format("%,.0f", this.total) + "\n" +
               "Biaya (Tetap) : Rp " + String.format("%,.0f", this.biaya()) + "\n" +
               "--------------------------------------\n" +
               "TOTAL BAYAR   : Rp " + String.format("%,.0f", this.totalBayar()) + "\n" +
               "STATUS        : " + status + "\n" +
               "--------------------------------------";
    }
}

```

### CreditBy.java
```java
package com.upb.agripos.util;
// creditBy.java

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}
```

### MainAbstraction.java
```java
package com.upb.agripos;

import com.upb.agripos.model.pembayaran.*;
import com.upb.agripos.model.kontrak.*;
import com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("DTH-001", 120000, 150000);
        Pembayaran ew = new EWallet("DTH-002", 150000, "dithael", "123456");
        Pembayaran transfer = new TransferBank("DTH-003", 250000.0, "9876");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());
        System.out.println(((Receiptable) transfer).cetakStruk());

     // Credit info
    CreditBy.print("240202832", "Ditha Elita Putri");
    }
}
```

---

## Hasil Eksekusi

<img width="1920" height="1080" alt="hasil week5-mainabstraction" src="https://github.com/user-attachments/assets/12315950-0969-4e85-90c8-6672df22178b" />


---

## Analisis
- Jelaskan bagaimana kode berjalan.
  
  Program dimulai dari metode main(), lalu membuat objek pembayaran seperti Cash, E-Wallet, atau Transfer Bank.
  Setiap objek punya cara perhitungan total bayar yang berbeda (sesuai jenis pembayarannya).
  Saat program memanggil prosesPembayaran(), Java akan otomatis menjalankan versi metode yang sesuai dengan objeknya.
  Hasil akhirnya ditampilkan ke layar sesuai jenis pembayaran yang digunakan.
  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.
  
  Minggu sebelumnya fokus ke polymorphism, yaitu satu metode dengan banyak perilaku tergantung objeknya.
  Minggu ini lebih menekankan ke abstraksi, di mana kita membuat kelas abstrak sebagai kerangka umum yang harus diikuti oleh   semua jenis pembayaran.
  Jadi, kalau sebelumnya menonjolkan perbedaan perilaku, minggu ini menonjolkan aturan dasarnya.
  
- Kendala yang dihadapi dan cara mengatasinya.

   Waktu mengerjakan praktikum ini, kendala utama saya ada di bagian desain class, terutama ketika menentukan mana yang seharusnya jadi abstract class dan mana yang cocok dibuat sebagai interface

---

## Kesimpulan
Dari praktikum minggu ini, saya belajar kalau abstraksi itu penting untuk membuat struktur program yang rapi dan konsisten. Dengan abstract class, kita bisa bikin kerangka umum yang harus dipakai semua jenis pembayaran. Sedangkan interface membuat kita bisa nambah kemampuan tertentu tanpa mengubah hierarki class. Pendekatan ini bikin program lebih fleksibel, mudah dikembangkan, dan kalau nanti butuh metode pembayaran baru, tinggal bikin subclass atau implementasi interface baru tanpa mengubah kode yang sudah ada.

---

## Quiz
1. Jelaskan perbedaan konsep dan penggunaan abstract class dan interface.

Jawaban: Abstract class digunakan ketika kita punya konsep dasar yang sama untuk semua turunannya, termasuk data/field yang mau dipakai bareng. Sedangkan interface dipakai untuk mendefinisikan kemampuan tambahan yang bisa dipasang ke class mana pun tanpa terikat hierarki. Jadi abstract class lebih ke “kerangka besar”-nya, sementara interface itu seperti “aturan tambahan” yang harus dipenuhi. 

2. Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java?

awaban: Karena interface tidak membawa state dan tidak punya implementasi kompleks yang bisa saling bentrok. Kalau Java mendukung multiple inheritance untuk class, nanti bisa terjadi konflik pewarisan (misalnya dua parent punya atribut atau logic yang sama). Dengan interface, class bisa punya banyak kemampuan tanpa risiko tabrakan antar kode.

3.Pada contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface? Jelaskan alasannya. 

Jawaban: Yang cocok jadi abstract class adalah Pembayaran, karena semua metode pembayaran pasti punya pola dasar yang sama seperti menghitung fee dan memproses pembayaran. Tetapi cara menghitung fee dan prosesnya beda-beda, jadi pas kalau bagian itu dibuat abstrak.
Yang cocok jadi interface adalah Validatable dan Receiptable, karena ini sifatnya kemampuan tambahan. Tidak semua metode pembayaran perlu validasi, dan tidak semua membutuhkan struk yang detail. Jadi interface ini bisa diimplementasikan hanya oleh class yang butuh saja. 
