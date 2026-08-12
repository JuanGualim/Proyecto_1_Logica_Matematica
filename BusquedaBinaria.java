/**
 * Implementa una busqueda binaria recursiva sobre un arreglo ordenado.
 */
public class BusquedaBinaria {
    private int comparaciones;

    /**
     * Reinicia el contador antes de realizar una nueva prueba.
     */
    public void reiniciarComparaciones() {
        comparaciones = 0;
    }

    /**
     * Devuelve la cantidad de comparaciones entre el elemento buscado y
     * el elemento central del arreglo.
     */
    public int obtenerComparaciones() {
        return comparaciones;
    }

    /**
     * Busca un elemento dentro del intervalo [izquierdo, derecho].
     *
     * @param arreglo arreglo ordenado de menor a mayor
     * @param elemento elemento que se desea buscar
     * @param izquierdo limite izquierdo del intervalo de busqueda
     * @param derecho limite derecho del intervalo de busqueda
     * @return posicion del elemento, o -1 si no existe
     */
    public int buscar(int[] arreglo, int elemento, int izquierdo, int derecho) {
        // Caso base: el intervalo esta vacio y el elemento no existe.
        // Esta comprobacion controla la recursion, pero no se incluye en el
        // contador: este mide solo comparaciones con el elemento central.
        if (izquierdo > derecho) {
            return -1;
        }

        int medio = izquierdo + (derecho - izquierdo) / 2;

        // Comparacion 1 del nivel: ¿el elemento central es el buscado?
        comparaciones++;
        if (arreglo[medio] == elemento) {
            return medio;
        }

        // Comparacion 2 del nivel: decide en que mitad continuar.
        comparaciones++;
        if (elemento < arreglo[medio]) {
            // El nuevo intervalo tiene aproximadamente la mitad de elementos.
            return buscar(arreglo, elemento, izquierdo, medio - 1);
        }

        // Tambien se reduce el problema aproximadamente de n a n/2.
        return buscar(arreglo, elemento, medio + 1, derecho);
    }
}
