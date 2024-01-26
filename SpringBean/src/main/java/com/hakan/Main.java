package com.hakan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
@ComponentScan
public class Main {
    static Ucgen ucgen;
    static Hesaplayici hesaplayici;

    public Main(Ucgen ucgen, Hesaplayici hesaplayici) {
        Main.ucgen = ucgen;
        Main.hesaplayici = hesaplayici;
    }

    public static void main(String[] args) {

        var context= new AnnotationConfigApplicationContext(Main.class);
        /*context.getBean(ISekil.class).alanHesapla();
        System.out.println("---------------------");
        context.getBean(Hesaplayici.class).hesapla();

        System.out.println("--------------------------------");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);*/

        System.out.println(ucgen);
        ucgen.alanHesapla();
        System.out.println(context.getBean(Ucgen.class));
        System.out.println(context.getBean(Ucgen.class));
        System.out.println(context.getBean(Ucgen.class));

        System.out.println(context.getBean(Kare.class));
        System.out.println(context.getBean(Kare.class));
        System.out.println(context.getBean(Kare.class));
        System.out.println(context.getBean(Kare.class));
    }
}
