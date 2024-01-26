package com.hakan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Bu class Spring ayar dosyası olacak.
record Kisi (String ad,int yas) {}
record Adres(String il,String ilce){}
record AdresliKisi(String ad,int yas,Adres adres){}


@Configuration
public class SpringConfiguration {

    //@Bean anotasyonu ile Spring Context tarafından yönetilecek bir bean oluşturulur.
    @Bean
    public String ad() {
        return "Mr. Bean";
    }

    @Bean
    public int yas(){
        return 50;
    }

    @Bean
    public Kisi kisi(){
        return new Kisi("Serkan",30);
    }

    @Bean(name = "adresEv")
    public Adres adres(){
        return new Adres("İstanbul","Sisli");
    }

    @Bean
    @Primary
    public Adres adres2(){
        return new Adres("Ankara","Gölbaşı");
    }

    @Bean
    @Qualifier("adres3Qualifier")
    public Adres adres3(){
        return new Adres("İzmir","Foça");
    }


    @Bean
    public Kisi kisiMetodCall(){
        return new Kisi(ad(),yas());
    }

    @Bean
    public AdresliKisi adresliKisi(){
        return new AdresliKisi("Cüneyt",45,new Adres("Mardin","Midyat"));
    }

    @Bean
    @Primary
    public AdresliKisi adresliKisi2(){
        return new AdresliKisi("Canan",40,adres());
    }

    @Bean
    public AdresliKisi adresliKisi3(String ad,int yas,@Qualifier("adres3Qualifier") Adres adres){
        return new AdresliKisi(ad,yas,adres);
    }
}
