package com.hakan;

import java.io.Serializable;

public class EjbOrnek implements Serializable { //3. Serializable'dan implemente edilmesi gerekli.
    //1. boş constructor

    public EjbOrnek() {
    }

    String ad;
    int yas;

    //2. getter & setter

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}
