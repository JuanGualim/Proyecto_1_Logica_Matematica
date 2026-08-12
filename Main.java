public class Main {
    private static final int[] TAMANOS = {16, 32, 64, 128, 256, 512, 1024};

    public static void main(String[] args) {
        ejecutarBusquedaBinaria();
        System.out.println();
        ejecutarMaximoMinimo();
        System.out.println();
        ejecutarMergeSort();
        System.out.println();
        ejecutarCuadratico();
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
     * Ejecuta el ejemplo y las pruebas del algoritmo #3.
     */
    private static void ejecutarMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] ejemplo = {38, 27, 43, 3, 9, 82, 10, 1};

        System.out.println("===============================================================================================");
        System.out.println("MERGE SORT RECURSIVO - O(n lg n)");
        System.out.println("===============================================================================================");
        System.out.println();
        System.out.print("Ejemplo antes:   ");
        imprimirArreglo(ejemplo);

        mergeSort.reiniciarContadores();
        mergeSort.ordenar(ejemplo, 0, ejemplo.length - 1);

        System.out.print("Ejemplo despues: ");
        imprimirArreglo(ejemplo);
        System.out.println();

        System.out.printf("%-8s %-16s %-14s %-20s %-16s %-12s%n",
                "n", "Desordenado", "Ordenado", "Operaciones mezcla",
                "Comparaciones", "n*log2(n)");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (int n : TAMANOS) {
            int[] arreglo = crearArregloDesordenado(n);
            boolean estabaDesordenado = !estaOrdenado(arreglo);

            mergeSort.reiniciarContadores();
            mergeSort.ordenar(arreglo, 0, arreglo.length - 1);

            boolean quedoOrdenado = estaOrdenado(arreglo);
            int logaritmoBaseDos = (int) (Math.log(n) / Math.log(2));
            long referenciaTeorica = (long) n * logaritmoBaseDos;

            System.out.printf("%-8d %-16s %-14s %-20d %-16d %-12d%n",
                    n,
                    estabaDesordenado ? "Si" : "No",
                    quedoOrdenado ? "Si" : "No",
                    mergeSort.obtenerOperacionesMezcla(),
                    mergeSort.obtenerComparaciones(),
                    referenciaTeorica);
        }
    }

    /**
     * Ejecuta las pruebas del algoritmo #4.
     */
    private static void ejecutarCuadratico() {
        int[] tamanosCuadraticos = {10, 20, 40, 80, 160, 320, 640};
        Cuadratico cuadratico = new Cuadratico();
        long operacionesAnteriores = 0;

        System.out.println("================================================================================");
        System.out.println("ALGORITMO RECURSIVO CUADRATICO - O(n^2)");
        System.out.println("================================================================================");
        System.out.println();
        System.out.printf("%-8s %-18s %-18s %-12s %-10s%n",
                "n", "Operaciones", "n(n+1)/2", "Coincide", "Razon");
        System.out.println("--------------------------------------------------------------------");

        for (int n : tamanosCuadraticos) {
            cuadratico.reiniciarContador();
            cuadratico.ejecutar(n);

            long operaciones = cuadratico.obtenerContador();
            long referenciaTeorica = (long) n * (n + 1) / 2;
            boolean coincide = operaciones == referenciaTeorica;

            String razon;
            if (operacionesAnteriores == 0) {
                razon = "-";
            } else {
                razon = String.format("%.4f", (double) operaciones / operacionesAnteriores);
            }

            System.out.printf("%-8d %-18d %-18d %-12s %-10s%n",
                    n,
                    operaciones,
                    referenciaTeorica,
                    coincide ? "Si" : "No",
                    razon);

            operacionesAnteriores = operaciones;
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

    /**
     * Crea una permutacion determinista y desordenada de 0 hasta n - 1.
     */
    private static int[] crearArregloDesordenado(int n) {
        int[] arreglo = new int[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = (i * 37 + 13) % n;
        }

        return arreglo;
    }

    /**
     * Comprueba que cada elemento sea menor o igual que el siguiente.
     */
    private static boolean estaOrdenado(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            if (arreglo[i] > arreglo[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Muestra un arreglo pequeno sin utilizar funciones de ordenamiento.
     */
    private static void imprimirArreglo(int[] arreglo) {
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
