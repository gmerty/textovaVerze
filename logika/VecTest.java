/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída VecTest slouží ke komplexnímu otestování třídy Vec 
 *
 * @author    Iuliia Loseeva
 * @version   31.12.2017
 */
public class VecTest
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
    public void veci()
    {
        logika.Vec vec1 = new logika.Vec("va", true);
        logika.Vec vec2 = new logika.Vec("vb", false);
        assertEquals("va", vec1.getNazev());
        assertEquals(true, vec1.jePrenositelna());
        vec1.setPrenositelnost(false);
        assertEquals(false, vec1.jePrenositelna());
    }
}

