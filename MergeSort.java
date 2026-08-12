/**
 * Implementa Merge Sort recursivo y registra el trabajo realizado al mezclar.
 */
public class MergeSort {
    private long comparaciones;
    private long operacionesMezcla;

    /**
     * Reinicia ambos contadores antes de una nueva prueba.
     */
    public void reiniciarContadores() {
        comparaciones = 0;
        operacionesMezcla = 0;
    }

    /**
     * Devuelve las comparaciones reales entre valores durante las fusiones.
     */
    public long obtenerComparaciones() {
        return comparaciones;
    }

    /**
     * Devuelve la cantidad de elementos escritos durante las fusiones.
     */
    public long obtenerOperacionesMezcla() {
        return operacionesMezcla;
    }

    /**
     * Ordena recursivamente el segmento [izquierdo, derecho].
     *
     * @param arreglo arreglo que se desea ordenar
     * @param izquierdo limite izquierdo del segmento
     * @param derecho limite derecho del segmento
     */
    public void ordenar(int[] arreglo, int izquierdo, int derecho) {
        // Caso base: un segmento con cero o un elemento ya esta ordenado.
        if (izquierdo >= derecho) {
            return;
        }

        int medio = izquierdo + (derecho - izquierdo) / 2;

        // Dos llamadas recursivas sobre problemas de tamano n/2.
        ordenar(arreglo, izquierdo, medio);
        ordenar(arreglo, medio + 1, derecho);

        // La combinacion procesa linealmente todos los elementos del segmento.
        mezclar(arreglo, izquierdo, medio, derecho);
    }

    /**
     * Combina dos segmentos consecutivos que ya se encuentran ordenados.
     */
    private void mezclar(int[] arreglo, int izquierdo, int medio, int derecho) {
        int cantidadIzquierda = medio - izquierdo + 1;
        int cantidadDerecha = derecho - medio;

        int[] mitadIzquierda = new int[cantidadIzquierda];
        int[] mitadDerecha = new int[cantidadDerecha];

        for (int i = 0; i < cantidadIzquierda; i++) {
            mitadIzquierda[i] = arreglo[izquierdo + i];
        }

        for (int i = 0; i < cantidadDerecha; i++) {
            mitadDerecha[i] = arreglo[medio + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = izquierdo;

        while (i < cantidadIzquierda && j < cantidadDerecha) {
            // Solo se cuentan comparaciones entre valores del arreglo.
            comparaciones++;
            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                arreglo[k] = mitadIzquierda[i];
                i++;
            } else {
                arreglo[k] = mitadDerecha[j];
                j++;
            }

            // Cada escritura representa un elemento procesado por la mezcla.
            operacionesMezcla++;
            k++;
        }

        while (i < cantidadIzquierda) {
            arreglo[k] = mitadIzquierda[i];
            operacionesMezcla++;
            i++;
            k++;
        }

        while (j < cantidadDerecha) {
            arreglo[k] = mitadDerecha[j];
            operacionesMezcla++;
            j++;
            k++;
        }
    }
}
