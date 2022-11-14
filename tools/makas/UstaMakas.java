package org.rps.tools.makas;

import org.rps.base.Nesne;
import org.rps.tools.kagit.Kagit;
import org.rps.tools.kagit.OzelKagit;
import org.rps.tools.tas.AgirTas;
import org.rps.tools.tas.Tas;

import java.util.ArrayList;

public class UstaMakas extends Makas {

    private int direnc;
    private int sicaklik;
    private int kalinlik;

    public UstaMakas(){
        super();
        this.setKeskinlik(2);
        this.setDirenc(2);
        this.setSicaklik(0);
        this.setKatilik(0);
        this.setKalinlik(0);
        this.setNufuz(0);
        this.setName("Usta Makas");
    }

    public UstaMakas(double dayaniklilik, double seviyePuani) {

        super(dayaniklilik, seviyePuani);
        this.setKeskinlik(2);
        this.setDirenc(2);
        this.setSicaklik(0);
        this.setKatilik(0);
        this.setKalinlik(0);
        this.setNufuz(0);
        this.setName("Usta Makas");
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
