package org.rps.base;

public abstract class Nesne {

    protected final double a = 0.2;
    private double dayaniklilik;
    private double seviyePuani;
    private boolean flag;
    private boolean isAlive;
    private String name;

    public Nesne() {
        this.dayaniklilik = 20;
        this.seviyePuani = 0;
        this.setFlag(true);
        this.setAlive(true);
    }

    public Nesne(double dayaniklilik, double seviyePuani) {
        this.dayaniklilik = dayaniklilik;
        this.seviyePuani = seviyePuani;
        this.setFlag(true);
        this.setAlive(true);
    }

    public abstract void nesnePuaniGoster() ;

    public abstract double etkiHesapla(Nesne nesne);

    public abstract void durumGuncelle(double rakip, double kendi);

    public abstract int getKatilik();

    public abstract void setKatilik(int katilik);

    public abstract int getNufuz();

    public abstract void setNufuz(int nufuz);

    public abstract int getKeskinlik();

    public abstract void setKeskinlik(int keskinlik);

    public abstract int getSicaklik();

    public abstract void setSicaklik(int sicaklik);

    public abstract int getDirenc();

    public abstract void setDirenc(int direnc);

    public abstract int getKalinlik();

    public abstract void setKalinlik(int kalinlik);

    public double getDayaniklilik() {
        return dayaniklilik;
    }

    public void setDayaniklilik(double dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    public double getSeviyePuani() {
        return seviyePuani;
    }

    public void setSeviyePuani(double seviyePuani) {
        this.seviyePuani = seviyePuani;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
