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