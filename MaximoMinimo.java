/**
 * Encuentra simultaneamente el minimo y el maximo mediante divide y venceras.
 */
public class MaximoMinimo {
    private long comparaciones;

    /**
     * Guarda los dos valores producidos por cada llamada recursiva.
     */
    public static class Resultado {
        private final int minimo;
        private final int maximo;

        public Resultado(int minimo, int maximo) {
            this.minimo = minimo;
            this.maximo = maximo;
        }

        public int obtenerMinimo() {
            return minimo;
        }

        public int obtenerMaximo() {
            return maximo;
        }
    }

    /**
     * Reinicia el contador antes de realizar una nueva prueba.
     */
    public void reiniciarComparaciones() {
        comparaciones = 0;
    }

    /**
     * Devuelve las comparaciones realizadas al combinar resultados.
     */
    public long obtenerComparaciones() {
        return comparaciones;
    }

    /**
     * Encuentra el minimo y el maximo del segmento [izquierdo, derecho].
     *
     * @param arreglo arreglo que se desea procesar
     * @param izquierdo limite izquierdo del segmento
     * @param derecho limite derecho del segmento
     * @return un objeto que contiene el minimo y el maximo del segmento
     */
    public Resultado encontrar(int[] arreglo, int izquierdo, int derecho) {
        // Caso base: un unico elemento es a la vez minimo y maximo.
        // No se realiza ninguna comparacion de combinacion en este caso.
        if (izquierdo == derecho) {
            return new Resultado(arreglo[izquierdo], arreglo[izquierdo]);
        }

        int medio = izquierdo + (derecho - izquierdo) / 2;

        // Se resuelven recursivamente dos problemas de tamano n/2.
        Resultado resultadoIzquierdo = encontrar(arreglo, izquierdo, medio);
        Resultado resultadoDerecho = encontrar(arreglo, medio + 1, derecho);

        // Comparacion 1 de la combinacion: elegir el menor de ambos minimos.
        comparaciones++;
        int minimo;
        if (resultadoIzquierdo.minimo < resultadoDerecho.minimo) {
            minimo = resultadoIzquierdo.minimo;
        } else {
            minimo = resultadoDerecho.minimo;
        }

        // Comparacion 2 de la combinacion: elegir el mayor de ambos maximos.
        comparaciones++;
        int maximo;
        if (resultadoIzquierdo.maximo > resultadoDerecho.maximo) {
            maximo = resultadoIzquierdo.maximo;
        } else {
            maximo = resultadoDerecho.maximo;
        }

        return new Resultado(minimo, maximo);
    }
}
