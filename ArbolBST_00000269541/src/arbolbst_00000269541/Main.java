package arbolbst_00000269541;

/**
 * Clase principal que contiene los metodos de prueba
 * para el ArbolBST (numeros enteros) y el GestorEstudiantes (generico).
 */
public class Main {

    /**
     * Punto de entrada de la aplicacion.
     */
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println(" DEMOSTRACION ARBOL BST");
        System.out.println("=================================\n");

        // PARTE 1, 2 y 3: Pruebas basicas del BST de enteros
        pruebasBST();

        // PARTE 4: Sistema de gestion de estudiantes generico
        pruebaGestorEstudiantes();
    }

    /**
     * Prueba los metodos del BST basico de enteros (Partes 1, 2 y 3).
     */
    private static void pruebasBST() {
        System.out.println("--- PRUEBAS BST BASICO ---\n");

        ArbolBST arbol = new ArbolBST();

        // Insertar valores
        System.out.println("Insertando valores: 50, 30, 70, 20, 40, 60, 80");
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valores) {
            arbol.insertar(valor); 
        }

        // Mostrar recorridos
        System.out.println("\nRECORRIDOS:");
        arbol.inorden();
        arbol.preorden();
        arbol.postorden();

        // Busquedas
        System.out.println("\nBUSQUEDAS:");
        System.out.println("Buscar 40: " + arbol.buscar(40));
        System.out.println("Buscar 100: " + arbol.buscar(100));

        // Informacion del arbol
        System.out.println("\nINFORMACION DEL ARBOL:");
        System.out.println("Altura: " + arbol.altura());
        System.out.println("Total nodos: " + arbol.contarNodos());
        System.out.println("Minimo: " + arbol.encontrarMinimo());
        System.out.println("Maximo: " + arbol.encontrarMaximo());

        // Eliminaciones
        System.out.println("\nELIMINACIONES:");

        // 1. Eliminar hoja (20)
        System.out.println("Eliminando 20 (sin hijos)...");
        arbol.eliminar(20);
        arbol.inorden();

        // 2. Eliminar nodo con un hijo (30)
        System.out.println("\nEliminando 30 (con hijos)...");// Nota: 30 ahora tiene 40 como hijo derecho
        arbol.eliminar(30); 
        arbol.inorden(); 

        // 3. Eliminar raiz (50) - Caso de dos hijos
        System.out.println("\nEliminando 50 (raiz)..."); 
        arbol.eliminar(50);
        arbol.inorden();
    }

    /**
     * Prueba los metodos del Gestor de Estudiantes generico (Parte 4).
     */
    private static void pruebaGestorEstudiantes() {
        System.out.println("\n\n--- SISTEMA GESTOR DE ESTUDIANTES ---\n"); 

        GestorEstudiantes gestor = new GestorEstudiantes();

        // Agregar estudiantes
        gestor.agregarEstudiante("Ana Garcia", 95);
        gestor.agregarEstudiante("Carlos Lopez", 78);
        gestor.agregarEstudiante("Maria Rodriguez", 88); 
        gestor.agregarEstudiante("Juan Martinez", 65); 
        gestor.agregarEstudiante("Laura Sanchez", 92); 
        gestor.agregarEstudiante("Pedro Gomez", 58);
        gestor.agregarEstudiante("Sofia Torres", 85);

        // Mostrar todos (ordenados por calificación)
        gestor.mostrarEstudiantes();

        // Estudiantes en rango
        gestor.estudiantesEnRango(80, 95);

        // Estadisticas
        System.out.println("\nESTADISTICAS:");
        
        // Usamos String.format para mostrar el promedio con dos decimales, ya que es un double.
        System.out.println("Promedio: " + String.format("%.2f", gestor.promedioCalificaciones())); 
        System.out.println("Mejor estudiante: " + gestor.mejorEstudiante()); 
        System.out.println("Aprobados: " + gestor.contarAprobados());
    }
}