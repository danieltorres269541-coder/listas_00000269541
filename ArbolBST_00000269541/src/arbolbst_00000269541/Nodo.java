package arbolbst_00000269541;

/**
 * Clase que representa un nodo en el arbol BST.
 * Contiene un valor entero y referencias a sus hijos izquierdo y derecho.
 */
public class Nodo {
    private int valor;
    private Nodo izquierdo;
    private Nodo derecho;

    /**
     * Constructor que inicializa un nodo con un valor.
     * Los hijos izquierdo y derecho se inicializan a null por defecto.
     * @param valor El valor entero a almacenar.
     */
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null; // Inicialización explícita, aunque Java lo hace por defecto
        this.derecho = null;   // Inicialización explícita, aunque Java lo hace por defecto
    }

    // --- Getters y Setters ---

    /**
     * Obtiene el valor almacenado en el nodo.
     * @return El valor del nodo.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Establece un nuevo valor para el nodo.
     * @param valor El nuevo valor a establecer.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Obtiene la referencia al hijo izquierdo.
     * @return El nodo hijo izquierdo.
     */
    public Nodo getIzquierdo() {
        return izquierdo;
    }

    /**
     * Establece la referencia al hijo izquierdo.
     * @param izquierdo El nuevo nodo hijo izquierdo.
     */
    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     * Obtiene la referencia al hijo derecho.
     * @return El nodo hijo derecho.
     */
    public Nodo getDerecho() {
        return derecho;
    }

    /**
     * Establece la referencia al hijo derecho.
     * @param derecho El nuevo nodo hijo derecho.
     */
    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
}