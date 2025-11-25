package arbolbst_00000269541;

/**
 * Clase que implementa un Arbol Binario de Busqueda (BST)
 * para valores enteros.
 */
public class ArbolBST {
    private Nodo raiz;

    /**
     * Constructor que inicializa un arbol vacio.
     * La raiz es null.
     */
    public ArbolBST() {
        this.raiz = null; // Inicializa el árbol vacío [cite: 63, 75]
    }
    
    // Getter para la raiz (solicitado en la parte 3.5 para testing)
    public Nodo getRaiz () {
        return raiz;
    }
    
    /**
     * Inserta un nuevo valor en el arbol.
     * Utiliza un método auxiliar recursivo.
     * @param valor El valor a insertar.
     */
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    /**
     * Metodo recursivo auxiliar para insertar.
     * @param nodo El nodo actual (la raíz del subárbol actual).
     * @param valor El valor a insertar.
     * @return El nodo actualizado (la nueva raíz del subárbol, que podría ser el nuevo nodo).
     */
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        // Caso base 1: Si el subárbol está vacío, se crea el nuevo nodo y se devuelve [cite: 114]
        if (nodo == null) {
            return new Nodo(valor);
        }

        // Si el valor es menor, se busca en el subárbol izquierdo [cite: 115]
        if (valor < nodo.getValor()) {
            // La referencia izquierda del nodo actual se actualiza con el resultado de la recursión
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), valor));
        } 
        // Si el valor es mayor, se busca en el subárbol derecho [cite: 116]
        else if (valor > nodo.getValor()) {
            // La referencia derecha del nodo actual se actualiza con el resultado de la recursión
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), valor));
        } 
        // Si el valor es igual (duplicado), no se inserta [cite: 117]
        else {
            System.out.println("Advertencia: No se insertó el valor " + valor + ". Los duplicados no están permitidos en este BST.");
        }

        // Se retorna el nodo actual (sin cambios en su valor si no se insertó, o la nueva referencia si se insertó)
        return nodo;
    }
    
