/**
 * Clase de excepción personalizada para manejar errores específicos de las
 * operaciones sobre la lista, como índices fuera de límites o lista vacía.
 * * @author Asistente de Programación
 */
package excepciones;

public class ListException extends Exception {

    /**
     * Constructor por defecto. Crea una nueva excepción ListException
     * sin mensaje de detalle.
     */
    public ListException() {
        // Llama al constructor de la superclase Exception
        super();
    }

    /**
     * Constructor con mensaje. Crea una nueva excepción ListException
     * con el mensaje de detalle especificado.
     *
     * @param message El mensaje de detalle.
     */
    public ListException(String message) {
        // Llama al constructor de la superclase Exception con el mensaje
        super(message);
    }
}