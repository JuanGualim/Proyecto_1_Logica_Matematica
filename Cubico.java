/**
 * Implementa un algoritmo recursivo con recurrencia T(n) = T(n - 1) + n^2.
 */
public class Cubico {
    private long contador;

    /**
     * Reinicia el contador antes de realizar una nueva prueba.
     */
    public void reiniciarContador() {
        contador = 0;
    }

    /**
     * Devuelve la cantidad de operaciones ejecutadas por los ciclos.
     */
    public long obtenerContador() {
        return contador;
    }

    /**
     * Ejecuta n^2 operaciones y luego resuelve el problema de tamano n - 1.
     *
     * @param n tamano actual del problema
     */
    public void ejecutar(int n) {
        // Caso base: para n = 0 no queda trabajo por realizar.
        if (n <= 0) {
            return;
        }

        // Trabajo cuadratico del nivel: el cuerpo se ejecuta realmente n^2 veces.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                contador++;
            }
        }

        // La siguiente llamada reduce el problema de n a n - 1.
        ejecutar(n - 1);
    }
}
