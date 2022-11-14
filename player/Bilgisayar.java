package org.rps.player;

import org.rps.base.Nesne;
import org.rps.tools.kagit.Kagit;
import org.rps.tools.makas.Makas;
import org.rps.tools.tas.Tas;
import org.rps.base.Oyuncu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Bilgisayar extends Oyuncu {

    private int oyuncuID;
    private String oyuncuAdi;
    private double skor;
    private ArrayList<Nesne> nesneListesi = new ArrayList<>();

    public Bilgisayar(){
        super();
    }

    public Bilgisayar(int oyuncuID, String oyuncuAdi){
        super();
        this.setOyuncuID(oyuncuID);
        this.setOyuncuAdi(oyuncuAdi);
    }

    public Bilgisayar(int oyuncuID, String oyuncuAdi, double skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

    @Override
    public void nesneListesi() {

        for (int i = 0; i < 5; i++) {

            int randomNumber = (int) (Math.random() * 3 + 1);
            Nesne nesne = null;

            switch (randomNumber) {
                case 1 -> nesne = new Tas();
                case 2 -> nesne = new Kagit();
                case 3 -> nesne = new Makas();
            }

            this.nesneListesi.add(nesne);
        }
    }

    @Override
    public Nesne nesneSec() {

        long flagTrueAliveNesnelerCount = this.getNesneListesi().stream()
                .filter(nesne -> nesne.isFlag() && nesne.isAlive())
                .count();

        if (flagTrueAliveNesnelerCount == 0) this.getNesneListesi().forEach(nesne -> nesne.setFlag(true));

        List<Nesne> secilebilirNesneler = this.getNesneListesi().stream()
                .filter(Nesne::isFlag)
                .filter(Nesne::isAlive)
                .toList();

        int random = (int) (Math.random() * secilebilirNesneler.size());

        Nesne randomSecim = secilebilirNesneler.get(random);
        randomSecim.setFlag(false);

        return randomSecim;
    }

    @Override
    public void setNesneListesi(ArrayList<Nesne> nesneListesi) {
        this.nesneListesi = nesneListesi;
    }
    @Override
    public ArrayList<Nesne> getNesneListesi() {return this.nesneListesi;}

    @Override
    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }
    @Override
    public String getOyuncuAdi() {return this.oyuncuAdi;}
    @Override
    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }
    @Override
    public int getOyuncuID() {return this.oyuncuID;}
}
