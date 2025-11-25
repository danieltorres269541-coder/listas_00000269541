package arbolbst_00000269541;

import java.util.List;

/**
 * Gestor que utiliza un BST para organizar estudiantes por calificacion[cite: 1126].
 */
public class GestorEstudiantes {
    
    private ArbolBSTGenerico<Estudiante> arbolEstudiantes;

    public GestorEstudiantes() {
        this.arbolEstudiantes = new ArbolBSTGenerico<>();
    }

    /**
     * Agrega un estudiante al sistema.
     * @param nombre Nombre del estudiante
     * @param calificacion Calificacion del estudiante
     */
    public void agregarEstudiante(String nombre, int calificacion) {
        Estudiante nuevoEstudiante = new Estudiante(nombre, calificacion);
        arbolEstudiantes.insertar(nuevoEstudiante); // El insertador maneja duplicados (por nota)
        System.out.println("Estudiante agregado: " + nuevoEstudiante);
    }

    /**
     * Muestra todos los estudiantes ordenados por calificacion[cite: 1132].
     */
    public void mostrarEstudiantes() {
        System.out.println("\n=== Estudiantes ordenados por calificacion ===");
        arbolEstudiantes.inorden(); // Imprime en orden de calificación
    }

    /**
     * Encuentra estudiantes en un rango de calificaciones[cite: 1133].
     * @param min Calificacion minima
     * @param max Calificacion maxima
     */
    public void estudiantesEnRango(int min, int max) {
        System.out.println("\nEstudiantes con calificacion entre " + min + " y " + max + ":");
        
        // El recorrido Inorden nos da los estudiantes ordenados por nota
        List<Estudiante> todos = arbolEstudiantes.getAllValuesInorden();
        boolean encontrado = false;
        
        for (Estudiante e : todos) {
            if (e.getNota() >= min && e.getNota() <= max) {
                System.out.println(e);
                encontrado = true;
            }
        }
        if (!encontrado) {
             System.out.println("(Ningún estudiante encontrado en ese rango)");
        }
    }

    /**
     * Calcula el promedio de todas las calificaciones[cite: 1133].
     * @return El promedio
     */
    public double promedioCalificaciones() {
        List<Estudiante> todos = arbolEstudiantes.getAllValuesInorden();
        if (todos.isEmpty()) {
            return 0.0;
        }
        
        double suma = 0;
        for (Estudiante e : todos) {
            suma += e.getNota();
        }
        return suma / todos.size();
    }

    /**
     * Encuentra al estudiante con la mejor calificacion[cite: 1133].
     * @return El estudiante con mejor calificacion
     */
    public Estudiante mejorEstudiante() {
        // Como el BST está ordenado por calificación, el mejor estudiante es el máximo (extremo derecho)
        try {
            return arbolEstudiantes.encontrarMaximoGenerico();
        } catch (IllegalStateException e) {
            return null; // Retorna null si el árbol está vacío
        }
    }

    /**
     * Cuenta cuantos estudiantes aprobaron (>= 70)[cite: 1137].
     * @return Numero de estudiantes aprobados
     */
    public int contarAprobados() {
        List<Estudiante> todos = arbolEstudiantes.getAllValuesInorden();
        int aprobados = 0;
        for (Estudiante e : todos) {
            // Criterio de aprobado: >= 70
            if (e.getNota() >= 70) {
                aprobados++;
            }
        }
        return aprobados;
    }
}