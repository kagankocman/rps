package org.rps.tools.tas;

import org.rps.base.Nesne;
import org.rps.tools.kagit.Kagit;
import org.rps.tools.kagit.OzelKagit;
import org.rps.tools.makas.Makas;
import org.rps.tools.makas.UstaMakas;

import java.util.ArrayList;

public class AgirTas extends Tas {

    private int sicaklik;
    private int direnc;
    private int kalinlik;

    public AgirTas(){
        super();
        this.setSicaklik(2);
        this.setKatilik(2);
        this.setDirenc(0);
        this.setKalinlik(0);
        this.setNufuz(0);
        this.setKeskinlik(0);
        this.setName("Ağır Taş");
    }

    public AgirTas(double dayaniklilik, double seviyePuani) {

        super(dayaniklilik, seviyePuani);
        this.setSicaklik(2);
        this.setKatilik(2);
        this.setDirenc(0);
        this.setKalinlik(0);
        this.setNufuz(0);
        this.setKeskinlik(0);
        this.setName("Ağır Taş");
    }

    @Override
    public void nesnePuaniGoster() {

        System.out.println(getSeviyePuani());
    }

    @Override
    public double etkiHesapla(Nesne nesne) {

        double payda = (a * nesne.getKeskinlik() * nesne.getDirenc() + (1 - a) * nesne.getNufuz() * nesne.getKalinlik());

        if (payda == 0) return 3;
        else return this.getKatilik() * this.getSicaklik() / payda;
    }

    @Override
    public void durumGuncelle(double rakip, double kendi) {

        setDayaniklilik(getDayaniklilik() - rakip);
        setSeviyePuani(kendi + getSeviyePuani());
    }

    @Override
    public int getSicaklik() { return this.sicaklik;}

    @Override
    public void setSicaklik(int sicaklik) { this.sicaklik = sicaklik;}

    @Override
    public int getDirenc() { return this.direnc;}

    @Override
    public void setDirenc(int direnc) { this.direnc = direnc;}

    @Override
    public int getKalinlik() { return this.kalinlik;}

    @Override
    public void setKalinlik(int kalinlik) { this.kalinlik = kalinlik;}
}
