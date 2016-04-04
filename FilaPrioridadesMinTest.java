import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FilaPrioridadesMinTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FilaPrioridadesMinTest
{
    /**
     * Default constructor for test class FilaPrioridadesMinTest
     */
    public FilaPrioridadesMinTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        fpm = new FilaPrioridadesMin<Integer>(entradas);
    }

    @Test
    public void verificarMinimo() {
        assertEquals("Não é o mínimo esperado.", fpm.minimo(), new Integer(11));
    }
    
    @Test
    public void verificarExtrairMinimo() {
        Integer[] mins = Arrays.copyOf(entradas, entradas.length);
        Arrays.sort(mins);
        
        for (Integer n : mins) {
            assertEquals("Entrada removida não é o mínimo esperado.", fpm.extrairMinimo(), n);
        }
    }
    
    @Test
    public void verificarInserir() {
        Integer n1 = 10, n2 = 9, n3 = 21;
        
        fpm.inserir(n1);
        fpm.inserir(n2);
        fpm.inserir(n3);
        assertEquals("Minimo não capturou recém-reduzido.", fpm.extrairMinimo(), n2);
        assertEquals("Minimo não capturou recém-reduzido.", fpm.extrairMinimo(), n1);
        assertEquals("Minimo não capturou recém-reduzido.", fpm.extrairMinimo(), new Integer(11));
        assertEquals("Minimo não capturou recém-reduzido.", fpm.extrairMinimo(), new Integer(20));
        assertEquals("Minimo não capturou recém-reduzido.", fpm.extrairMinimo(), n3);
        assertEquals("Minimo não capturou recém-reduzido.", fpm.extrairMinimo(), new Integer(25));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    private static final Integer[] entradas = { 11, 20, 40, 25, 30, 50, 90, 65, 60 };
    private FilaPrioridadesMin<Integer> fpm;
}
