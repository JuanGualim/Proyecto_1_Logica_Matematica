/**
 * Genera recursivamente todas las permutaciones de un arreglo.
 */
public class Permutaciones {
    private long contadorPermutaciones;

    /**
     * Reinicia el contador antes de realizar una nueva prueba.
     */
    public void reiniciarContador() {
        contadorPermutaciones = 0;
    }

    /**
     * Devuelve la cantidad de permutaciones completas generadas.
     */
    public long obtenerContadorPermutaciones() {
        return contadorPermutaciones;
    }

    /**
     * Genera todas las permutaciones fijando un elemento en cada posicion.
     *
     * @param arreglo elementos que se desean permutar
     * @param posicion posicion que se fijara en la llamada actual
     * @param mostrarPermutaciones indica si cada resultado debe mostrarse
     */
    public void generar(int[] arreglo, int posicion, boolean mostrarPermutaciones) {
        // Caso base: todas las posiciones contienen una eleccion definitiva.
        if (posicion == arreglo.length) {
            contadorPermutaciones++;

            if (mostrarPermutaciones) {
                mostrarArreglo(arreglo);
            }

            return;
        }

        for (int i = posicion; i < arreglo.length; i++) {
            // Coloca una de las opciones disponibles en la posicion actual.
            intercambiar(arreglo, posicion, i);

            // Genera las permutaciones de las posiciones restantes.
            generar(arreglo, posicion + 1, mostrarPermutaciones);

            // Restaura el arreglo para explorar correctamente la siguiente rama.
            intercambiar(arreglo, posicion, i);
        }
    }

    private void intercambiar(int[] arreglo, int primeraPosicion, int segundaPosicion) {
        int temporal = arreglo[primeraPosicion];
        arreglo[primeraPosicion] = arreglo[segundaPosicion];
        arreglo[segundaPosicion] = temporal;
    }

    private void mostrarArreglo(int[] arreglo) {
        System.out.print("[");

        for (int i = 0; i < arreglo.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arreglo[i]);
        }

        System.out.println("]");
    }
}
