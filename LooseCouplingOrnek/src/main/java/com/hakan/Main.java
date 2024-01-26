package com.hakan;

public class Main {
    public static void main(String[] args) {
        //var sekil=new Kare();
        var sekil=new Kare();
        var hesaplayici=new Hesaplayici(sekil); //Wiring of Dependency (bağımlılığın bağlanması)
        // Kim kime bağlı?
        //Hesaplayıcı şekile bağlı.

        // Kim kim için bağımlılıktır?
        // Şekil, hesaplayıcı için bağımlılıktır.

        // Kim kime inject edilecek?
        // Şekil , hesaplayıcıya inject edilecek.

        // DI - Dependecy Injection - Spring

        hesaplayici.hesapla();
    }
}
