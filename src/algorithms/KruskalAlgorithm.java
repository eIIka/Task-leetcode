package algorithms;

import java.util.*;

class KruskalAlgorithm {

  static class Edge implements Comparable<Edge> {
    int u, v, weight;

    Edge(int u, int v, int weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
      return Integer.compare(this.weight, other.weight);
    }
  }

  static class UnionFind {
    private int[] parent, rank;

    UnionFind(int n) {
      parent = new int[n + 1];
      rank = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        parent[i] = i;
        rank[i] = 0;
      }
    }

    int find(int u) {
      if (parent[u] != u) {
        parent[u] = find(parent[u]);
      }
      return parent[u];
    }

    boolean union(int u, int v) {
      int rootU = find(u);
      int rootV = find(v);
      if (rootU == rootV) return false;

      if (rank[rootU] > rank[rootV]) {
        parent[rootV] = rootU;
      } else if (rank[rootU] < rank[rootV]) {
        parent[rootU] = rootV;
      } else {
        parent[rootV] = rootU;
        rank[rootU]++;
      }
      return true;
    }
  }

  private static List<Edge> edges = new ArrayList<>();

  private static void addEdge(int u, int v, int weight) {
    edges.add(new Edge(u, v, weight));
  }

  public static void kruskalMST(int numVertices) {

    Collections.sort(edges);
    UnionFind uf = new UnionFind(numVertices);

    int mstWeight = 0;
    List<Edge> mstEdges = new ArrayList<>();

    System.out.println("Алгоритм Крускала починає обробку ребер.");

    for (Edge edge : edges) {
      if (uf.union(edge.u, edge.v)) {
        mstWeight += edge.weight;
        mstEdges.add(edge);
        System.out.println("Додано ребро: (" + edge.u + ", " + edge.v + ") з вагою " + edge.weight);
      }
    }

    System.out.println("Загальна вага мінімального остовного дерева: " + mstWeight);
    System.out.println("Ребра, що входять до мінімального остовного дерева:");
    for (Edge edge : mstEdges) {
      System.out.println("(" + edge.u + ", " + edge.v + ") з вагою " + edge.weight);
    }
  }

  public static void main(String[] args) {
    addEdge(1, 2, 2);
    addEdge(1, 3, 5);
    addEdge(1, 4, 1);
    addEdge(1, 7, 1);
    addEdge(2, 4, 3);
    addEdge(2, 5, 1);
    addEdge(3, 5, 2);
    addEdge(3, 6, 4);
    addEdge(3, 7, 4);
    addEdge(4, 5, 9);
    addEdge(4, 6, 5);
    addEdge(4, 7, 9);
    addEdge(5, 6, 3);
    addEdge(6, 8, 1);
    addEdge(7, 8, 6);

    kruskalMST(8);
  }
}

