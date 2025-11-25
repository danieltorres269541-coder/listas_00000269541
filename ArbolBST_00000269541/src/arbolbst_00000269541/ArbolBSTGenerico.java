package arbolbst_00000269541;

/**
 * Clase que implementa un Arbol Binario de Busqueda (BST) generico.
 * El tipo T debe implementar Comparable para permitir la ordenacion.
 */
public class ArbolBSTGenerico<T extends Comparable<T>> {
    
    // La raiz ahora usa el NodoGenerico
    private NodoGenerico<T> raiz;

    public ArbolBSTGenerico() {
        this.raiz = null;
    }

    // ---------------------------------------------
    // OPERACIONES FUNDAMENTALES (Adaptadas para Generics)
    // ---------------------------------------------

    /**
     * Inserta un nuevo valor en el arbol usando el metodo compareTo().
     * @param valor El valor generico a insertar.
     */
    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoGenerico<T> insertarRecursivo(NodoGenerico<T> nodo, T valor) {
        if (nodo == null) {
            return new NodoGenerico<>(valor);
        }

        // Usamos compareTo:
        // -1 si 'valor' es menor que el nodo actual
        // 0 si son iguales
        // 1 si 'valor' es mayor que el nodo actual
        int comparacion = valor.compareTo(nodo.getValor());

        if (comparacion < 0) { // El valor es MENOR (izquierda)
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), valor));
        } else if (comparacion > 0) { // El valor es MAYOR (derecha)
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), valor));
        } else {
            // Duplicado: Opcionalmente puedes lanzar una excepcion o no hacer nada
            System.out.println("Advertencia: No se insertó el valor duplicado.");
        }

        return nodo;
    }
    
    // ---------------------------------------------
    // RECORRIDO INORDEN (Adaptado para Generics)
    // ---------------------------------------------
    
    /**
     * Realiza un recorrido inorden (Izq-Raiz-Der) e imprime los valores.
     */
    public void inorden() {
        System.out.println("--- Recorrido Inorden de Estudiantes ---");
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(NodoGenerico<T> nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.getIzquierdo()); 
            
            // Usamos toString() de T (Estudiante) para imprimir
            System.out.println(nodo.getValor()); 

            inordenRecursivo(nodo.getDerecho()); 
        }
    }
    
    // ---------------------------------------------
    // MÉTODOS ADICIONALES (Opcional, pero util)
    // ---------------------------------------------
    
    // Nota: Otros metodos como buscar, eliminar, altura, etc., se adaptarian
    // de forma similar, reemplazando 'int' por 'T' y usando 'compareTo()'.
    
    public NodoGenerico<T> getRaiz() {
        return raiz;
    }
    
    // Dentro de la clase ArbolBSTGenerico<T extends Comparable<T>>...

// ... (Tu código de insertar y inorden ya implementado)...

    /**
     * Encuentra el valor maximo en el arbol (el nodo mas a la derecha).
     * @return El valor T (Estudiante) con el valor mas alto.
     * @throws IllegalStateException si el arbol esta vacio.
     */
    public T encontrarMaximoGenerico() {
        if (raiz == null) {
            throw new IllegalStateException("El arbol esta vacio");
        }
        NodoGenerico<T> actual = raiz;
        // Ir siempre a la derecha
        while (actual.getDerecho() != null) {
            actual = actual.getDerecho();
        }
        return actual.getValor();
    }
    
    /**
     * Recolecta todos los valores del arbol en una lista usando recorrido Inorden.
     * (Necesario para calcular promedio y rango en GestorEstudiantes).
     */
    public java.util.List<T> getAllValuesInorden() {
        java.util.List<T> lista = new java.util.ArrayList<>();
        collectInorden(raiz, lista);
        return lista;
    }

    private void collectInorden(NodoGenerico<T> nodo, java.util.List<T> lista) {
        if (nodo != null) {
            collectInorden(nodo.getIzquierdo(), lista);
            lista.add(nodo.getValor());
            collectInorden(nodo.getDerecho(), lista);
        }
    }
}