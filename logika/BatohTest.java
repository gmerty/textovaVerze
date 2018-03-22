/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída BatohTest slouží ke komplexnímu otestování třídy Batoh
 *
 * @author    Iuliia Loseeva
 * @version   31.12.2017
 */
public class BatohTest
{
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }

    //== VLASTNÍ TESTY =========================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }

    @Test
    public void batohTest()
    {
        logika.Batoh batoh1 = new logika.Batoh();
        logika.Vec vec1 = new logika.Vec("vA", true);
        logika.Vec vec2 = new logika.Vec("vB", false);
        assertEquals(false, batoh1.najdiVBatohu("vA"));
        assertEquals(null, batoh1.odeberVec("vA"));
        assertEquals(true, batoh1.pridejVec(vec1));
        assertEquals(true, batoh1.pridejVec(vec2));
        //assertEquals("V batohu: vB, vA, ", batoh1.vBatohu());
        assertEquals(8, batoh1.volnychMist());
        assertEquals(true, batoh1.najdiVBatohu("vA"));
        assertEquals(vec1, batoh1.odeberVec("vA"));
        assertEquals(9, batoh1.volnychMist());
    }

    @Test
    public void seberTest()
    {
        logika.Batoh batoh1 = new logika.Batoh();
        logika.Vec vec1 = new logika.Vec("va", true);
        logika.Vec vec2 = new logika.Vec("vb", false);
        logika.HerniPlan herniPla1 = new logika.HerniPlan();
        logika.PrikazSeber prikazSe1 = new logika.PrikazSeber(herniPla1);
        assertEquals("To tu neni.", prikazSe1.provedPrikaz("seber va"));
        logika.Prostor prostor1 = new logika.Prostor("A", "prostor A");
        assertEquals(true, prostor1.vlozVec(vec1));
        assertEquals(true, prostor1.vlozVec(vec2));
        logika.PrikazJdi prikazJd1 = new logika.PrikazJdi(herniPla1);
        assertEquals("Tam se odsud jít nedá!", prikazJd1.provedPrikaz("jdi A"));
        herniPla1.setAktualniProstor(prostor1);
        assertEquals("To tu neni.", prikazSe1.provedPrikaz("seber va"));
        assertEquals(false, prostor1.vlozVec(vec1));
        assertEquals("To tu neni.", prikazSe1.provedPrikaz("seber va"));
        //assertEquals("Jsi v prostoru A prostor A.\nvýchody:\nveci: vb va\npostavy:", prostor1.dlouhyPopis());
    }
}


