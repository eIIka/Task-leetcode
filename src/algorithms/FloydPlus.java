package algorithms;

import java.util.*;

public class FloydPlus {
  // ANSI-код для червоного кольору
  public static final String RED = "\u001B[31m";
  // Скидання кольору
  public static final String RESET = "\u001B[0m";

  public static void main(String[] args) {
    int n = 8; // Кількість вершин у графі

    // Ініціалізуємо матрицю відстаней
    int[][] graph = new int[n + 1][n + 1];

    // Заповнюємо матрицю відстаней
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          graph[i][j] = 0; // Відстань від вершини до самої себе дорівнює 0
        } else {
          graph[i][j] = Integer.MAX_VALUE; // Якщо немає прямого зв'язку, відстань нескінченна
        }
      }
    }

    graph[1][3] = 2;   // Edge from node 1 to node 3 with weight 2
    graph[1][4] = 4;   // Edge from node 1 to node 4 with weight 4
    graph[1][6] = 8;   // Edge from node 1 to node 6 with weight 8

    graph[2][4] = 6;   // Edge from node 2 to node 4 with weight 6
    graph[2][5] = 7;   // Edge from node 2 to node 5 with weight 7
    graph[2][6] = 6;   // Edge from node 2 to node 6 with weight 6

    graph[3][1] = 2;   // Edge from node 3 to node 1 with weight 2
    graph[3][6] = 3;   // Edge from node 3 to node 6 with weight 3
    graph[3][8] = 4;   // Edge from node 3 to node 8 with weight 4

    graph[4][1] = 4;   // Edge from node 4 to node 1 with weight 4
    graph[4][2] = 6;   // Edge from node 4 to node 2 with weight 6
    graph[4][5] = 1;   // Edge from node 4 to node 5 with weight 1

    graph[5][2] = 7;   // Edge from node 5 to node 2 with weight 7
    graph[5][4] = 1;   // Edge from node 5 to node 4 with weight 1
    graph[5][7] = 4;   // Edge from node 5 to node 7 with weight 4

    graph[6][1] = 8;
    graph[6][2] = 6;   // Edge from node 6 to node 2 with weight 6
    graph[6][3] = 3;   // Edge from node 6 to node 3 with weight 3
    graph[6][8] = 5;   // Edge from node 6 to node 5 with weight 4
    graph[6][7] = 5;   // Edge from node 6 to node 7 with weight 5

    graph[7][5] = 4;   // Edge from node 7 to node 5 with weight 4
    graph[7][6] = 5;   // Edge from node 7 to node 6 with weight 5

    graph[8][3] = 4;   // Edge from node 8 to node 3 with weight 4
    graph[8][6] = 5;   // Edge from node 8 to node 6 with weight 5

    // Алгоритм Флойда
    floydWarshall(graph, n);
  }

  public static void floydWarshall(int[][] graph, int n) {
    int[][] dist = new int[n + 1][n + 1];

    // Ініціалізуємо відстані на основі початкового графа
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dist[i][j] = graph[i][j];
      }
    }

    // Виведення початкової таблиці
    System.out.println("Початкова матриця відстаней:");
    printMatrix(dist, n, null);

    // Алгоритм Флойда з проміжними результатами
    for (int k = 1; k <= n; k++) {
      System.out.println("\nКрок " + k + " (використовуємо вершину " + k + " як проміжну):");

      int[][] prevDist = copyMatrix(dist, n); // Зберігаємо попередній стан матриці

      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }
      printMatrix(dist, n, prevDist); // Виводимо таблицю після кожного кроку з виділенням змін
    }

    // Виведення кінцевої таблиці з результатами
    System.out.println("\nКінцева матриця найкоротших відстаней:");
    printMatrix(dist, n, null);
  }

  // Метод для копіювання матриці
  public static int[][] copyMatrix(int[][] matrix, int n) {
    int[][] copy = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      System.arraycopy(matrix[i], 1, copy[i], 1, n);
    }
    return copy;
  }

  // Метод для форматованого виведення таблиці з виділенням змін
  public static void printMatrix(int[][] matrix, int n, int[][] prevMatrix) {
    System.out.print("     ");
    for (int i = 1; i <= n; i++) {
      System.out.printf("%4d", i);
    }
    System.out.println();
    System.out.println("    " + "-".repeat(4 * n));

    for (int i = 1; i <= n; i++) {
      System.out.printf("%2d | ", i);
      for (int j = 1; j <= n; j++) {
        if (matrix[i][j] == Integer.MAX_VALUE) {
          System.out.print(" INF"); // Якщо немає шляху, виводимо INF
        } else {
          // Виділяємо червоним, якщо значення змінилося
          if (prevMatrix != null && matrix[i][j] != prevMatrix[i][j]) {
            System.out.print(RED + String.format("%4d", matrix[i][j]) + RESET);
          } else {
            System.out.printf("%4d", matrix[i][j]);
          }
        }
      }
      System.out.println();
    }
  }
}