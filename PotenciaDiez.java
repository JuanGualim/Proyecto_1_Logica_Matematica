/**
 * Implementa un algoritmo recursivo con recurrencia T(n) = T(n - 1) + n^9.
 */
public class PotenciaDiez {
    private static final int EXPONENTE_TRABAJO = 9;

    private long contador;

    /**
     * Reinicia el contador antes de realizar una nueva prueba.
     */
    public void reiniciarContador() {
        contador = 0;
    }

    /**
     * Devuelve la cantidad de operaciones elementales ejecutadas.
     */
    public long obtenerContador() {
        return contador;
    }

    /**
     * Ejecuta n^9 operaciones y luego resuelve el problema de tamano n - 1.
     *
     * @param n tamano actual del problema
     */
    public void ejecutar(int n) {
        // Caso base principal: para n = 0 no queda trabajo por realizar.
        if (n <= 0) {
            return;
        }

        realizarTrabajoPotenciaNueve(n, 0);

        // La llamada principal reduce el problema de n a n - 1.
        ejecutar(n - 1);
    }

    /**
     * Genera nueve niveles con n llamadas por nivel. Al comenzar en el nivel
     * cero se alcanzan exactamente n^9 casos base.
     */
    private void realizarTrabajoPotenciaNueve(int n, int nivel) {
        // Cada hoja representa una operacion elemental completa.
        if (nivel == EXPONENTE_TRABAJO) {
            contador++;
            return;
        }

        for (int i = 0; i < n; i++) {
            realizarTrabajoPotenciaNueve(n, nivel + 1);
        }
    }
}
