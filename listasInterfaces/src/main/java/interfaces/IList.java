/**
 * Interfaz genérica para una estructura de datos de Lista.
 * Define las operaciones básicas que toda lista debe implementar.
 *
 * @param <T> El tipo de elementos que la lista contendrá.
 * @author Asistente de Programación
 */
package interfaces;

import excepciones.ListException;

public interface IList<T> {

    /**
     * Reemplaza el elemento en la posición 'i' de la lista
     * por el objeto del parámetro 'o'.
     *
     * @param o El objeto que reemplazará al elemento actual.
     * @param i El índice (posición) donde se hará el reemplazo.
     * @throws ListException Si la lista está vacía o si el índice 'i'
     * está fuera de los límites válidos (0 a tamaño-1).
     * [cite: 13, 14]
     */
    void set(T o, int i) throws ListException;

    /**
     * Elimina la primera ocurrencia del elemento del parámetro 'o' si existe.
     *
     * @param o El objeto a buscar y eliminar.
     * @return true si el elemento fue encontrado y eliminado, false en caso
     * contrario. [cite: 15, 16]
     * @throws ListException Si la lista está vacía. [cite: 17]
     */
    boolean remove(T o) throws ListException;

    /**
     * Regresa el índice de la primera ocurrencia del elemento 'o' en la lista.
     *
     * @param o El objeto a buscar.
     * @return El índice de la primera ocurrencia, o -1 si el elemento no existe. [cite: 18]
     */
    int indexOf(T o);

    /**
     * Elimina todos los elementos de la lista, dejándola vacía. [cite: 19]
     */
    void clear();
    
    // --- Otros métodos que típicamente incluye una interfaz IList (puedes agregarlos si estaban en el ejemplo) ---
    /*
    boolean add(T o);
    void add(T o, int i) throws ListException;
    T get(int i) throws ListException;
    T remove(int i) throws ListException;
    int size();
    boolean isEmpty();
    // ... otros métodos
    */
}