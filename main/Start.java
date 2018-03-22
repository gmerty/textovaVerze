/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package main;

import logika.*;
import uiText.TextoveRozhrani;
import java.io.*;

/*******************************************************************************
 * Třída  Start je hlavní třídou projektu,
 * který představuje jednoduchou textovou adventuru určenou k dalším úpravám a rozšiřování
 *
 * @author    Iuliia Loseeva
 * @version   20.12.2017
 */
public final class Start
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        
        IHra hra = new Hra();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        if (args.length == 0){
            ui.hraj();
        }
        else {
            ui.hraj(new File(args[0]));
        }
        
    }
    
    private Start () {
    
    }
}
