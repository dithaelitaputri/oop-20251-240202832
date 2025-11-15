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

###CreditBy.java
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


---


## Hasil Eksekusi

<img width="1920" height="1080" alt="hasil week5-mainabstraction" src="https://github.com/user-attachments/assets/12315950-0969-4e85-90c8-6672df22178b" />


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
