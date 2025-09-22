package algorithms;

import java.util.Arrays;
public class sdsda {
  static final int INF = 9999999;
  static final int V = 8;
  static int[][] graph = {
      {0, INF, 2, 4, INF, 8, INF, INF}, // Вершина 1
      {INF, 0, INF, 6, 7, 6, INF, INF}, // Вершина 2
      {2, INF, 0, INF, INF, 3, INF, 4}, // Вершина 3
      {4, 6, INF, 0, 1, INF, INF, INF}, // Вершина 4
      {INF, 7, INF, 1, 0, INF, 4, INF}, // Вершина 5
      {8, 6, 3, INF, INF, 0, 5, 5},     // Вершина 6
      {INF, INF, INF, INF, 4, 5, 0, INF}, // Вершина 7
      {INF, INF, 4, INF, INF, 5, INF, 0}  // Вершина 8
  };
  public static void main(String[] args) {
    int noEdge = 0;
    boolean[] selected = new boolean[V];
    Arrays.fill(selected, false);
    selected[0] = true;
    System.out.println("Edge : Weight");
    while (noEdge < V - 1) {
      int min = INF;
      int x = 0, y = 0;
      for (int i = 0; i < V; i++) {
        if (selected[i]) {
          for (int j = 0; j < V; j++) {
            if (!selected[j] && graph[i][j] != INF) {
              if (min > graph[i][j]) {
                min = graph[i][j];
                x = i;
                y = j;
              }
            }
          }
        }
      }
      System.out.println((x + 1) + " - " + (y + 1) + " : " + graph[x][y]);
      selected[y] = true;
      noEdge++;
    }
  }
}

