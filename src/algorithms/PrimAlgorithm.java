package algorithms;

import java.util.*;

class PrimAlgorithm {

  private static Map<Integer, List<Edge>> graph = new HashMap<>();

  static class Edge implements Comparable<Edge> {
    int vertex;
    int weight;

    Edge(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
      return Integer.compare(this.weight, other.weight);
    }
  }

  private static void addEdge(int u, int v, int weight) {
    graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new Edge(v, weight));
    graph.computeIfAbsent(v, x -> new ArrayList<>()).add(new Edge(u, weight));
  }

  public static void primMST(int start) {
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    Set<Integer> visited = new HashSet<>();
    int mstWeight = 0;

    visited.add(start);
    pq.addAll(graph.get(start));

    System.out.println("Алгоритм Пріма починає з вершини " + start);

    while (!pq.isEmpty()) {
      Edge edge = pq.poll();

      if (visited.contains(edge.vertex)) continue;

      mstWeight += edge.weight;
      visited.add(edge.vertex);

      System.out.println("Додано ребро з вагою " + edge.weight + " до вершини " + edge.vertex);

      for (Edge nextEdge : graph.get(edge.vertex)) {
        if (!visited.contains(nextEdge.vertex)) {
          pq.add(nextEdge);
        }
      }
    }

    System.out.println("Загальна вага мінімального остовного дерева: " + mstWeight);
  }

  public static void main(String[] args) {
    addEdge(1, 3, 2); // Edge from node 1 to node 3 with weight 2
    addEdge(1, 4, 4); // Edge from node 1 to node 4 with weight 4
    addEdge(1, 6, 8); // Edge from node 1 to node 6 with weight 8

    addEdge(2, 4, 6); // Edge from node 2 to node 4 with weight 6
    addEdge(2, 5, 7); // Edge from node 2 to node 5 with weight 7
    addEdge(2, 6, 6); // Edge from node 2 to node 6 with weight 6

    addEdge(3, 1, 2); // Edge from node 3 to node 1 with weight 2
    addEdge(3, 6, 3); // Edge from node 3 to node 6 with weight 3
    addEdge(3, 8, 4); // Edge from node 3 to node 8 with weight 4

    addEdge(4, 1, 4); // Edge from node 4 to node 1 with weight 4
    addEdge(4, 2, 6); // Edge from node 4 to node 2 with weight 6
    addEdge(4, 5, 1); // Edge from node 4 to node 5 with weight 1

    addEdge(5, 2, 7); // Edge from node 5 to node 2 with weight 7
    addEdge(5, 4, 1); // Edge from node 5 to node 4 with weight 1
    addEdge(5, 7, 4); // Edge from node 5 to node 7 with weight 4

    addEdge(6, 1, 8); // Edge from node 6 to node 1 with weight 8
    addEdge(6, 2, 6); // Edge from node 6 to node 2 with weight 6
    addEdge(6, 3, 3); // Edge from node 6 to node 3 with weight 3
    addEdge(6, 8, 5); // Edge from node 6 to node 8 with weight 5
    addEdge(6, 7, 5); // Edge from node 6 to node 7 with weight 5

    addEdge(7, 5, 4); // Edge from node 7 to node 5 with weight 4
    addEdge(7, 6, 5); // Edge from node 7 to node 6 with weight 5

    addEdge(8, 3, 4); // Edge from node 8 to node 3 with weight 4
    addEdge(8, 6, 5); // Edge from node 8 to node 6 with weight 5



    primMST(1);
  }
}
