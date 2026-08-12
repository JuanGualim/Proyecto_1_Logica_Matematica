/**
 * Resuelve recursivamente el problema clasico de las Torres de Hanoi.
 */
public class Hanoi {
    private long contadorMovimientos;

    /**
     * Reinicia el contador antes de realizar una nueva prueba.
     */
    public void reiniciarContador() {
        contadorMovimientos = 0;
    }

    /**
     * Devuelve la cantidad de movimientos de discos realizados.
     */
    public long obtenerContadorMovimientos() {
        return contadorMovimientos;
    }

    /**
     * Mueve los discos desde la torre de origen hasta la de destino.
     *
     * @param discos numero de discos que se deben mover
     * @param origen torre de origen
     * @param destino torre de destino
     * @param auxiliar torre utilizada como apoyo
     * @param mostrarMovimientos indica si cada movimiento debe mostrarse
     */
    public void resolver(
            int discos,
            char origen,
            char destino,
            char auxiliar,
            boolean mostrarMovimientos) {
        // Permite finalizar sin trabajo si no hay discos.
        if (discos <= 0) {
            return;
        }

        // Caso base: un disco requiere exactamente un movimiento.
        if (discos == 1) {
            moverDisco(1, origen, destino, mostrarMovimientos);
            return;
        }

        // Primero mueve n - 1 discos hacia la torre auxiliar.
        resolver(discos - 1, origen, auxiliar, destino, mostrarMovimientos);

        // Luego mueve una vez el disco mayor hacia su destino.
        moverDisco(discos, origen, destino, mostrarMovimientos);

        // Finalmente mueve los n - 1 discos encima del disco mayor.
        resolver(discos - 1, auxiliar, destino, origen, mostrarMovimientos);
    }

    /**
     * Registra un movimiento real dentro de la solucion recursiva.
     */
    private void moverDisco(
            int disco, char origen, char destino, boolean mostrarMovimiento) {
        contadorMovimientos++;

        if (mostrarMovimiento) {
            System.out.println(
                    "Mover disco " + disco + " de " + origen + " a " + destino);
        }
    }
}
