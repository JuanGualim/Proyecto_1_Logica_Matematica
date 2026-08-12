public class Main {
    public static void main(String[] args) {
        int[] tamanos = {16, 32, 64, 128, 256, 512, 1024};
        BusquedaBinaria busqueda = new BusquedaBinaria();

        System.out.println("============================================================");
        System.out.println("BUSQUEDA BINARIA RECURSIVA - O(lg n)");
        System.out.println("============================================================");
        System.out.println();
        System.out.printf("%-8s %-10s %-12s %-10s %-14s %-8s%n",
                "n", "Elemento", "Encontrado", "Posicion", "Comparaciones", "log2(n)");
        System.out.println("--------------------------------------------------------------------------");

        for (int n : tamanos) {
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
     * Crea el arreglo ordenado [0, 1, 2, ..., n - 1].
     */
    private static int[] crearArregloOrdenado(int n) {
        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = i;
        }

        return arreglo;
    }
}
