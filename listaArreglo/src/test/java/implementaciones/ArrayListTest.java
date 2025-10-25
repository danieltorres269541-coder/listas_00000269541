package implementaciones;

import excepciones.ListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de Pruebas Unitarias para la clase ArrayList.
 * Verifica el correcto funcionamiento de los métodos requeridos 
 * (set, remove, indexOf, clear) para tipos Integer y String.
 * * @author Asistente de Programación
 */
public class ArrayListTest {

    // Instancias de ArrayList para las pruebas
    private ArrayList<Integer> listaInt;
    private ArrayList<String> listaString;

    /**
     * Se ejecuta antes de cada método de prueba. Inicializa las listas.
     */
    @BeforeEach
    public void setUp() {
        listaInt = new ArrayList<>();
        listaString = new ArrayList<>();
    }
    
    // =========================================================================
    //  PRUEBAS DEL MÉTODO indexOf()
    // =========================================================================
    
    @Test
    void testIndexOf_ElementoExistenteInteger() {
        listaInt.add(10);
        listaInt.add(20);
        listaInt.add(30);
        
        assertEquals(1, listaInt.indexOf(20), "Debe retornar el índice correcto para Integer.");
    }
    
    @Test
    void testIndexOf_PrimeraOcurrenciaString() {
        listaString.add("A");
        listaString.add("B");
        listaString.add("A");
        
        assertEquals(0, listaString.indexOf("A"), "Debe retornar el índice de la primera ocurrencia.");
    }
    
    // =========================================================================
    //  PRUEBAS DEL MÉTODO set(T o, int i)
    // =========================================================================

    @Test
    void testSet_CorrectoInteger() throws ListException {
        listaInt.add(100);
        listaInt.add(200);
        
        listaInt.set(999, 0);
        
        // Verificación auxiliar con el método get()
        assertEquals(999, listaInt.get(0), "set() debe reemplazar el elemento correctamente.");
    }
    
    @Test
    void testSet_LanzaExcepcionIndiceFueraString() {
        listaString.add("Uno");
        
        // El índice 1 está fuera de los límites, ya que el size es 1.
        assertThrows(ListException.class, () -> {
            listaString.set("Error", 1);
        }, "set() debe lanzar ListException si el índice está fuera de límites.");
    }
    
    @Test
    void testSet_LanzaExcepcionListaVacia() {
        // La lista está vacía antes de la prueba.
        assertThrows(ListException.class, () -> {
            listaInt.set(500, 0);
        }, "set() debe lanzar ListException si la lista está vacía.");
    }

    // =========================================================================
    //  PRUEBAS DEL MÉTODO remove(T o)
    // =========================================================================

    @Test
    void testRemove_ElementoExistenteInteger() throws ListException {
        listaInt.add(1);
        listaInt.add(2);
        listaInt.add(3);
        
        assertTrue(listaInt.remove(2), "Debe retornar true si elimina el elemento.");
        assertEquals(2, listaInt.size(), "El tamaño debe reducirse.");
        
        // Verifica que el desplazamiento haya ocurrido
        assertEquals(3, listaInt.get(1), "El elemento '3' debe haberse desplazado a la posición 1.");
    }
    
    @Test
    void testRemove_ElementoNoExistenteString() throws ListException {
        listaString.add("Manzana");
        
        assertFalse(listaString.remove("Pera"), "Debe retornar false si el elemento no existe.");
        assertEquals(1, listaString.size(), "El tamaño no debe cambiar.");
    }
    
    @Test
    void testRemove_LanzaExcepcionListaVacia() {
        assertThrows(ListException.class, () -> {
            listaInt.remove(100);
        }, "remove() debe lanzar ListException si la lista está vacía.");
    }
    
    // =========================================================================
    //  PRUEBAS DEL MÉTODO clear()
    // =========================================================================
    
    @Test
    void testClear_Integer() {
        listaInt.add(10);
        listaInt.add(20);
        listaInt.clear();
        
        assertTrue(listaInt.isEmpty(), "clear() debe dejar la lista vacía.");
    }
}