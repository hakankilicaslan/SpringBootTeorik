package com.hakan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository //@Component yerine @Repository yazarsakta çalışır çünkü içinde @Component barındırıyor
@Qualifier("kareQualifier")
public class Kare implements ISekil {

    public Kare() {
        System.out.println("Kare nesnesi yaratıldı.");
    }

    public void alanHesapla(){
        System.out.println("Kare alanı hesaplandı");
    }

    public void cevreHesapla(){
        System.out.println("Kare çevre hesaplandı");
    }

    public void kosegenHesapla(){
        System.out.println("Kare kosegen hesaplandı");
    }

}
