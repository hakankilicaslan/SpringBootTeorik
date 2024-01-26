package com.hakan;

public class Main {
    public static void main(String[] args) {
        //var sekil=new Kare();
        var sekil=new Ucgen();
        var hesaplayici=new Hesaplayici(sekil);
        hesaplayici.hesapla();
    }
}
