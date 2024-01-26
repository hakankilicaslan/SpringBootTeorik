package com.hakan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hesaplayici {
    ISekil sekil;
    public Hesaplayici(@Qualifier("kareQualifier") ISekil sekil) {
        this.sekil=sekil;
        System.out.println("Hesaplayici nesnesi yaratıldı.");
    }

    public void hesapla() {
        System.out.println("Sekil hesapla metodu çalışıyor..."+sekil);
        sekil.alanHesapla();
        sekil.cevreHesapla();
        sekil.kosegenHesapla();
    }
}