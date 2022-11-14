package org.rps.base;

import org.rps.tools.tas.Tas;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Oyuncu {

    private int oyuncuID;
    private String oyuncuAdi;
    private double skor;

    public Oyuncu() {
        this.oyuncuID = 20;
        this.oyuncuAdi = "";
        this.skor = 0;
    }

    public Oyuncu(int oyuncuID, String oyuncuAdi, double skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
    }

    public abstract void nesneListesi() ;

    public abstract Nesne nesneSec();

    public abstract void setNesneListesi(ArrayList<Nesne> nesneListesi);
    public abstract ArrayList<Nesne> getNesneListesi();

    public abstract void setOyuncuAdi(String oyuncuAdi);
    public abstract String getOyuncuAdi();
    public abstract void setOyuncuID(int oyuncuAdi);
    public abstract int getOyuncuID();

    public double skorGoster() {

        AtomicReference<Double> skor = new AtomicReference<>((double) 0);
        getNesneListesi().stream()
                .filter(Nesne::isAlive)
                .forEach(nesne -> skor.updateAndGet(v -> v + nesne.getDayaniklilik()));

        System.out.println(getOyuncuAdi() + "[" + getOyuncuID() + "]" + " puanı : " + skor);

        return skor.get();
    }
}
