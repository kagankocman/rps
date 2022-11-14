package org.rps.tools.kagit;

import org.rps.base.Nesne;
import org.rps.tools.makas.UstaMakas;
import org.rps.tools.tas.AgirTas;

public class OzelKagit extends Kagit {

    private int kalinlik;
    private int direnc;
    private int sicaklik;

    public OzelKagit(){
        super();
        this.setKalinlik(2);
        this.setNufuz(2);
        this.setKatilik(0);
        this.setKeskinlik(0);
        this.setDirenc(0);
        this.setSicaklik(0);

        this.setName("Özel Kağıt");
    }

    public OzelKagit(double dayaniklilik, double seviyePuani) {

        super(dayaniklilik, seviyePuani);
        this.setKalinlik(2);
        this.setNufuz(2);
        this.setKatilik(0);
        this.setKeskinlik(0);
        this.setDirenc(0);
        this.setSicaklik(0);

        this.setName("Özel Kağıt");
    }

    @Override
    public void nesnePuaniGoster() {

        System.out.println(getSeviyePuani());
    }

    @Override
    public double etkiHesapla(Nesne nesne) {

        int sicaklik = new AgirTas().getSicaklik();
        int direnc = new UstaMakas().getDirenc();

        double payda = (a * nesne.getKatilik() * sicaklik + (1 - a) * nesne.getKeskinlik() * direnc);

        if (payda == 0) return 3;
        else return nufuz * kalinlik / payda;
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
