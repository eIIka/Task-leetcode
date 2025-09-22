package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
  int destination;
  int weight;

  public Edge(int destination, int weight) {
    this.destination = destination;
    this.weight = weight;
  }
}

public class Dijkstra {
  public static void dijkstra(List<List<Edge>> graph, int start) {
    int numberOfNodes = graph.size();
    int[] distances = new int[numberOfNodes];
    for (int i = 0; i < numberOfNodes; i++) {
      distances[i] = Integer.MAX_VALUE;
    }
    distances[start] = 0;

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
    priorityQueue.add(new int[]{0, start});

    System.out.println("Початок виконання алгоритму Дейкстри з вершини " + start + ".");

    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.poll();
      int currentDistance = current[0];
      int node = current[1];

      if (currentDistance > distances[node]) {
        continue;
      }

      System.out.println("Обробляється вершина " + node + " з поточною відстанню " + currentDistance + ".");

      for (Edge edge : graph.get(node)) {
        int newDistance = currentDistance + edge.weight;
        if (newDistance < distances[edge.destination]) {
          distances[edge.destination] = newDistance;
          priorityQueue.add(new int[]{newDistance, edge.destination});
          System.out.println("  Оновлено відстань до вершини " + edge.destination + ": " + newDistance);
        }
      }
    }

    System.out.println("\nРезультати виконання алгоритму Дейкстри:");
    for (int i = 1; i < numberOfNodes; i++) {
      if (distances[i] == Integer.MAX_VALUE) {
        System.out.println("Відстань від вершини " + start + " до вершини " + i + ": недосяжна");
      } else {
        System.out.println("Відстань від вершини " + start + " до вершини " + i + ": " + distances[i]);
      }
    }
  }

  public static void main(String[] args) {
    List<List<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      graph.add(new ArrayList<>());
    }

    graph.get(1).add(new Edge(3, 2));  // Edge from node 1 to node 3 with weight 2
    graph.get(1).add(new Edge(4, 4));  // Edge from node 1 to node 4 with weight 4
    graph.get(1).add(new Edge(6, 8));  // Edge from node 1 to node 6 with weight 8

    graph.get(2).add(new Edge(4, 6));  // Edge from node 2 to node 4 with weight 6
    graph.get(2).add(new Edge(5, 7));  // Edge from node 2 to node 5 with weight 7
    graph.get(2).add(new Edge(6, 6));  // Edge from node 2 to node 6 with weight 6

    graph.get(3).add(new Edge(1, 2));  // Edge from node 3 to node 1 with weight 2
    graph.get(3).add(new Edge(6, 3));  // Edge from node 3 to node 6 with weight 3
    graph.get(3).add(new Edge(8, 4));  // Edge from node 3 to node 8 with weight 4

    graph.get(4).add(new Edge(1, 4));  // Edge from node 4 to node 1 with weight 4
    graph.get(4).add(new Edge(2, 6));  // Edge from node 4 to node 2 with weight 6
    graph.get(4).add(new Edge(5, 1));  // Edge from node 4 to node 5 with weight 1

    graph.get(5).add(new Edge(2, 7));  // Edge from node 5 to node 2 with weight 7
    graph.get(5).add(new Edge(4, 1));  // Edge from node 5 to node 4 with weight 1
    graph.get(5).add(new Edge(7, 4));  // Edge from node 5 to node 7 with weight 4

    graph.get(6).add(new Edge(1, 8));  // Edge from node 6 to node 1 with weight 8
    graph.get(6).add(new Edge(2, 6));  // Edge from node 6 to node 2 with weight 6
    graph.get(6).add(new Edge(3, 3));  // Edge from node 6 to node 3 with weight 3
    graph.get(6).add(new Edge(7, 5));  // Edge from node 6 to node 7 with weight 5
    graph.get(6).add(new Edge(8, 5));  // Edge from node 6 to node 8 with weight 5

    graph.get(7).add(new Edge(5, 4));  // Edge from node 7 to node 5 with weight 4
    graph.get(7).add(new Edge(6, 5));  // Edge from node 7 to node 6 with weight 5

    graph.get(8).add(new Edge(3, 4));  // Edge from node 8 to node 3 with weight 4
    graph.get(6).add(new Edge(7, 5));  // Edge from node 6 to node 7 with weight 5



    dijkstra(graph, 1);
  }
}