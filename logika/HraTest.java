package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author   Iuliia Loseeva
 * @version  20.12.2017
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testProhra() {
        assertEquals("Londyn", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi Serborne");
        assertEquals(false, hra1.konecHry());
        assertEquals("Serborne", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("mluv pan_Direktor");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpoved ano");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpovedZkouska o_45,2_%");
        hra1.zpracujPrikaz("jdi Kembridge");
        assertEquals(false, hra1.konecHry());
        assertEquals("Kembridge", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("mluv pan_Hardy");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpoved ano");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpovedZkouska tautologie");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi Princeton");
        assertEquals(false, hra1.konecHry());
        assertEquals("Princeton", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("mluv pan_Church");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpoved ano");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpovedZkouska Nevim");
        hra1.zpracujPrikaz("odpovedZkouska Nevim");
        hra1.zpracujPrikaz("odpovedZkouska Nevim");
        hra1.zpracujPrikaz("odpovedZkouska Nevim");
        hra1.zpracujPrikaz("odpovedZkouska Nevim");
        hra1.zpracujPrikaz("odpovedZkouska Nevim");
        assertEquals(true, hra1.konecHry());
    }

    @Test
    public void vyhra()
    {
        assertEquals("Londyn", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi Serborne");
        assertEquals(false, hra1.konecHry());
        assertEquals("Serborne", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("mluv pan_Direktor");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpoved ano");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpovedZkouska o_45,2_%");
        hra1.zpracujPrikaz("jdi Kembridge");
        assertEquals(false, hra1.konecHry());
        assertEquals("Kembridge", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("mluv pan_Hardy");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpoved ano");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpovedZkouska tautologie");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi Princeton");
        assertEquals(false, hra1.konecHry());
        assertEquals("Princeton", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("mluv pan_Church");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpoved ano");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpovedZkouska Alane,_jsi_jednicka!");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi Londyn");
        assertEquals(false, hra1.konecHry());
        assertEquals("Londyn", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("mluv pan_Noks");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpoved ano");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("mluv pan_Churchill");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odpoved ano");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi Bletchley_Park");        
        assertEquals(true, hra1.konecHry());
    }
}

