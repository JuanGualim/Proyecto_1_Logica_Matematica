public class Main {
    private static final int[] TAMANOS = {16, 32, 64, 128, 256, 512, 1024};

    public static void main(String[] args) {
        ejecutarBusquedaBinaria();
        System.out.println();
        ejecutarMaximoMinimo();
    }

    /**
     * Ejecuta las pruebas del algoritmo #1.
     */
    private static void ejecutarBusquedaBinaria() {
        BusquedaBinaria busqueda = new BusquedaBinaria();

        System.out.println("============================================================");
        System.out.println("BUSQUEDA BINARIA RECURSIVA - O(lg n)");
        System.out.println("============================================================");
        System.out.println();
        System.out.printf("%-8s %-10s %-12s %-10s %-14s %-8s%n",
                "n", "Elemento", "Encontrado", "Posicion", "Comparaciones", "log2(n)");
        System.out.println("--------------------------------------------------------------------------");

        for (int n : TAMANOS) {
            int[] arreglo = crearArregloOrdenado(n);

            // El ultimo elemento obliga a recorrer una cantidad de niveles
            // cercana al maximo y permite mostrar una posicion encontrada.
            int elementoBuscado = n - 1;

            busqueda.reiniciarComparaciones();
            int posicion = busqueda.buscar(
                    arreglo, elementoBuscado, 0, arreglo.length - 1);

            boolean encontrado = posicion != -1;
            int logaritmoBaseDos = (int) (Math.log(n) / Math.log(2));

            System.out.printf("%-8d %-10d %-12s %-10d %-14d %-8d%n",
                    n,
                    elementoBuscado,
                    encontrado ? "Si" : "No",
                    posicion,
                    busqueda.obtenerComparaciones(),
                    logaritmoBaseDos);
        }
    }

    /**
     * Ejecuta las pruebas del algoritmo #2.
     */
    private static void ejecutarMaximoMinimo() {
        MaximoMinimo maximoMinimo = new MaximoMinimo();

        System.out.println("======================================================================");
        System.out.println("MAXIMO Y MINIMO POR DIVIDE Y VENCERAS - O(n)");
        System.out.println("======================================================================");
        System.out.println();
        System.out.printf("%-8s %-12s %-12s %-16s %-12s%n",
                "n", "Minimo", "Maximo", "Comparaciones", "2(n - 1)");
        System.out.println("------------------------------------------------------------------");

        for (int n : TAMANOS) {
            int[] arreglo = crearArregloDescendente(n);

            maximoMinimo.reiniciarComparaciones();
            MaximoMinimo.Resultado resultado = maximoMinimo.encontrar(
                    arreglo, 0, arreglo.length - 1);

            long comparacionesTeoricas = 2L * (n - 1);

            System.out.printf("%-8d %-12d %-12d %-16d %-12d%n",
                    n,
                    resultado.obtenerMinimo(),
                    resultado.obtenerMaximo(),
                    maximoMinimo.obtenerComparaciones(),
                    comparacionesTeoricas);
        }
    }

    /**
     * Crea el arreglo ordenado [0, 1, 2, ..., n - 1].
     */
    private static int[] crearArregloOrdenado(int n) {
        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = i;
        }

        return arreglo;
    }

    /**
     * Crea el arreglo determinista [n - 1, n - 2, ..., 1, 0].
     */
    private static int[] crearArregloDescendente(int n) {
        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = n - 1 - i;
        }

        return arreglo;
    }
}
