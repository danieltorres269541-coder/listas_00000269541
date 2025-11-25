package arbolbst_00000269541;

/**
 * Clase generica para representar un nodo en el arbol BST.
 * T debe ser un tipo que implemente Comparable.
 */
public class NodoGenerico<T extends Comparable<T>> {
    private T valor;
    private NodoGenerico<T> izquierdo;
    private NodoGenerico<T> derecho;

    /**
     * Constructor.
     * @param valor El valor generico a almacenar.
     */
    public NodoGenerico(T valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    // --- Getters y Setters ---

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoGenerico<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoGenerico<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoGenerico<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoGenerico<T> derecho) {
        this.derecho = derecho;
    }
}