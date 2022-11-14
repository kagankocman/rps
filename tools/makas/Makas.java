package org.rps.tools.makas;

import org.rps.base.Nesne;

public class Makas extends Nesne {

    protected int katilik;
    protected int nufuz;
    protected int keskinlik;

    public Makas(){
        super();
        this.setKeskinlik(2);
        this.setKatilik(0);
        this.setNufuz(0);
        this.setName("Makas");
    }

    public Makas(double dayaniklilik, double seviyePuani) {

        super(dayaniklilik, seviyePuani);
        this.setKeskinlik(2);
        this.setKatilik(0);
        this.setNufuz(0);
        this.setName("Makas");
    }

    @Override
    public void nesnePuaniGoster() {

        System.out.println(getSeviyePuani());
    }

    @Override
    public double etkiHesapla(Nesne nesne) {

        double payda = (a * nesne.getNufuz() + (1 - a) * nesne.getKatilik());

        if (payda == 0) return 3;
        else return keskinlik / payda;
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
