/**
 * Implementación de una lista genérica utilizando un arreglo.
 * Sigue el contrato definido por la interfaz IList y debe incluir comentarios de
 * documentación para la clase y sus métodos[cite: 5].
 * * @param <T> El tipo de elementos que contendrá la lista.
 * @author Asistente de Programación
 */
package implementaciones;

import interfaces.IList;
import excepciones.ListException;

public class ArrayList<T> implements IList<T> {

    // Constante que define la capacidad inicial del arreglo.
    private static final int CAPACIDAD_INICIAL = 10; 
    
    // Arreglo donde se almacenarán los elementos. Se usa Object[] por restricciones de Java.
    private Object[] data; 
    
    // Número actual de elementos en la lista.
    private int size; 

    /**
     * Constructor por defecto. Inicializa el arreglo con la capacidad inicial.
     */
    public ArrayList() {
        data = new Object[CAPACIDAD_INICIAL];
        size = 0;
    }
    
    // =========================================================================
    //  MÉTODOS AUXILIARES (Necesarios para el correcto funcionamiento)
    // =========================================================================

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Método privado para asegurar que el índice 'i' está en el rango [0, size - 1].
    private void checkIndex(int i) throws ListException {
        // La excepción para una lista vacía se lanza en los métodos públicos.
        if (i < 0 || i >= size) {
            throw new ListException("Índice fuera de límites: " + i + ". Los índices válidos son [0, " + (size - 1) + "]");
        }
    }
    
    // Método auxiliar para agregar un elemento al final (necesario para las pruebas)
    public boolean add(T o) {
        resize(); // Asegura que hay espacio
        data[size] = o;
        size++;
        return true;
    }
    
    // Método auxiliar para obtener un elemento de forma segura (necesario para las pruebas)
    @SuppressWarnings("unchecked")
    public T get(int i) throws ListException {
        if (isEmpty()) {
            throw new ListException("La lista está vacía.");
        }
        checkIndex(i);
        return (T) data[i];
    }
    
    // Reajusta el tamaño del arreglo si se llena
    private void resize() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            // Copia los elementos del arreglo antiguo al nuevo
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
    
    // =========================================================================
    //  IMPLEMENTACIONES REQUERIDAS (set, remove, indexOf, clear) [cite: 12, 30]
    // =========================================================================

    /**
     * Reemplaza el elemento que se encuentra en la posición 'i' de la lista 
     * por el objeto del parámetro 'o'[cite: 13].
     * * @param o El objeto con el que se reemplazará el elemento.
     * @param i El índice de la posición a reemplazar.
     * @throws ListException Si la lista está vacía o el índice 'i' está fuera
     * de los límites de los datos[cite: 14].
     */
    @Override
    public void set(T o, int i) throws ListException {
        if (isEmpty()) {
            throw new ListException("Lista vacía: No se puede establecer un elemento en una lista vacía.");
        }
        checkIndex(i); 
        
        data[i] = o;
    }

    /**
     * Elimina la primera ocurrencia del elemento del parámetro 'o' si existe[cite: 15].
     * * @param o El elemento a eliminar.
     * @return true si el elemento existe en la lista y fue eliminado, 
     * false en caso contrario[cite: 16].
     * @throws ListException Si la lista está vacía[cite: 17].
     */
    @Override
    public boolean remove(T o) throws ListException {
        if (isEmpty()) {
            throw new ListException("Lista vacía: No se puede remover un elemento de una lista vacía.");
        }
        
        int indexToRemove = indexOf(o);

        if (indexToRemove != -1) {
            // Desplazar los elementos: Mueve todos los elementos a la derecha 
            // de 'indexToRemove' una posición hacia la izquierda.
            for (int i = indexToRemove; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            
            // Limpiar la referencia del último elemento
            data[size - 1] = null;
            
            // Reducir el tamaño
            size--;
            return true;
        }
        
        return false;
    }

    /**
     * Regresa el índice de la primera ocurrencia del elemento del parámetro 'o' en la lista, 
     * o -1 si el elemento no existe[cite: 18].
     * * @param o El elemento a buscar.
     * @return El índice de la primera ocurrencia, o -1 si el elemento no existe.
     */
    @Override
    public int indexOf(T o) {
        // Manejo de elementos nulos
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            // Búsqueda usando el método equals()
            for (int i = 0; i < size; i++) {
                // Se verifica que 'data[i]' no sea nulo antes de llamar a 'equals'
                if (data[i] != null && o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Elimina todos los elementos de la lista[cite: 19].
     */
    @Override
    public void clear() {
        // Limpiar las referencias en el arreglo y restablecer el tamaño.
        // Esto es eficiente y libera memoria de las referencias.
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
}