/**
     * Busca un valor en el arbol.
     * @param valor El valor a buscar.
     * @return true si el valor existe, false en caso contrario.
     */
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    /**
     * Metodo recursivo auxiliar para buscar.
     * @param nodo El nodo actual (la raíz del subárbol actual).
     * @param valor El valor a buscar.
     * @return true si se encuentra, false en caso contrario.
     */
    private boolean buscarRecursivo(Nodo nodo, int valor) {
        // Caso base 1: Nodo es null (no se encontró en este subárbol) [cite: 159]
        if (nodo == null) {
            return false;
        }

        // Caso base 2: El valor coincide con el nodo actual [cite: 160]
        if (valor == nodo.getValor()) {
            return true;
        }

        // Si el valor es menor, buscar en el subárbol izquierdo 
        if (valor < nodo.getValor()) {
            return buscarRecursivo(nodo.getIzquierdo(), valor);
        } 
        // Si el valor es mayor, buscar en el subárbol derecho 
        else { 
            return buscarRecursivo(nodo.getDerecho(), valor);
        }
    }
    
    /**
     * Elimina un valor del arbol.
     * Utiliza un método auxiliar recursivo.
     * @param valor El valor a eliminar.
     */
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    /**
     * Metodo recursivo auxiliar para eliminar.
     * @param nodo El nodo actual (la raíz del subárbol).
     * @param valor El valor a eliminar.
     * @return El nodo actualizado (la nueva raíz del subárbol).
     */
    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        // Caso 1: Arbol vacío o nodo no encontrado [cite: 189, 195]
        if (nodo == null) {
            return null;
        }

        // 1. Buscar el nodo a eliminar
        if (valor < nodo.getValor()) {
            // Buscar en subarbol izquierdo
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            // Buscar en subarbol derecho
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), valor));
        } 
        
        // 2. Nodo encontrado - manejar los 3 casos
        else {
            // Caso 2.1: Nodo sin hijo izquierdo o sin hijos (hoja)
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho(); // Retorna el hijo derecho (puede ser null) [cite: 242, 243]
            } 
            // Caso 2.2: Nodo sin hijo derecho
            else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo(); // Retorna el hijo izquierdo 
            }

            // Caso 2.3: Nodo con dos hijos [cite: 244]
            // a. Encontrar el sucesor inorden (el mínimo en el subárbol derecho) 
            int sucesorValor = encontrarMinimoValor(nodo.getDerecho());
            
            // b. Reemplazar el valor del nodo actual con el sucesor [cite: 246]
            nodo.setValor(sucesorValor);

            // c. Eliminar el sucesor (que ahora está duplicado en el subárbol derecho) [cite: 247]
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesorValor));
        }

        return nodo;
    }
    
    /**
     * Encuentra el valor minimo en un subarbol.
     * Se mueve repetidamente al hijo izquierdo.
     * @param nodo La raiz del subarbol.
     * @return El valor minimo.
     */
    private int encontrarMinimoValor(Nodo nodo) {
        // Si no hay hijo izquierdo, este es el nodo más a la izquierda, por lo tanto el mínimo
        if (nodo.getIzquierdo() == null) {
            return nodo.getValor();
        } 
        // Continúa buscando a la izquierda
        else {
            return encontrarMinimoValor(nodo.getIzquierdo());
        }
    }
    
    // Dentro de la clase ArbolBST.java

    /**
     * Realiza un recorrido inorden (Izq-Raiz-Der).
     * Imprime los valores en orden ascendente.
     */
    public void inorden() {
        System.out.print("Recorrido Inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo auxiliar para inorden.
     * @param nodo El nodo actual.
     */
    private void inordenRecursivo(Nodo nodo) {
        // Manejo de árbol vacío o caso base
        if (nodo != null) {
            // 1. Recorrer subarbol izquierdo
            inordenRecursivo(nodo.getIzquierdo()); 

            // 2. Visitar nodo actual (imprimir el valor)
            System.out.print(nodo.getValor() + " "); 

            // 3. Recorrer subarbol derecho
            inordenRecursivo(nodo.getDerecho()); 
        }
    }
    
    // Dentro de la clase ArbolBST.java

    /**
     * Realiza un recorrido preorden (Raiz-Izq-Der).
     * Util para copiar el arbol.
     */
    public void preorden() {
        System.out.print("Recorrido Preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo auxiliar para preorden.
     * @param nodo El nodo actual.
     */
    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            // 1. Visitar nodo actual (imprimir el valor)
            System.out.print(nodo.getValor() + " "); 

            // 2. Recorrer subarbol izquierdo
            preordenRecursivo(nodo.getIzquierdo()); 

            // 3. Recorrer subarbol derecho
            preordenRecursivo(nodo.getDerecho()); 
        }
    }
    
    // Dentro de la clase ArbolBST.java

    /**
     * Realiza un recorrido postorden (Izq-Der-Raiz).
     * Util para eliminar el arbol.
     */
    public void postorden() {
        System.out.print("Recorrido Postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }

    /**
     * Metodo recursivo auxiliar para postorden.
     * @param nodo El nodo actual.
     */
    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            // 1. Recorrer subarbol izquierdo
            postordenRecursivo(nodo.getIzquierdo()); 

            // 2. Recorrer subarbol derecho
            postordenRecursivo(nodo.getDerecho()); 

            // 3. Visitar nodo actual (imprimir el valor)
            System.out.print(nodo.getValor() + " "); 
        }
    }
    
    // Dentro de la clase ArbolBST.java

    /**
     * Calcula la altura del arbol.
     * @return La altura del arbol (-1 si esta vacio, 0 si solo tiene raiz).
     */
    public int altura() {
        return alturaRecursiva(raiz);
    }

    /**
     * Metodo recursivo para calcular altura.
     * @param nodo El nodo actual.
     * @return La altura del subarbol.
     */
    private int alturaRecursiva(Nodo nodo) {
        // Caso base: nodo vacio
        if (nodo == null) {
            return -1;
        }

        // Calcular altura de subarboles
        int alturaIzq = alturaRecursiva(nodo.getIzquierdo());
        int alturaDer = alturaRecursiva(nodo.getDerecho());

        // Retornar el máximo de las alturas + 1 (por el nodo actual)
        // La funcion Math.max(a, b) es útil aquí.
        return Math.max(alturaIzq, alturaDer) + 1;
    }
    
    // Dentro de la clase ArbolBST.java

    /**
     * Cuenta el numero total de nodos en el arbol.
     * @return El numero de nodos.
     */
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    /**
     * Metodo recursivo para contar nodos.
     * @param nodo El nodo actual.
     * @return El numero de nodos en el subarbol.
     */
    private int contarNodosRecursivo(Nodo nodo) {
        // Caso base: subarbol vacio
        if (nodo == null) {
            return 0;
        }

        // 1 (por el nodo actual) + nodos de la izquierda + nodos de la derecha
        return 1 + contarNodosRecursivo(nodo.getIzquierdo()) + contarNodosRecursivo(nodo.getDerecho());
    }
    
    // Dentro de la clase ArbolBST.java

    /**
     * Encuentra el valor minimo en el arbol.
     * @return El valor minimo.
     * @throws IllegalStateException si el arbol esta vacio.
     */
    public int encontrarMinimo() {
        if (raiz == null) {
            // Verificar si el arbol esta vacio
            throw new IllegalStateException("El arbol esta vacio");
        }

        Nodo actual = raiz;
        // Ir siempre a la izquierda hasta encontrar el nodo sin hijo izq
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }

        return actual.getValor();
    }
    
    // Dentro de la clase ArbolBST.java

    /**
     * Encuentra el valor maximo en el arbol.
     * @return El valor maximo.
     * @throws IllegalStateException si el arbol esta vacio.
     */
    public int encontrarMaximo() {
        if (raiz == null) {
            // Verificar si el arbol esta vacio
            throw new IllegalStateException("El arbol esta vacio");
        }

        Nodo actual = raiz;
        // Ir siempre a la derecha hasta encontrar el nodo sin hijo der
        while (actual.getDerecho() != null) {
            actual = actual.getDerecho();
        }

        return actual.getValor();
    }
    
    // Dentro de la clase ArbolBST.java

    /**
     * Verifica si el arbol esta vacio.
     * @return true si el arbol esta vacio, false en caso contrario.
     */
    public boolean esVacio() {
        return raiz == null;
    }  
}