package com.hakan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

@Component
class ClassA{
    private ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
        System.out.println("Class A Constructor çalıştı...");
    }

    @PostConstruct //@PostConstruct anotasyonu ile constructor çağırıldıktan sonra constructor injection sonrası bununla işaretlenen metodu da çağırmış oluyoruz. Constructor içinde metodu çağırmakla aynı şey oluyor.
    public void dependencyInjectionOlduktanSonraCalisacakMetod(){
        System.out.println("dependencyInjectionOlduktanSonraCalisacakMetod");
    }

    @PreDestroy //@PreDestroy anotsayonu ile context kapatılmadan önce bu metodu çağır demiş oluyoruz.
    public void contextIcindenSilinmedenOnceCalisanMetod(){
        System.out.println("contextIcindenSilinmedenOnceCalisanMetod");
    }
}

@Component
class ClassB{
    public ClassB() {
        System.out.println("Class B Constructor çalıştı. ");
    }
}



@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        var context= new AnnotationConfigApplicationContext(Main.class);
        System.out.println("--------------------------------");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("--------------------------------");
        context.getBean(ClassA.class);

        context.close();

    }
}