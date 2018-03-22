/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

import java.util.*;

/*******************************************************************************
 * Instance třídy Batoh představují ...
 *
 * @author    Iuliia Loseeva
 * @version   21.12.2017
 */
public class Batoh
{
    private int kapacita = 10;
    private Collection<Vec> seznamVeciVBatohu;
    //private Map<String,Vec> seznamVeciVbatohu
    
    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor, vytvaří batoh a nový hashSet se seznamom věci v batohu
     */
    public Batoh()
    {
        seznamVeciVBatohu = new HashSet<>();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     *  Metoda přidavá věc do batohu, kontroluje zůstatek volných míst.
     *  
     *@param vec
     *@return true = vec je přídana do batohu, false = vec nepřidáná do batohu
     */
    public boolean pridejVec (Vec vec) {
        if (this.volnychMist() > 0) {
            return seznamVeciVBatohu.add(vec);
        }
        return false;
    }
    
    /**
     *  Metoda odebírá věc z batohu.
     *  
     *@param nazev veci
     *@return vec = vec je odebraná batohu, null = vec neodebráná z batohu
     */
    public Vec odeberVec (String nazev) {
        Vec hledana = null;
        for (Vec vec : seznamVeciVBatohu) {
            if (vec.getNazev().equals(nazev)) {
                hledana = vec;
                seznamVeciVBatohu.remove(vec);
                break;
            }
        }
        return hledana;
    }
    
    /**
     *  Metoda vrací seznam věci v batohu.
     *  
     *@return seznam věcí
     */
    public Collection<Vec> veciVBatohu() {
        return seznamVeciVBatohu;
    }
    
    /**
     *  Metoda počitá kolik volných míst zbyvá v batohu.
     *  
     *@return počet volných mist
     */
    public int volnychMist() {
        int vm = kapacita;
        for (Vec vec : seznamVeciVBatohu) {
            vm--;
        }
        return vm;
    }

    /**
     *  Metoda vrací ve formatu textu seznam věcí v batohu
     *  
     *@return seznam věcí ve formě textu
     */
    public String vBatohu () {
        String veci = "V batohu: ";
        for (Vec vec : seznamVeciVBatohu) {
            veci += vec.getNazev() + ", ";
        }
        return veci;
    }
    
    /**
     *  Metoda hledá věc v batohu
     *  
     *@param nazev věci
     *@return true = vec je nalezená v batohu, false = vec nenalezená
     */
    public boolean najdiVBatohu (String nazev) {
        boolean hledana = false;
        for (Vec vec : seznamVeciVBatohu) {
            if (vec.getNazev().equals(nazev)) {
                hledana = true;
                break;
            }
        }
        return hledana;
    }
    
}
