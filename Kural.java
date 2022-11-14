package org.rps;

import org.rps.base.Nesne;
import org.rps.base.Oyuncu;
import org.rps.tools.kagit.OzelKagit;
import org.rps.tools.makas.UstaMakas;
import org.rps.tools.tas.AgirTas;

import java.util.List;

public class Kural {


    public void hamleSonrasiIslemler(Oyuncu oyuncu1, Oyuncu oyuncu2, Nesne oyuncu1Nesne, Nesne oyuncu2Nesne) {

        double etki1 = oyuncu1Nesne.etkiHesapla(oyuncu2Nesne);
        double etki2 = oyuncu2Nesne.etkiHesapla(oyuncu1Nesne);
        oyuncu1Nesne.durumGuncelle(etki2, etki1);
        oyuncu2Nesne.durumGuncelle(etki1, etki2);

        if (oyuncu1Nesne.getDayaniklilik() <= 0) {

            oyuncu1Nesne.setAlive(false);
            oyuncu2Nesne.setDayaniklilik(20 + oyuncu2Nesne.getDayaniklilik());
        }
        if (oyuncu2Nesne.getDayaniklilik() <= 0) {

            oyuncu2Nesne.setAlive(false);
            oyuncu1Nesne.setDayaniklilik(20 + oyuncu1Nesne.getDayaniklilik());
        }

        hamleSonrasiBilgileriYazdir(oyuncu1, oyuncu1Nesne, etki1);

        System.out.println("-----------------");

        hamleSonrasiBilgileriYazdir(oyuncu2, oyuncu2Nesne, etki2);

        System.out.println("=================");

        nesneKontroluVeTerfisi(oyuncu1, oyuncu1Nesne);
        nesneKontroluVeTerfisi(oyuncu2, oyuncu2Nesne);
    }

    public void hamleSonrasiBilgileriYazdir(Oyuncu oyuncu, Nesne nesne, double etki) {

        String oyuncuAdi = oyuncu.getOyuncuAdi() + "[" + oyuncu.getOyuncuID() + "]";

        System.out.println(oyuncuAdi + " hamle : " + nesne.getName());
        System.out.println(oyuncuAdi + " hamle etkisi : " + etki);
        System.out.print(oyuncuAdi + " nesne puani : ");
        nesne.nesnePuaniGoster();
        System.out.println(oyuncuAdi + " nesne dayanıklılık puanı : " + nesne.getDayaniklilik());
    }

    public boolean oyunBittiMi(Oyuncu oyuncu1, Oyuncu oyuncu2) {

        var gameOver = false;

        List<Nesne> aliveNesneler1 = oyuncu1.getNesneListesi().stream()
                .filter(Nesne::isAlive)
                .toList();

        List<Nesne> aliveNesneler2 = oyuncu2.getNesneListesi().stream()
                .filter(Nesne::isAlive)
                .toList();

        if (aliveNesneler1.size() == 0) {

            System.out.println(oyuncu1.getOyuncuAdi() +  "[" + oyuncu1.getOyuncuID() + "]'ın nesneleri bitti."
                    + oyuncu2.getOyuncuAdi() +  "[" + oyuncu2.getOyuncuID() + "] kazandı.");
            gameOver = true;
        }

        if (aliveNesneler2.size() == 0) {

            System.out.println(oyuncu2.getOyuncuAdi() +  "[" + oyuncu2.getOyuncuID() + "]'ın nesneleri bitti."
                    + oyuncu1.getOyuncuAdi() +  "[" + oyuncu1.getOyuncuID() + "] kazandı.");
            gameOver = true;
        }

        return gameOver;
    }

    public void nesneTerfiEttir(Oyuncu oyuncu, Nesne nesne) {

        int index = -1;
        for (int i = 0; i < oyuncu.getNesneListesi().size(); i++) {

            if (oyuncu.getNesneListesi().get(i) == nesne) index = i;
        }

        System.out.println("index : " + index);

        double dayaniklilik = nesne.getDayaniklilik();
        double seviyePuani = nesne.getSeviyePuani();

        Nesne terfiNesne = switch (nesne.getName()) {
            case "Taş" -> new AgirTas(dayaniklilik, seviyePuani);
            case "Makas" -> new UstaMakas(dayaniklilik, seviyePuani);
            case "Kağıt" -> new OzelKagit(dayaniklilik, seviyePuani);
            default -> null;
        };

        oyuncu.getNesneListesi().forEach(nes -> System.out.println(nes.getName()));

        if (terfiNesne != null) oyuncu.getNesneListesi().set(index, terfiNesne);

        oyuncu.getNesneListesi().forEach(nes -> System.out.println(nes.getName()));
    }

    public void nesneKontroluVeTerfisi(Oyuncu oyuncu, Nesne nesne) {

        switch (nesne.getName()) {
            case "Ağır Taş":
            case "Usta Makas":
            case "Özel Kağıt":
                break;
            default:
                if (nesne.getSeviyePuani() >= 30) nesneTerfiEttir(oyuncu, nesne);
        }
    }

    public void oyunSonuDayaniklilikPuaninaGoreKazanan(Oyuncu oyuncu1, Oyuncu oyuncu2) {

        double skor1 = oyuncu1.skorGoster();
        double skor2 = oyuncu2.skorGoster();

        String name;
        if (skor1 > skor2) name = oyuncu1.getOyuncuAdi() + "[" + oyuncu1.getOyuncuID() + "]";
        else if (skor1 == skor2) name = "berabere";
        else name = oyuncu2.getOyuncuAdi() + "[" + oyuncu2.getOyuncuID() + "]";

        System.out.println("Kazanan : " + name);
    }
}