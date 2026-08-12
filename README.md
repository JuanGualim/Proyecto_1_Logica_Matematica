# Proyecto 1 — Lógica Matemática

Proyecto universitario en Java para estudiar relaciones de recurrencia y comprobar experimentalmente distintas complejidades algorítmicas.

La evidencia principal se obtiene mediante contadores de comparaciones, operaciones, resultados generados o movimientos, en lugar de utilizar únicamente tiempos de ejecución.

## Algoritmos incluidos

| # | Algoritmo | Recurrencia | Complejidad |
|---|---|---|---|
| 1 | Búsqueda binaria recursiva | `T(n) = T(n/2) + 2` | `O(lg n)` |
| 2 | Máximo y mínimo por divide y vencerás | `T(n) = 2T(n/2) + 2` | `O(n)` |
| 3 | Merge Sort recursivo | `T(n) = 2T(n/2) + n` | `O(n lg n)` |
| 4 | Algoritmo recursivo cuadrático | `T(n) = T(n-1) + n` | `O(n²)` |
| 5 | Algoritmo recursivo cúbico | `T(n) = T(n-1) + n²` | `O(n³)` |
| 6 | Algoritmo recursivo potencia diez | `T(n) = T(n-1) + n⁹` | `O(n¹⁰)` |
| 7 | Generación recursiva de permutaciones | `P(n) = nP(n-1)` | `O(n!)` |
| 8 | Torres de Hanoi | `H(n) = 2H(n-1) + 1` | `O(2ⁿ)` |

## Requisitos

- Java Development Kit (JDK) 8 o posterior.
- Una terminal para compilar y ejecutar el programa.

## Compilación y ejecución

Desde la carpeta del proyecto:

```bash
javac *.java
java Main
```

`Main.java` ejecuta los ocho experimentos en orden y muestra tablas que comparan los contadores experimentales con sus referencias matemáticas.

## Estructura

```text
Main.java                    Pruebas y salida de todos los algoritmos
BusquedaBinaria.java         Búsqueda binaria recursiva
MaximoMinimo.java            Máximo y mínimo por divide y vencerás
MergeSort.java               Ordenamiento Merge Sort
Cuadratico.java              Recurrencia de orden cuadrático
Cubico.java                  Recurrencia de orden cúbico
PotenciaDiez.java            Recurrencia de orden n¹⁰
Permutaciones.java           Generación de todas las permutaciones
Hanoi.java                   Torres de Hanoi
proyecto_1.pdf               Instrucciones originales del proyecto
Guia_Estudio_Proyecto1_Logica_Matematica.tex
                             Guía de estudio en formato LaTeX
```

## Nota

Los contadores no representan siempre todas las instrucciones ejecutadas por Java. Cada clase documenta qué operación específica se está midiendo para relacionarla claramente con su recurrencia.
