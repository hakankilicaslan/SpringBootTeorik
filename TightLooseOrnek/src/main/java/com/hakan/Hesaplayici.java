package com.hakan;

public class Hesaplayici {
    Ucgen sekil;
    public Hesaplayici(Ucgen sekil) {
        this.sekil=sekil;
    }

    public void hesapla() {
        System.out.println("Şekil hesapla metodu çalışıyor..."+sekil);
        sekil.alanHesapla();
        sekil.cevreHesapla();
        sekil.kosegenHesapla();
    }
}
