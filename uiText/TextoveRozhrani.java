package uiText;


import java.util.Scanner;
import logika.*;
import java.io.*;
/**
 *  Class TextoveRozhrani
 * 
 *  Toto je uživatelského rozhraní aplikace TuringGame
 *  Tato třída vytváří instanci třídy Hra, která představuje logiku aplikace.
 *  Čte vstup zadaný uživatelem a předává tento řetězec logice a vypisuje odpověď logiky na konzoli.
 *  
 *  
 *
 *@author     Iuliia Loseeva
 *@version    20.12.2017
 */

public class TextoveRozhrani {
    private IHra hra;

    /**
     *  Vytváří hru.
     */
    public TextoveRozhrani(IHra hra) {
        this.hra = hra;
    }

    /**
     *  Hlavní metoda hry. Vypíše úvodní text a pak opakuje čtení a zpracování
     *  příkazu od hráče do konce hry (dokud metoda konecHry() z logiky nevrátí
     *  hodnotu true). Nakonec vypíše text epilogu.
     */
    public void hraj() {
        System.out.println(hra.vratUvitani());

        // základní cyklus programu - opakovaně se čtou příkazy a poté
        // se provádějí do konce hry.

        while (!hra.konecHry()) {
            String radek = prectiString();
            System.out.println(hra.zpracujPrikaz(radek));
        }

        System.out.println(hra.vratEpilog());
    }
    /**
     *  Hlavní metoda hry. Vypíše úvodní text a pak přečte příkazy ze souboru. Nakonec vypíše text epilogu.
     */
    public void hraj(File soubor) {
        try (BufferedReader ctecka = new BufferedReader (new FileReader(soubor))){
            System.out.println(hra.vratUvitani());

            // základní cyklus programu - opakovaně se čtou příkazy ze souboru a poté
            // se provádějí do konce hry.

            String radek = ctecka.readLine();
            while (!hra.konecHry() && radek != null) {
                System.out.println("----"+radek+"----");
                System.out.println(hra.zpracujPrikaz(radek));
                radek = ctecka.readLine();
            }
            System.out.println(hra.vratEpilog());
        }
        
        catch(FileNotFoundException e){
            System.out.println("Soubor s prikazy nebyl nalezen.");
        }
        
        catch (IOException e){
            System.out.println("Chyba vstupu");
        }

    }

    /**
     *  Metoda přečte příkaz z příkazového řádku
     *
     *@return    Vrací přečtený příkaz jako instanci třídy String
     */
    private String prectiString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextLine();
    }

}
