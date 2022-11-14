package org.rps.player;

import org.rps.base.Nesne;
import org.rps.tools.kagit.Kagit;
import org.rps.tools.makas.Makas;
import org.rps.tools.tas.Tas;
import org.rps.base.Oyuncu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Kullanici extends Oyuncu {

    private int oyuncuID;
    private String oyuncuAdi;
    private double skor;
    ArrayList<Nesne> nesneListesi = new ArrayList<>();

    public Kullanici(){
        super();
    }

    public Kullanici(int oyuncuID, String oyuncuAdi){
        super();
        this.setOyuncuID(oyuncuID);
        this.setOyuncuAdi(oyuncuAdi);
    }

    public Kullanici(int oyuncuID, String oyuncuAdi, double skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

    @Override
    public void nesneListesi() {

        for (int i = 0; i < 5; i++) {

            Scanner sc = new Scanner(System.in);
            System.out.println(i + 1 + ". nesne için Taş(1), Kağıt(2), Makas(3) seçin:");

            int secim = sc.nextInt();
            Nesne nesne = null;

            switch (secim) {
                case 1 -> nesne = new Tas();
                case 2 -> nesne = new Kagit();
                case 3 -> nesne = new Makas();
            }

            nesneListesi.add(nesne);
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Hamle yap. Elindeki nesneler : ");

        for (int i = 0; i < secilebilirNesneler.size(); i++) {

            System.out.println(secilebilirNesneler.get(i).getName() + " için (" + (i + 1) + ")");
        }

        int secim = sc.nextInt();
        Nesne secilenNesne = secilebilirNesneler.get(secim - 1);

        secilenNesne.setFlag(false);

        return secilenNesne;
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
