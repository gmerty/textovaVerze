/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída PostavaTest slouží ke komplexnímu otestování třídy Postava
 *
 * @author    Iuliia Loseeva
 * @version   31.12.2017
 */
public class PostavaTest
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
    public void postava()
    {
        logika.Postava postava1 = new logika.Postava("pa", "ahoj", true);
        assertEquals("pa", postava1.getJmeno());
        assertEquals("ahoj", postava1.getProslov());
        assertEquals(true, postava1.mluvi());
        postava1.setJeVidet(true);
        postava1.setProslov("cao");
        assertEquals("cao", postava1.getProslov());
    }
}

