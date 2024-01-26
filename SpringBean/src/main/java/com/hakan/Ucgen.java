package com.hakan;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Java Singleton           1 tane nesne oluşması demek.    JVM
 * Spring Singleton         1 tane nesne oluşması demek.    Her bir Spring Context için.
 */

@Service //@Component yerine @Service yazarsakta çalışır çünkü içinde @Component barındırıyor
@Primary
//@Lazy Lazy anotasyonu koyduğumuzda çalıştırınca gelmiyor sadece gerekli duyduğunda yani bir yerde kullandığımızda sistem constructorını çalıştırıyor.
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //Seçmezsek SINGLETON geliyor default olarak ama SCOPE_PROTOTYPE seçersek her çağrıldığında yeni nesne yaratıyor.
public class Ucgen implements ISekil{
    public Ucgen() {
        System.out.println("Üçgen nesnesi yaratıldı.");
    }

    public void alanHesapla(){
        System.out.println("Ucgen alanı hesaplandı");
    }

    public void cevreHesapla(){
        System.out.println("Ucgen çevre hesaplandı");
    }

    public void kosegenHesapla(){
        System.out.println("Ucgen kosegen olmaz ki...");
    }

}
