package logika;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Iuliia Loseeva
 * @version   20.12.2017
 */
public class ProstorTest
{
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
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */
    @Test
    public  void testLzeProjit() {		
        Prostor prostor1 = new Prostor("hala", "vstupní hala budovy VŠE na Jižním městě");
        Prostor prostor2 = new Prostor("bufet", "bufet, kam si můžete zajít na svačinku");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("bufet"));
        assertEquals(null, prostor2.vratSousedniProstor("pokoj"));
    }


    @Test
    public void testVeci()
    {
        logika.Prostor prostor1 = new logika.Prostor(null, null);
        logika.Vec vec1 = new logika.Vec("A", true);
        logika.Vec vec2 = new logika.Vec("B", false);
        prostor1.najdiVec("A");
        prostor1.najdiVec("B");
        prostor1.najdiVec("C");
        prostor1.vlozVec(vec1);
        prostor1.vlozVec(vec2);
        prostor1.najdiVec("A");
        prostor1.najdiVec("B");
        prostor1.najdiVec("C");
        prostor1.odeberVec(vec1);
    }

    @Test
    public void prostor()
    {
        logika.Prostor prostor1 = new logika.Prostor("A", "prostor A");
        logika.Postava postava1 = new logika.Postava("pA", "Ahoj!", true);
        logika.Vec vec1 = new logika.Vec("vA", true);
        logika.Vec vec2 = new logika.Vec("vB", false);
        assertEquals(true, prostor1.vlozVec(vec1));
        assertEquals(true, prostor1.vlozVec(vec2));
        assertEquals(true, prostor1.vlozPostavu(postava1));
        prostor1.setZamcenoVypis("prostor je zamcen");
        assertEquals("prostor je zamcen", prostor1.getZamcenoVypis());
        assertEquals(false, prostor1.jeZamcen());
        prostor1.zamknout(true);
        assertEquals(true, prostor1.jeZamcen());
        assertEquals(postava1, prostor1.najdiPostavu("pA"));
        assertEquals(vec1, prostor1.najdiVec("vA"));
        assertEquals(true, prostor1.odeberVec(vec1));
        assertEquals(null, prostor1.najdiVec("vA"));
        logika.Prostor prostor2 = new logika.Prostor("B", "prostor B");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor1, prostor2.vratSousedniProstor("A"));
    }
}


