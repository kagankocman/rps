package org.rps;

import org.rps.base.Nesne;
import org.rps.base.Oyuncu;
import org.rps.gui.Home;
import org.rps.player.Bilgisayar;
import org.rps.player.Kullanici;

import javax.swing.*;
import java.util.Scanner;

public class Oyun {

    public static void main(String[] args) {

        Kural kural = new Kural();

        boolean hamlelerBittiMi = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Hamle sayısı gir : ");
        int hamleSayisi = sc.nextInt();

        sc = new Scanner(System.in);
        System.out.println("Kullanıcı - Bilgisayar için 1'e, Bilgisayar - Bilgisayar için 2'ye basın:");

        int secim = sc.nextInt();

        Oyuncu oyuncu1 = secim == 1 ? new Kullanici(1, "Kullanıcı") : new Bilgisayar(2, "Bilgisayar");
        Oyuncu oyuncu2 = new Bilgisayar(3, "Bilgisayar");

        oyuncu1.nesneListesi();
        oyuncu2.nesneListesi();

        for (int i = 0; i < hamleSayisi; i++) {

            System.out.println("###### " + (i+1) + ". hamle ######");

            Nesne oyuncu1Nesne = oyuncu1.nesneSec();
            Nesne oyuncu2Nesne = oyuncu2.nesneSec();

            kural.hamleSonrasiIslemler(oyuncu1, oyuncu2, oyuncu1Nesne, oyuncu2Nesne);

            if (kural.oyunBittiMi(oyuncu1, oyuncu2)) {

                hamlelerBittiMi = false;
                break;
            }
        }

        if (hamlelerBittiMi) {

            kural.oyunSonuDayaniklilikPuaninaGoreKazanan(oyuncu1, oyuncu2);
        }
    }
}