package org.rps.tools.kagit;

import org.rps.base.Nesne;
import org.rps.tools.makas.Makas;
import org.rps.tools.tas.Tas;

import java.util.ArrayList;

public class Kagit extends Nesne {

    protected int katilik;
    protected int nufuz;
    protected int keskinlik;

    public Kagit(){
        super();
        this.setNufuz(2);
        this.setKeskinlik(0);
        this.setKatilik(0);
        this.setName("Kağıt");
    }

    public Kagit(double dayaniklilik, double seviyePuani) {

        super(dayaniklilik, seviyePuani);
        this.setNufuz(2);
        this.setKeskinlik(0);
        this.setKatilik(0);
        this.setName("Kağıt");
    }

    @Override
    public void nesnePuaniGoster() {

        System.out.println(getSeviyePuani());
    }

    @Override
    public double etkiHesapla(Nesne nesne) {

        double payda = (a * nesne.getKatilik() + (1 - a) * nesne.getKeskinlik());

        if (payda == 0) return 3;
        else return nufuz / payda;
    }

    @Override
    public void durumGuncelle(double rakip, double kendi) {

        setDayaniklilik(getDayaniklilik() - rakip);
        setSeviyePuani(kendi + getSeviyePuani());
    }

    @Override
    public int getKatilik() {
        return katilik;
    }
    @Override
    public void setKatilik(int katilik) {
        this.katilik = katilik;
    }
    @Override
    public int getNufuz() {
        return nufuz;
    }
    @Override
    public void setNufuz(int nufuz) {
        this.nufuz = nufuz;
    }
    @Override
    public int getKeskinlik() {
        return keskinlik;
    }
    @Override
    public void setKeskinlik(int keskinlik) {
        this.keskinlik = keskinlik;
    }

    @Override
    public int getSicaklik() {
        return 0;
    }

    @Override
    public void setSicaklik(int sicaklik) {

    }

    @Override
    public int getDirenc() {
        return 0;
    }

    @Override
    public void setDirenc(int direnc) {

    }

    @Override
    public int getKalinlik() {
        return 0;
    }

    @Override
    public void setKalinlik(int kalinlik) {

    }
}
